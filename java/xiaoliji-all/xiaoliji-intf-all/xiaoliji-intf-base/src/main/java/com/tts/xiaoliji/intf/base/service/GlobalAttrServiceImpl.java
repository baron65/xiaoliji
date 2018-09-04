package com.tts.xiaoliji.intf.base.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tts.xiaoliji.intf.base.dao.GlobalAttrDAO;
import com.tts.xiaoliji.intf.base.dto.GlobalAttrDTO;
import com.tts.xiaoliji.intf.base.exception.IntfRuntimeException;
import com.tts.xiaoliji.intf.base.mongo.dao.GlobalMongoDAOImpl;

@Component
public class GlobalAttrServiceImpl implements GlobalAttrService {
	private Logger logger = LoggerFactory.getLogger(getClass());
//	private static final String PREFIX_NAMESPACE = "UFO_INTF.";
//	private static final String PREFIX_GLOBAL = "GLOBAL.";
	private GlobalAttrDAO globalAttrDAO;
	@Autowired
	private List<GlobalAttrDAO> globalAttrDAOList;

	public void setGlobalAttribute(String globalId, String key, Object value) {
		GlobalAttrDTO globalAttrDTO = new GlobalAttrDTO();
		globalAttrDTO.setKey("UFO_INTF.GLOBAL." + globalId + key);
		globalAttrDTO.setJsonContent(JSONObject.toJSONString(value));
		globalAttrDTO.setStatus("1");

		this.globalAttrDAO.saveGlobalAttr(globalAttrDTO);
	}

	public Object getGlobalAttribute(String globalId, String key) {
		this.logger.info("[getGlobalAttr starts.]");
		String index = "UFO_INTF.GLOBAL." + globalId + key;
		GlobalAttrDTO globalAttrDTO = this.globalAttrDAO.findValidGlobalAttr(index);
		Object result = null;
		if (globalAttrDTO != null) {
			result = JSONObject.parse(globalAttrDTO.getJsonContent());
		}
		this.logger.info("[getGlobalAttr end.]");
		return result;
	}

	public <T> T getGlobalAttribute(String globalId, String key, Class<T> type) {
		this.logger.info("[getGlobalAttr starts.]");
		String index = "UFO_INTF.GLOBAL." + globalId + key;
		GlobalAttrDTO globalAttrDTO = this.globalAttrDAO.findValidGlobalAttr(index);
		T result = null;
		if (globalAttrDTO != null) {
			result = JSON.parseObject(globalAttrDTO.getJsonContent(), type);
		}
		this.logger.info("[getGlobalAttr end.]");
		return result;
	}

	public Object removeGlobalAttribute(String globalId, String key) {
		this.logger.info("[removeGlobalAttribute starts.]");
		GlobalAttrDTO globalAttrDTO = new GlobalAttrDTO();
		globalAttrDTO.setKey("UFO_INTF.GLOBAL." + globalId + key);
		globalAttrDTO.setStatus("1");
		this.globalAttrDAO.updateGlobalAttr(globalAttrDTO);
		this.logger.info("[removeGlobalAttribute ends.]");

		return globalAttrDTO;
	}

	@PostConstruct
	public void initialize() {
		if (this.globalAttrDAO == null) {
			if (this.globalAttrDAOList.size() == 0) {
				throw new IntfRuntimeException("no.intf.global.attr");
			}
			for (GlobalAttrDAO dao : this.globalAttrDAOList) {
				if ((dao instanceof GlobalMongoDAOImpl)) {
					this.globalAttrDAO = dao;
					break;
				}
			}
			if (this.globalAttrDAO == null) {
				this.globalAttrDAO = ((GlobalAttrDAO) this.globalAttrDAOList.get(0));
			}
		}
	}
}
