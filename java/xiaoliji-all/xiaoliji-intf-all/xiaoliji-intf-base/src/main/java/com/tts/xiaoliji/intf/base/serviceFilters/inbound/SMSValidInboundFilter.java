package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;
import com.tts.xiaoliji.intf.base.service.OTPService;
import com.tts.xiaoliji.intf.base.utils.IntfSessionUtil;

import cn.openlo.exception.LOSException;
import cn.openlo.gear.exception.GenericBizException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("smsValidFilter")
public class SMSValidInboundFilter extends AbstractIntfInboudFilter {
	@Autowired
	private OTPService otpService;

	public boolean matches(ServiceRequest request, ServiceContext serviceContext) {
		return true;
	}

	public int getOrder() {
		return 120;
	}

	public String getName() {
		return "smsValidFilter";
	}

	@SuppressWarnings("unchecked")
	public void preFilter(ServiceRequest request, ServiceContext serviceContext) throws LOSException {
		Map<String, Object> paramters = (Map<String, Object>) request.getParameters();

		String smsToken = (String) paramters.get("phoneCheckCode");
		Map<String, Object> result = null;
		String smsPhone = null;
		try {
			result = this.otpService.smsVerify(smsToken);
			String uploadPhone = (String) paramters.get("phone");
			smsPhone = (String) result.get("smsPhone");
			if (StringUtils.hasText(uploadPhone)) {
				String myPhone = handleMaskMobileNo(uploadPhone);
				if (!myPhone.equals(smsPhone)) {
					throw new InvalidConditionException("300113");
				}
			}
			paramters.put("_checkSuccessMobile", smsPhone);
		} catch (GenericBizException e) {

			if (StringUtils.hasText(smsPhone)) {
				Map<String, Object> recordMap = IntfSessionUtil.getMobileCheckRecord(smsPhone);
				if (recordMap != null) {
					int errCount = ((Integer) recordMap.get("_errCount")).intValue();
					if (errCount == 1) {
						e.setErrorMessage("短信验证码验证失败");
					} else {
						e.setErrorMessage("验证码错误，你还有" + (5 - errCount) + "次验证机会");
					}
					if (errCount >= 2) {
						GenericBizException graphException = new GenericBizException("800101");
						graphException.setErrorMessage(e.getErrorMessage());
					}
				}
			}
			throw e;
		} finally {
		}
	}

	private String handleMaskMobileNo(String phone) {
		if (phone.contains("*")) {
			String rawMobileNo = (String) IntfSession.getSession().getAttribute("register_raw_phone", String.class);
			if (rawMobileNo != null) {
				return rawMobileNo;
			}
		}
		return phone;
	}
}
