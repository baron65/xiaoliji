package com.tts.xiaoliji.intf.base.utils;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections.MapUtils;

public class IntfMapUtils extends MapUtils {
	public static Map removeNullValue(Map map) {
		if (map != null) {
			if ((map.values() != null) && (map.values().contains(null))) {
				Iterator<Map.Entry> it = map.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry item = (Map.Entry) it.next();
					if (item.getValue() == null) {
						it.remove();
					}
				}
			}
			return map;
		}
		return null;
	}
}
