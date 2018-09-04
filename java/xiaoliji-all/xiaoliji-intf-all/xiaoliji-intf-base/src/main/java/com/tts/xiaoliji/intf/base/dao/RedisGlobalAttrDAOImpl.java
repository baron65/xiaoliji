package com.tts.xiaoliji.intf.base.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.dto.GlobalAttrDTO;

import cn.openlo.nosql.redis.RedisDao;
import cn.openlo.nosql.redis.support.RedisMap;

@Component
public class RedisGlobalAttrDAOImpl implements GlobalAttrDAO {
	@Autowired
	private RedisDao redisDao;
	private static final String ATTR_DEFAULT_KEY = "jsonContent";

	public void saveGlobalAttr(GlobalAttrDTO dto) {
		if ((dto == null) || (StringUtils.isEmpty(dto.getJsonContent()))) {
			return;
		}
		String key = dto.getKey();
		RedisMap<String,String> redisMap = this.redisDao.createMap(key);
		redisMap.put(ATTR_DEFAULT_KEY, dto.getJsonContent());
	}

	public GlobalAttrDTO findGlobalAttr(String attrName) {
		RedisMap<String,String> redisMap = this.redisDao.createMap(attrName);
		GlobalAttrDTO globalAttrDTO = null;
		String content = (String) redisMap.get(ATTR_DEFAULT_KEY);
		if (StringUtils.hasText(content)) {
			globalAttrDTO = new GlobalAttrDTO();
			globalAttrDTO.setJsonContent(content);
		}
		return globalAttrDTO;
	}

	public GlobalAttrDTO findValidGlobalAttr(String attrName) {
		RedisMap<String,String> redisMap = this.redisDao.createMap(attrName);
		GlobalAttrDTO globalAttrDTO = null;
		String content = (String) redisMap.get(ATTR_DEFAULT_KEY);
		if (StringUtils.hasText(content)) {
			globalAttrDTO = new GlobalAttrDTO();
			globalAttrDTO.setJsonContent(content);
		}
		return globalAttrDTO;
	}

	public boolean updateGlobalAttr(GlobalAttrDTO dto) {
		boolean result = false;
		if ((dto != null) && ("0".equals(dto.getStatus()))) {
			if ("0".equals(dto.getStatus())) {
				this.redisDao.deleteMap(dto.getKey());
			} else {
				RedisMap<String,String> map = this.redisDao.createMap(dto.getKey());
				map.put(dto.getKey(), dto.getJsonContent());
			}
		}
		return result;
	}
}
