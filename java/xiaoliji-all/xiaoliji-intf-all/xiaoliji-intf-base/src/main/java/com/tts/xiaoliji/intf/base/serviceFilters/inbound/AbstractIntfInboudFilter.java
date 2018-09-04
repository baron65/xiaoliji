package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.HashSet;
import java.util.Set;

import cn.openlo.exception.LOSException;
import cn.openlo.service.InboundServiceFilter;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

public abstract class AbstractIntfInboudFilter implements InboundServiceFilter {
	public abstract void preFilter(ServiceRequest paramServiceRequest, ServiceContext paramServiceContext)
			throws LOSException;

	public abstract String getName();

	public void doFilter(ServiceRequest request, ServiceContext serviceContext) throws LOSException {
		preFilter(request, serviceContext);
		setNameToContext(serviceContext);
	}

	@SuppressWarnings("unchecked")
	public void setNameToContext(ServiceContext serviceContext) {
		Set<String> filterSets = (Set<String>) serviceContext.getData("_filter_name_sets");
		if (filterSets == null) {
			filterSets = new HashSet<String>();
		}
		filterSets.add(getName());
		serviceContext.setData("_filter_name_sets", filterSets);
	}
}
