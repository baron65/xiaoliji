package com.tts.xiaoliji.intf.base.serviceFilters.outbound;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.common.bean.LoginUser;
import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.constant.EnumEventName;
import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;
import com.tts.xiaoliji.intf.base.utils.DateTimeUtil;

import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("riskEventOutboundFilter")
public class RiskEventOutboundFilter extends AbstractIntfOutboundFilter {
	private Logger logger = LoggerFactory.getLogger(getClass());
//	@Autowired
//	private IntfRiskSAO intfRiskSAO;

	public boolean matches(ServiceRequest request, ServiceContext serviceContext) {
		return true;
	}

	public int getOrder() {
		return Integer.MAX_VALUE;
	}

	public String getName() {
		return "RiskEventFilter";
	}

	public void afterFilter(ServiceRequest request, ServiceResponse serviceResponse, ServiceContext serviceContext)
			throws LOSException {
		this.logger.debug("执行用户事件发送MQ：" + serviceContext.getLosProperties());
		if ("000000".equals(serviceResponse.getResponseCode())) {
			this.logger.debug("事件成功，发送MQ！");
			Map<String, String> properties = serviceContext.getLosProperties();
			String eventName = (String) properties.get("eventName");
			if (StringUtils.isEmpty(eventName)) {
				this.logger.error("风险事件名eventName为空！");
				throw new InvalidConditionException("eventName.is.empty");
			}
			Map<String, Object> session = new HashMap<String, Object>();
			if (EnumEventName.REGIST.getName().equals(eventName)) {
				session.put("register_user_id", IntfSession.getSession().getAttribute("register_user_id"));
				session.put("register_phone", IntfSession.getSession().getAttribute("register_phone"));
				session.put("register_device_id", IntfSession.getSession().getAttribute("register_device_id"));
			} else if (EnumEventName.LOGIN.getName().equals(eventName)) {
				LoginUser user = IntfSession.getSession().getUser();
				session.put("USER", user);
			}
			Map<String, Object> msg = new HashMap<String, Object>();
			msg.put("session", session);
			msg.put("request", request.getParameters());
			msg.put("response", serviceResponse.getModel());

			Map<String, Object> eventParams = new HashMap<String, Object>();
			eventParams.put("eventName", eventName);
			eventParams.put("eventTime", DateTimeUtil.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
			eventParams.put("msg", msg);
			// try 暂没有风验控制,暂不通知
			// {
			// this.intfRiskSAO.eventReceive(eventParams);
			// }
			// catch (Exception e)
			// {
			// this.logger.error("发送事件[" + eventName + "]至MQ异常", e);
			// }
		}
	}
}