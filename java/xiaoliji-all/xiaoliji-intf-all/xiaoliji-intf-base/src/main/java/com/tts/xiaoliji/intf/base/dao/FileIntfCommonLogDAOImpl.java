package com.tts.xiaoliji.intf.base.dao;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.dto.IntfCommonLogDTO;

import cn.openlo.common.util.LOJsonUtil;

@Component
public class FileIntfCommonLogDAOImpl implements IntfCommonLogDAO {
	private static final Logger logger = LoggerFactory.getLogger(FileIntfCommonLogDAOImpl.class);

	public void insert(IntfCommonLogDTO intfCommonLogDTO) {
		try {
			logger.info("logger dto is " + LOJsonUtil.objectToJsonString(intfCommonLogDTO));
		} catch (Throwable t) {
			logger.error("file log error, the message is {}", t.getMessage());
		}
	}

	public IntfCommonLogDTO findOnlyOne(String channelJnlNo, String serverId) {
		IntfCommonLogDTO result = new IntfCommonLogDTO();
		result.setChannelJnlNo(channelJnlNo);
		result.setServerId(serverId);
		return result;
	}

	public boolean updateOnlyOne(String channelJnlNo, String serverId, Map<String, Object> updateArgs) {
		try {
			logger.info("channelJnlNo is {}, the serverId is {}, the updateArgs is {}.",
					new Object[] { channelJnlNo, serverId, LOJsonUtil.objectToJsonString(updateArgs) });
		} catch (Throwable t) {
			logger.error("file log error, the message is {}", t.getMessage());
		}
		return true;
	}
}
