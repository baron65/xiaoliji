package com.tts.xiaoliji.intf.base.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.constant.EnumSmsTemplateInfo;
import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;
import com.tts.xiaoliji.intf.base.exception.InvalidInputException;
import com.tts.xiaoliji.intf.base.sao.OTPSAO;
import com.tts.xiaoliji.intf.base.utils.DateTimeUtil;
import com.tts.xiaoliji.intf.base.utils.IntfSessionUtil;

import cn.openlo.exception.LOSException;
import cn.openlo.gear.cache.Cache;

@Component
public class OTPServiceImpl implements OTPService {
	private static final Logger logger = LoggerFactory.getLogger(OTPServiceImpl.class);
	@Autowired
	private OTPSAO otpSAO;
	private static final String DEFAULT_DEV_SMS_TOKEN = "147258";
	@Autowired
	@Qualifier("gearCache")
	private Cache cacheService;

	public Map<String, Object> sendSms(String phoneNo, String type) throws LOSException {
		return sendSms(phoneNo, type, null);
	}

	public Map<String, Object> sendSms(String phoneNo, String type, Map<String, String> content) throws LOSException {
		EnumSmsTemplateInfo templateInfo = EnumSmsTemplateInfo.getSmsTemplateInfo(type);
		String smsTemplateId = templateInfo.getTemplateId();
		if (StringUtils.isEmpty(smsTemplateId)) {
			throw new InvalidInputException("illegal.sms.type");
		}
		String sendPhone = getSendPhoneNo(phoneNo, templateInfo);

		isInvitedOnly(sendPhone, type);
		Map<String, Object> result = sendSmsWithId(sendPhone, smsTemplateId, content);
		result.put("phoneNo", sendPhone);
		return result;
	}

	public Map<String, Object> smsVerify(String phoneCheckCode) throws LOSException {
		String phoneNo = extractOTPPhone(phoneCheckCode);

		Map<String, Object> result = null;
		try {
			// Map<String, Object> params = generateVerifyMap(phoneNo,
			// phoneCheckCode);
			if (isDevelopEnv()) {
				if (!DEFAULT_DEV_SMS_TOKEN.equals(phoneCheckCode)) {
					this.otpSAO.verifySms(phoneNo, phoneCheckCode);
				}
			} else {
				this.otpSAO.verifySms(phoneNo, phoneCheckCode);
			}
			result = new HashMap<String, Object>();
		} finally {
			updateVeifySession(phoneNo, result);
		}

		result.put("smsPhone", phoneNo);
		IntfSession.getSession().setAttribute("_checkSuccessMobile", phoneNo);
		return result;
	}

	private Map<String, Object> sendSmsWithId(String phoneNo, String templateId, Map<String, String> content)
			throws LOSException {
		logger.debug("smsSend by " + phoneNo);

		Map<String, Object> recordMap = smsSendPreCheck(phoneNo);

		// Map<String, Object> params = generateSendMap(phoneNo, templateId,
		// content);

		this.otpSAO.sendSms(phoneNo, templateId, content);
		Map<String, Object> result = new HashMap<String, Object>();
		updateSendSession(phoneNo, recordMap);
		return result;
	}

	private Map<String, Object> smsSendPreCheck(String phoneNo) throws LOSException {
		if (StringUtils.isEmpty(phoneNo)) {
			throw new InvalidInputException("sms.phone.empty");
		}
		Map<String, Object> recordMap = checkSmsCheckErrCount(phoneNo);
		return recordMap;
	}

	private Map<String, Object> checkSmsCheckErrCount(String phoneNo) throws LOSException {
		Map<String, Object> recordMap = IntfSessionUtil.getMobileCheckRecord(phoneNo);
		int errCount = 0;
		int totalSendCnt = 0;
		if (recordMap != null) {
			if (recordMap.get("_errCount") != null) {
				errCount = ((Integer) recordMap.get("_errCount")).intValue();
			} else {
				recordMap.put("_errCount", Integer.valueOf(0));
			}
			if (recordMap.get("_totalSendCount") != null) {
				totalSendCnt = ((Integer) recordMap.get("_totalSendCount")).intValue();
			} else {
				recordMap.put("_totalSendCount", Integer.valueOf(0));
			}
			Date nowDate = DateTimeUtil.now();
			Date lastSendDate = null;
			if ((recordMap.get("_lastSendTime") != null) && (!"".equals(recordMap.get("_lastSendTime")))) {
				lastSendDate = DateTimeUtil.parseDefaultTime((String) recordMap.get("_lastSendTime"));
				if (nowDate.getTime() - lastSendDate.getTime() < 60000L) {
					throw new InvalidConditionException("sms.too.fast");
				}
			}
			if ((errCount >= 5) || (totalSendCnt >= 5)) {
				if ((lastSendDate != null) && (nowDate.getTime() - lastSendDate.getTime() > 3600000L)) {
					recordMap.put("_errCount", Integer.valueOf(0));
					recordMap.put("_totalSendCount", Integer.valueOf(0));
					return recordMap;
				}
				if (totalSendCnt >= 5) {
					throw new InvalidConditionException("sms.send.too.much");
				}
				throw new InvalidConditionException("sms.too.much");
			}
		} else {
			recordMap = new HashMap<String, Object>();
			recordMap.put("_errCount", Integer.valueOf(0));
			recordMap.put("_totalSendCount", Integer.valueOf(0));
		}
		return recordMap;
	}

