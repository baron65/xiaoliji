package com.tts.xiaoliji.intf.base.serviceFilters;

import java.util.Set;

import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.IntfSession;

import cn.openlo.service.ServiceContext;

public class FilterUtil {
	@SuppressWarnings("unchecked")
	public static String fetchKeyFromSession(IntfSession session, ServiceContext context) {
		String key = "";

		Set<String> filterSets = (Set<String>) context.getData("_filter_name_sets");
		if (filterSets.contains("userAccessFilter")) {
			key = (String) session.getAttribute("_sessionAESKey_", String.class);
		} else {
			key = (String) session.getAttribute("_sessionPreLoginAESKey_", String.class);
			if (StringUtils.isEmpty(key)) {
				key = (String) session.getAttribute("_sessionAESKey_", String.class);
			}
		}
		return key;
	}
}
