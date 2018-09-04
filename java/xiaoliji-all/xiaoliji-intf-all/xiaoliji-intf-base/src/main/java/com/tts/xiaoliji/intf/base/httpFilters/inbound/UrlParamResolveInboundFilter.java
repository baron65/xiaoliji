package com.tts.xiaoliji.intf.base.httpFilters.inbound;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.openlo.exception.LOException;
import cn.openlo.exception.LOSException;
import cn.openlo.protocol.http.JettyRelatedUtil;
import cn.openlo.service.HttpInboundServiceFilter;
import cn.openlo.service.ServiceContext;

@Component("urlParamResolverFilter")
public class UrlParamResolveInboundFilter implements HttpInboundServiceFilter {
	Logger logger = LoggerFactory.getLogger(getClass());

	public int getOrder() {
		return 5;
	}

	public void doFilter(HttpServletRequest request, ServiceContext context) throws LOSException {
		try {
			Map<String, Object> params = formToMap(request);
			if (params != null) {
				context.putAllData(params);
			}
		} catch (LOException e) {
			this.logger.error(e.getMessage(), e);
		}
	}

	private Map<String, Object> formToMap(HttpServletRequest request) throws LOException {
		Map<String, String[]> parameters = request.getParameterMap();
		return JettyRelatedUtil.toMap(parameters);
	}
}