	private String getSendPhoneNo(String uploadPhone, EnumSmsTemplateInfo templateInfo) throws LOSException {
		String phoneNo = "";
		if (EnumSmsTemplateInfo.EnumPhoneType.SessionUser.equals(templateInfo.getPhoneType())) {
			if (!IntfSession.getSession().isLogin()) {
				throw new InvalidConditionException("user.invalid");
			}
			phoneNo = IntfSession.getSession().getUser().getMobilePhone();
		} else if (EnumSmsTemplateInfo.EnumPhoneType.SpecialSession.equals(templateInfo.getPhoneType())) {
			phoneNo = (String) IntfSession.getSession().getAttribute("phoneNo");
		} else {
			phoneNo = uploadPhone;
		}
		return phoneNo;
	}

//	private Map<String, Object> generateSendMap(String phoneNo, String templateId, Map<String, String> content) {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("phone", phoneNo);
//		params.put("otpTpl", templateId);
//		if (content != null) {
//			params.put("smsParam", content);
//		}
//		return params;
//	}

	private void updateSendSession(String phoneNo, Map<String, Object> checkRecord) {
		checkRecord.put("_lastSendTime", DateTimeUtil.formatNow());
		int totalSendCnt = ((Integer) checkRecord.get("_totalSendCount")).intValue() + 1;
		checkRecord.put("_totalSendCount", Integer.valueOf(totalSendCnt));

		IntfSessionUtil.setMobileCheckRecord(phoneNo, checkRecord);
		checkRecord.put("_lastSendMobile", phoneNo);
		IntfSession.getSession().setAttribute("_mobileSendRecords", checkRecord);
		IntfSession.getSession().setAttribute("_last_send_otp_mobile", phoneNo);
	}

	@SuppressWarnings("unchecked")
	private String extractOTPPhone(String phoneCheckCode) throws LOSException {
		if (StringUtils.isEmpty(phoneCheckCode)) {
			throw new InvalidInputException("sms.code.empty");
		}
		Map<String, Object> sendRecord = (Map<String, Object>) IntfSession.getSession()
				.getAttribute("_mobileSendRecords");
		if (sendRecord == null) {
			throw new InvalidConditionException("sms.record.empty");
		}
		String phoneNo = (String) sendRecord.get("_lastSendMobile");
		return phoneNo;
	}

//	private Map<String, Object> generateVerifyMap(String phoneNo, String phoneCheckCode) {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("otpCode", phoneCheckCode);
//		params.put("phone", phoneNo);
//		return params;
//	}

	private void updateVeifySession(String phoneNo, Map<String, Object> result) {
		int checkErrCount = 0;
		Map<String, Object> recordMap = IntfSessionUtil.getMobileCheckRecord(phoneNo);
		Map<String, Object> checkRecord = new HashMap<String, Object>();
		if (recordMap != null) {
			checkErrCount = ((Integer) recordMap.get("_errCount")).intValue();
			checkRecord.put("_lastSendTime", recordMap.get("_lastSendTime"));
		}
		if (result == null) {
			checkErrCount += 1;
		} else {
			checkErrCount = 0;
			checkRecord.put("_lastSendTime", "");
			checkRecord.put("_totalSendCount", Integer.valueOf(0));
		}
		checkRecord.put("_errCount", Integer.valueOf(checkErrCount));
		if ((checkErrCount == 0) || (checkErrCount >= 3)) {
			IntfSession.getSession().removeAttribute("_mobileSendRecords");
		}
		IntfSessionUtil.setMobileCheckRecord(phoneNo, checkRecord);
	}

	private boolean isDevelopEnv() {
		boolean result = false;
		String envir = (String) this.cacheService.get("environmentInfo", String.class);
		if (("develop".equalsIgnoreCase(envir)) || ("test".equalsIgnoreCase(envir))) {
			result = true;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	private void isInvitedOnly(String sendPhone, String type) {
		if (IntfSession.getSession().isLogin()) {
			return;
		}
		Boolean vipOnly = (Boolean) this.cacheService.get("vipCheckFlag", Boolean.class);
		if ((vipOnly != null) && (vipOnly.booleanValue())
				&& (("regist".equals(type)) || (EnumSmsTemplateInfo.LoginPwd.getType().equals(type)))) {
			Set<String> phoneSet = (Set<String>) this.cacheService.get("vipMobileSet", Set.class);
			if ((phoneSet == null) || (!phoneSet.contains(sendPhone))) {
				throw new InvalidConditionException("invited.customer.only");
			}
		}
	}
}
