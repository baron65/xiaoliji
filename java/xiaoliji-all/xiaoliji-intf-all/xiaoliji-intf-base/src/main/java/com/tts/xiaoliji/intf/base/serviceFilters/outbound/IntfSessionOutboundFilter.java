package com.tts.xiaoliji.intf.base.serviceFilters.outbound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.IntfSession;

import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("intfSessionOutboundFilter")
public class IntfSessionOutboundFilter extends AbstractIntfOutboundFilter {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public String getName() {
		return "intfSessionFilter";
	}

	public int getOrder() {
		return 0;
	}

	public void afterFilter(ServiceRequest paramServiceRequest, ServiceResponse paramServiceResponse,
			ServiceContext paramServiceContext) {
		IntfSession session = IntfSession.getSession();
		session.dispose(paramServiceResponse);
		this.logger.info("[[session dispose]] sessionId : " + session.getId());
	}
}
