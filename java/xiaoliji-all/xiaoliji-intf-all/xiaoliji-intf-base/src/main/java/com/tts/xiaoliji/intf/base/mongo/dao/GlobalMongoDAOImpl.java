package com.tts.xiaoliji.intf.base.mongo.dao;

import org.springframework.stereotype.Repository;

import com.tts.xiaoliji.intf.base.dao.GlobalAttrDAO;
import com.tts.xiaoliji.intf.base.dto.GlobalAttrDTO;

import cn.openlo.dataobject.DAO;
import cn.openlo.nosql.mongo.MongoDaoBase;

// 201218.zzh.@Repository
public class GlobalMongoDAOImpl extends MongoDaoBase<GlobalAttrDTO> implements DAO, GlobalAttrDAO {
	public void saveGlobalAttr(GlobalAttrDTO globalAttrDTO) {
		GlobalAttrDTO dto = (GlobalAttrDTO) super.findById(globalAttrDTO.getKey());
		if (dto == null) {
			super.insert(globalAttrDTO);
		} else {
			super.updateById(globalAttrDTO.getKey(), globalAttrDTO);
		}
	}

	public GlobalAttrDTO findGlobalAttr(String key) {
		return (GlobalAttrDTO) super.findById(key);
	}

	public GlobalAttrDTO findValidGlobalAttr(String key) {
		GlobalAttrDTO dto = (GlobalAttrDTO) super.findById(key);
		if ((dto == null) || (!"1".equals(dto.getStatus()))) {
			return null;
		}
		return dto;
	}

	public boolean updateGlobalAttr(GlobalAttrDTO dto) {
		return super.updateById(dto.getKey(), dto) == 1;
	}
}
