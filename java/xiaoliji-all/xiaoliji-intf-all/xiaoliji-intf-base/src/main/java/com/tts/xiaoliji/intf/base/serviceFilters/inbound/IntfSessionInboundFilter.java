package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.IntfSessionManager;
import com.tts.xiaoliji.intf.base.utils.IntfMapUtils;

import cn.openlo.common.util.LOJsonUtil;
import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("intfSessionInboundFilter")
public class IntfSessionInboundFilter extends AbstractIntfInboudFilter {
	@Autowired
	private IntfSessionManager intfSessioManager;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public boolean matches(ServiceRequest paramServiceRequest, ServiceContext paramServiceContext) {
		return true;
	}

	public int getOrder() {
		return 0;
	}

	public String getName() {
		return "intfSessionFilter";
	}

	public void preFilter(ServiceRequest paramServiceRequest, ServiceContext paramServiceContext) throws LOSException {
		this.logger.debug("serviceId is :" + paramServiceRequest.getServiceName() + " params:"
				+ LOJsonUtil.objectToJsonString(paramServiceRequest.getParameters()));

		IntfSession session = this.intfSessioManager.createIntfSession();
		session.init(paramServiceRequest);
		this.logger.info("[[session inited]] sessionId : " + session.getId() + " isNew:" + session.isNew() + " isLogin:"
				+ session.isLogin());
		resolveReqData(paramServiceRequest);
		updateSessionInfo(paramServiceRequest);
	}

	private void resolveReqData(ServiceRequest serviceRequest) {
		Object reqData = serviceRequest.getParameters().get("reqData");
		if ((reqData instanceof Map)) {
			serviceRequest.getParameters().putAll(IntfMapUtils.removeNullValue((Map) reqData));
		}
	}

	@SuppressWarnings("unchecked")
	protected void updateSessionInfo(ServiceRequest serviceRequest) throws LOSException {
		Map<String, Object> requestParams = (Map<String, Object>) serviceRequest.getParameters();
		String channelId = (String) requestParams.get("_channel_id");
		String versionNo = (String) requestParams.get("_client_version_no");

		IntfSession session = IntfSession.getSession();
		if (session == null) {
			this.logger.error("session is null, shouldn't happend");
		} else {
			if (StringUtils.hasText(channelId)) {
				session.setAttribute("_channel_id", channelId);
			}
			String redisVersionNo = (String) session.getAttribute("SESSION_CLIENT_VERSION");
			if (StringUtils.hasText(versionNo)) {
				if ((StringUtils.isEmpty(redisVersionNo))
						|| ((StringUtils.hasText(redisVersionNo)) && (!versionNo.equals(redisVersionNo)))) {
					if (this.logger.isDebugEnabled()) {
						this.logger.debug("versionNo is " + versionNo);
					}
					session.setAttribute("SESSION_CLIENT_VERSION", versionNo);
				}
			}
		}
	}
}
