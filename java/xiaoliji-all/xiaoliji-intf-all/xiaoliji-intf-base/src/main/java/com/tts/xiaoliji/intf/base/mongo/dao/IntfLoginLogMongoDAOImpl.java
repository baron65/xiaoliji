package com.tts.xiaoliji.intf.base.mongo.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.dao.IntfLoginLogDAO;
import com.tts.xiaoliji.intf.base.dto.IntfLoginLogDTO;

import cn.openlo.dataobject.DAO;
import cn.openlo.nosql.mongo.MongoDaoBase;

//201218.zzh.@Component
public class IntfLoginLogMongoDAOImpl extends MongoDaoBase<IntfLoginLogDTO> implements DAO, IntfLoginLogDAO {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public void insert(IntfLoginLogDTO loginDTO) {
		try {
			super.insert(loginDTO);
		} catch (Exception e) {
			this.logger.error("record login record meets exception, just skip it. The exception is as follows:");
			this.logger.error(e.getMessage(), e);
		}
	}
}
