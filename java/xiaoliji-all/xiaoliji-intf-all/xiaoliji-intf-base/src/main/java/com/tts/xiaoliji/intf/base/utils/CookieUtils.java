package com.tts.xiaoliji.intf.base.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtils {
	public static Cookie createCookie(String cookieName, String cookieValue, String domain) {
		return createCookie(cookieName, cookieValue, domain, null);
	}

	public static Cookie deleteCookie(String cookieName, String domain, String path, String cookieValue) {
		Cookie c = createCookie(cookieName, cookieValue, domain, path);
		c.setMaxAge(0);
		return c;
	}

	public static Cookie createCookie(String cookieName, String cookieValue, String domain, String path) {
		Cookie c = new Cookie(cookieName, cookieValue);
		if (((domain == null) || ((domain = domain.trim()).length() <= 0)) || (

		(path != null) && ((path = path.trim()).length() > 0))) {
			c.setPath(path);
		} else {
			c.setPath("/");
		}
		c.setMaxAge(-1);
		c.setSecure(false);

		return c;
	}

	public static String getCookieValue(HttpServletRequest request, String cookieName) {
		String cookieStr = request.getHeader("Cookie");
		if (cookieStr == null) {
			return null;
		}
		int idx = cookieStr.indexOf(cookieName);
		if (idx == -1) {
			return null;
		}
		idx = cookieStr.indexOf('=', idx);
		if (idx == -1) {
			return null;
		}
		int idx2 = cookieStr.indexOf(';', idx);
		String value = null;
		if (idx2 == -1) {
			value = cookieStr.substring(idx + 1);
		} else {
			value = cookieStr.substring(idx + 1, idx2);
		}
		try {
			String charset = request.getCharacterEncoding();
			if (charset == null) {
				charset = "ISO-8859-1";
			}
			return URLDecoder.decode(value.trim(), charset);
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}
}
