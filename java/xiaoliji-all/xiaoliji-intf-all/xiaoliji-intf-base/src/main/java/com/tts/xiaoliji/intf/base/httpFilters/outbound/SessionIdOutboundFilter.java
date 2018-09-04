package com.tts.xiaoliji.intf.base.httpFilters.outbound;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.utils.CookieUtils;

import cn.openlo.service.HttpOutboundServiceFilter;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("sessionIdOutboundFilter")
public class SessionIdOutboundFilter implements HttpOutboundServiceFilter {
	public int getOrder() {
		return 100;
	}

	@SuppressWarnings("unchecked")
	public void doFilter(HttpServletRequest servletRequest, HttpServletResponse sevletResponse,
			ServiceRequest serviceRequest, ServiceResponse serviceResponse, ServiceContext context) {
		if ((serviceResponse == null) || (serviceResponse.getModel() == null)) {
			return;
		}
		Map<String,Object> responseModel = (Map<String,Object>) serviceResponse.getModel();
		String sessionId = CookieUtils.getCookieValue(servletRequest, "UFO-SESSION-ID");

		String newSessionId = (String) responseModel.get("UFO-SESSION-ID");

		String cookieDomain = getMainDomain(servletRequest.getRequestURL());
		if ((newSessionId != null) && (!newSessionId.equals(sessionId))) {
			Cookie c = CookieUtils.createCookie("UFO-SESSION-ID", newSessionId, cookieDomain, "/");
			sevletResponse.addCookie(c);
			String aesKey = (String) responseModel.get("_aes_encry_key");
			if (StringUtils.isNotEmpty(aesKey)) {
				sevletResponse.addHeader("_aes_encry_key", aesKey);
			}
		}
		if (responseModel.get("_cookie_list") != null) {
			List<Map<String, String>> cookieList = (List<Map<String, String>>) responseModel.get("_cookie_list");
			if (!cookieList.isEmpty()) {
				for (Map<String, String> cookieMap : cookieList) {
					String cookieKey = (String) cookieMap.get("cookieKey");
					String cookieValue = (String) cookieMap.get("cookieValue");
					Cookie c = CookieUtils.createCookie(cookieKey, cookieValue, cookieDomain, "/");
					sevletResponse.addCookie(c);
				}
			}
		}
		if (newSessionId != null) {
			responseModel.remove("UFO-SESSION-ID");
		}
	}

	protected String getMainDomain(StringBuffer url) {
		String domain = getDomain(url);
		int idx = domain.indexOf('.');
		if (idx != -1) {
			return domain.substring(idx);
		}
		return domain;
	}

	protected String getDomain(StringBuffer url) {
		for (int i = 0; i < url.length(); i++) {
			char ch = url.charAt(i);
			if (ch == '\\') {
				url.setCharAt(i, '/');
			}
		}
		String temp = url.toString();
		int idx1 = temp.indexOf("//");
		if (idx1 == -1) {
			idx1 = 0;
		} else {
			idx1 += 2;
		}
		int idx2 = temp.indexOf('/', idx1);
		String temp2 = temp.substring(idx1, idx2);
		int idx3 = temp2.indexOf(':');
		if (idx3 != -1) {
			return temp2.substring(0, idx3).toLowerCase();
		}
		return temp2.toLowerCase();
	}
}
