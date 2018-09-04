package com.tts.xiaoliji.intf.base.serviceFilters.outbound;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import cn.openlo.exception.LOSException;
import cn.openlo.service.OutboundServiceFilter;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

public abstract class AbstractIntfOutboundFilter implements OutboundServiceFilter {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public abstract String getName();

	public abstract void afterFilter(ServiceRequest paramServiceRequest, ServiceResponse paramServiceResponse,
			ServiceContext paramServiceContext) throws LOSException;

	@SuppressWarnings("unchecked")
	public boolean matches(ServiceRequest request, ServiceContext serviceContext) {
		boolean result = false;

		Set<String> filterSets = (Set<String>) serviceContext.getData("_filter_name_sets");
		if ((!CollectionUtils.isEmpty(filterSets)) && (filterSets.contains(getName()))) {
			result = true;
		}
		return result;
	}

	public void doFilter(ServiceRequest request, ServiceResponse serviceResponse, ServiceContext serviceContext) {
		try {
			afterFilter(request, serviceResponse, serviceContext);
		} catch (LOSException exception) {
			this.logger.error(exception.getMessage(), exception);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}
	}
}
