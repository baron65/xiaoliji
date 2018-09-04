package com.tts.xiaoliji.intf.base.utils;

import org.springframework.util.StringUtils;

public class ClientVersionUtil {
	public static boolean compareVersions(String versionNo, String baseVersion) {
		if (StringUtils.isEmpty(versionNo)) {
			return false;
		}
		String[] versionArray1 = versionNo.split("\\.");
		String[] versionArray2 = baseVersion.split("\\.");
		int idx = 0;
		int minLength = Math.min(versionArray1.length, versionArray2.length);
		int diff = 0;
		while ((idx < minLength) && ((diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0)
				&& ((diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0)) {
			idx++;
		}
		diff = diff != 0 ? diff : versionArray1.length - versionArray2.length;
		boolean result = diff >= 0;
		return result;
	}
}
