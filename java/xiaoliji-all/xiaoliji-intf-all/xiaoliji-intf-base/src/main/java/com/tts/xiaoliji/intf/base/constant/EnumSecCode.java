package com.tts.xiaoliji.intf.base.constant;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;

public enum EnumSecCode {
	iOS("01", "ios_type"), Android("02", "android_type");

	private String channelId;
	private String secType;
	private static Map<String, EnumSecCode> channelMap;

	static {
		channelMap = new HashMap<String, EnumSecCode>();
		for (EnumSecCode channel : EnumSet.allOf(EnumSecCode.class)) {
			channelMap.put(channel.channelId, channel);
		}
	}

	private EnumSecCode(String channelId, String secType) {
		this.channelId = channelId;
		this.secType = secType;
	}

	public String getChannelId() {
		return this.channelId;
	}

	public String getSecType() {
		return this.secType;
	}

	public static EnumSecCode getSecInfo(String channelId) {
		EnumSecCode result = (EnumSecCode) channelMap.get(channelId);
		if (result == null) {
			throw new InvalidConditionException("invalid.channel.id");
		}
		return result;
	}
}
