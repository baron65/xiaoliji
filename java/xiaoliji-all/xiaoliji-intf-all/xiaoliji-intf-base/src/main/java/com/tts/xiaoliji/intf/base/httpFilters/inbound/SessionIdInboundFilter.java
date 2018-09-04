package com.tts.xiaoliji.intf.base.httpFilters.inbound;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.utils.CookieUtils;

import cn.openlo.exception.LOSException;
import cn.openlo.service.HttpInboundServiceFilter;
import cn.openlo.service.ServiceContext;

@Component("sessionIdInboundFilter")
public class SessionIdInboundFilter implements HttpInboundServiceFilter {
	public int getOrder() {
		return 50;
	}

	public void doFilter(HttpServletRequest paramHttpServletRequest, ServiceContext paramServiceContext)
			throws LOSException {
		String sessionId = fetchSessionId(paramHttpServletRequest, paramServiceContext);
		if (StringUtils.isNotEmpty(sessionId)) {
			paramServiceContext.setData("UFO-SESSION-ID", sessionId);
		}
		String wxAutoLoginKey = fetchFundAutoLoginKey(paramHttpServletRequest, paramServiceContext);
		if (StringUtils.isNotEmpty(wxAutoLoginKey)) {
			paramServiceContext.setData("loginId", wxAutoLoginKey);
		}
	}

	private String fetchSessionId(HttpServletRequest paramHttpServletRequest, ServiceContext paramServiceContext) {
		String sessionId = CookieUtils.getCookieValue(paramHttpServletRequest, "UFO-SESSION-ID");
		if (StringUtils.isEmpty(sessionId)) {
			sessionId = paramHttpServletRequest.getHeader("UFO-SESSION-ID");
		}
		return sessionId;
	}

	private String fetchFundAutoLoginKey(HttpServletRequest paramHttpServletRequest,
			ServiceContext paramServiceContext) {
		String loginKey = CookieUtils.getCookieValue(paramHttpServletRequest, "_fund_wx_key");
		if (StringUtils.isEmpty(loginKey)) {
			loginKey = paramHttpServletRequest.getHeader("_fund_wx_key");
		}
		return loginKey;
	}
}
