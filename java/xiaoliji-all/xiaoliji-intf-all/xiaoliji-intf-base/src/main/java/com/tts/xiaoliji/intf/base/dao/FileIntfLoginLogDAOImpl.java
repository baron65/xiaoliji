package com.tts.xiaoliji.intf.base.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.dto.IntfLoginLogDTO;

import cn.openlo.common.util.LOJsonUtil;

@Component
public class FileIntfLoginLogDAOImpl implements IntfLoginLogDAO {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public void insert(IntfLoginLogDTO loginDTO) {
		this.logger.info("After login, the result is {}", LOJsonUtil.objectToJsonString(loginDTO));
	}
}
