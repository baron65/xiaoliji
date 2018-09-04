package com.tts.xiaoliji.intf.base.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.sao.IntfLoginSAO;

public class SafeDeviceUtils {
	private static final Logger logger = LoggerFactory.getLogger(SafeDeviceUtils.class);

	public static Map<String, Object> addSafeDevice(IntfLoginSAO sao, String deviceId, String userId) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if ((StringUtils.hasText(userId)) && (StringUtils.hasText(userId))) {
				sao.saveSafeDevice(userId, deviceId);
			} else {
				logger.info("userId is {}, deviceId is {}, skip add device to safe device list.", userId, deviceId);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return result;
	}
}
