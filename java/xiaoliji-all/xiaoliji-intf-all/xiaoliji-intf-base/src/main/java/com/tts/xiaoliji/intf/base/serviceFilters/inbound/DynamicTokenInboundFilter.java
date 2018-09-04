package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.exception.InvalidInputException;
import com.tts.xiaoliji.intf.base.utils.IntfSessionUtil;

import cn.openlo.exception.LOSException;
import cn.openlo.gear.exception.GenericBizException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("dynamicTokenFilter")
public class DynamicTokenInboundFilter extends AbstractIntfInboudFilter {
//	private static final String USER_NAME = "userName";

	public int getOrder() {
		return 20;
	}

	public boolean matches(ServiceRequest paramServiceRequest, ServiceContext paramServiceContext) {
		return true;
	}

	public String getName() {
		return "dynamicTokenFilter";
	}

	public void preFilter(ServiceRequest paramServiceRequest, ServiceContext serviceContext) throws LOSException {
		Map<String, String> properties = serviceContext.getLosProperties();
		int graphicType = 0;
		String type = (String) properties.get("graphicType");
		if (StringUtils.hasText(type)) {
			graphicType = Integer.valueOf(type).intValue();
		}
		String dynamicToken = (String) paramServiceRequest.getParameters().get("dynamicToken");
		String dynamicTokenInServer = (String) IntfSession.getSession().getAttribute("dynamicToken", String.class);

		IntfSession.getSession().removeAttribute("dynamicToken");
		if (graphicType == 2) {
			String loginName = (String) paramServiceRequest.getParameters().get("loginName");
			if (loginName == null) {
				throw new InvalidInputException("loginName.is.null");
			}
			Integer errcnt = IntfSessionUtil.getPwdErrCnt(loginName);
			if ((errcnt == null) || (errcnt.intValue() < 2)) {
				return;
			}
		} else if (graphicType == 3) {
			String phone = (String) paramServiceRequest.getParameters().get("phone");
			if (StringUtils.isEmpty(phone)) {
				Map sendRecord = (Map) IntfSession.getSession().getAttribute("_mobileSendRecords");
				if (sendRecord != null) {
					phone = (String) sendRecord.get("_lastSendMobile");
				}
				if (!StringUtils.hasText(phone)) {
					phone = (String) IntfSession.getSession().getAttribute("_last_send_otp_mobile", String.class);
				}
			}
			if (phone == null) {
				throw new InvalidInputException("phone.is.null");
			}
			Integer err = IntfSessionUtil.getMobileCheckError(phone);
			if ((err == null) || (err.intValue() < 2)) {
				return;
			}
		} else if (graphicType == 1) {
			if (IntfSession.getSession().isNew()) {
				throw new InvalidInputException("300200");
			}
		}
		if (StringUtils.isEmpty(dynamicToken)) {
			throwNeedDynamicException(graphicType);
		}
		if (dynamicTokenInServer == null) {
			throw new InvalidInputException("dynamicTokenInServer.is.null");
		}
		if (!dynamicToken.equalsIgnoreCase(dynamicTokenInServer)) {
			throw new InvalidInputException("dynamicToken.check.error");
		}
	}

	private void throwNeedDynamicException(int graphicType) throws GenericBizException {
		if (graphicType == 2) {
			throw new GenericBizException("800101", new String[] { "账号" });
		}
		if (graphicType == 3) {
			throw new GenericBizException("800101", new String[] { "手机号" });
		}
		throw new InvalidInputException("300200");
	}
}
