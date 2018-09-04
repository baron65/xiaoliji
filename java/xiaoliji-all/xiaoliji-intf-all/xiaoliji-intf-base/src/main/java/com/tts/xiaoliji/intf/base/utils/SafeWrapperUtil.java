package com.tts.xiaoliji.intf.base.utils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SafeWrapperUtil {
	public static <T> Set<T> safe(Set<T> set) {
		return set == null ? Collections.EMPTY_SET : set;
	}

	public static <K, V> Map<K, V> safe(Map<K, V> map) {
		return map == null ? Collections.EMPTY_MAP : map;
	}

	public static <T> List<T> safe(List<T> list) {
		return list == null ? Collections.EMPTY_LIST : list;
	}
}
