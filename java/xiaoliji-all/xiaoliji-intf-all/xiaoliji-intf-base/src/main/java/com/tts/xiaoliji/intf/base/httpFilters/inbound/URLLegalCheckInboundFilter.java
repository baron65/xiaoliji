package com.tts.xiaoliji.intf.base.httpFilters.inbound;

import javax.servlet.http.HttpServletRequest;

import cn.openlo.exception.LOSException;
import cn.openlo.service.HttpInboundServiceFilter;
import cn.openlo.service.ServiceContext;

public class URLLegalCheckInboundFilter implements HttpInboundServiceFilter {
	public int getOrder() {
		return 10;
	}

	public void doFilter(HttpServletRequest request, ServiceContext context) throws LOSException {
	}
}
