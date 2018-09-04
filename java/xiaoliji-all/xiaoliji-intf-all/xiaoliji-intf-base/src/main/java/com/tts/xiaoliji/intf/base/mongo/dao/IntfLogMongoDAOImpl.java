package com.tts.xiaoliji.intf.base.mongo.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.tts.xiaoliji.intf.base.dao.IntfCommonLogDAO;
import com.tts.xiaoliji.intf.base.dto.IntfCommonLogDTO;

import cn.openlo.dataobject.DAO;
import cn.openlo.nosql.mongo.MongoDaoBase;

//201218.zzh.@Repository
public class IntfLogMongoDAOImpl extends MongoDaoBase<IntfCommonLogDTO> implements DAO, IntfCommonLogDAO {
	public void insert(IntfCommonLogDTO intfCommonLogDTO) {
		super.save(intfCommonLogDTO);
	}

	public IntfCommonLogDTO findOnlyOne(String channelJnlNo, String serverId) {
		Criteria criteria = Criteria.where("channelJnlNo");
		criteria.is(channelJnlNo);
		return (IntfCommonLogDTO) super.findOne(criteria);
	}

	public boolean updateOnlyOne(String channelJnlNo, String serverId, Map<String, Object> updateArgs) {
		Map<String, Object> queryArgs = new HashMap<String,Object>();
		queryArgs.put("channelJnlNo", channelJnlNo);
		return super.updateFirst(queryArgs, updateArgs) == 1;
	}
}
