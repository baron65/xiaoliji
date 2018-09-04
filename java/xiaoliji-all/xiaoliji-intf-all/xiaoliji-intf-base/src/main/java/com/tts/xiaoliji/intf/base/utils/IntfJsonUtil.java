package com.tts.xiaoliji.intf.base.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;

public class IntfJsonUtil {
	private static final SerializeFilter filter = new EmptyValueFilter();

	public static String objectToJsonString(Object object) {
		return JSON.toJSONString(object, filter,
				new SerializerFeature[] { SerializerFeature.WriteNonStringValueAsString });
	}

	public static class EmptyValueFilter implements ValueFilter {
		public Object process(Object object, String name, Object value) {
			return value;
		}
	}
}
