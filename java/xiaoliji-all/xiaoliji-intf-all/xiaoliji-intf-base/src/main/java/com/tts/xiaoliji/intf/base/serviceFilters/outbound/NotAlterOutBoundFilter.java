package com.tts.xiaoliji.intf.base.serviceFilters.outbound;

import java.util.Map;

import org.springframework.stereotype.Component;

import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("serviceNotAlterOutFilter")
public class NotAlterOutBoundFilter extends AbstractIntfOutboundFilter {
	public String getName() {
		return "notAlterPrepareFilter";
	}

	public int getOrder() {
		return 100;
	}

	public void afterFilter(ServiceRequest paramServiceRequest, ServiceResponse paramServiceResponse,
			ServiceContext paramServiceContext) {
		Map<String, Object> confirmData = (Map) paramServiceContext.getData("confirmData");
		((Map) paramServiceResponse.getModel()).putAll(confirmData);
	}
}
