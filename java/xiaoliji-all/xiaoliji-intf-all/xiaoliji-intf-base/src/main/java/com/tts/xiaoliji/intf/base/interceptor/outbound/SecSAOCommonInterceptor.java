package com.tts.xiaoliji.intf.base.interceptor.outbound;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.IntfSession;

import cn.openlo.exception.LOSException;
import cn.openlo.service.OutboundServiceInterceptor;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("secSAOCommonInterceptor")
public class SecSAOCommonInterceptor implements OutboundServiceInterceptor {
	public boolean match(ServiceRequest request, ServiceContext serviceContext) {
		return true;
	}

	public int getOrder() {
		return 1;
	}

	@SuppressWarnings("unchecked")
	public void intercept(ServiceRequest request, ServiceContext serviceContext) throws LOSException {
		Map<String, Object> params = (Map<String, Object>) request.getParameters();

		params.put("versionNo", IntfSession.getSession().getAttribute("SESSION_CLIENT_VERSION"));
	}
}
