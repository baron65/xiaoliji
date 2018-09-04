package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;
import com.tts.xiaoliji.intf.base.exception.InvalidInputException;
import com.tts.xiaoliji.intf.base.serviceFilters.FilterUtil;
import com.tts.xiaoliji.intf.base.utils.AESUtil;

import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("aesDecryptInboundFilter")
public class AESDecryptInboundFilter extends AbstractDecInboundFilter {
	private Logger log = LoggerFactory.getLogger(getClass());

	public Map<String, Object> descryptData(ServiceRequest request, ServiceContext context, String encData)
			throws LOSException {
		Map<String, Object> jsonMap = new HashMap<String,Object>();
		IntfSession session = IntfSession.getSession();
		String encKey = FilterUtil.fetchKeyFromSession(session, context);
		if (StringUtils.isEmpty(encKey)) {
			throw new InvalidConditionException("session.encKey.error");
		}
		if (StringUtils.isEmpty(encData)) {
			throw new InvalidInputException("unknown.decrypt");
		}
		this.log.debug("AES key is : " + encKey);
		String decData = null;
		try {
			decData = AESUtil.decrypt(encData, encKey);
			this.log.debug("AES decrypt result : " + JSONObject.toJSONString(decData));

			jsonMap = (Map) JSON.parse(decData);
		} catch (Exception e) {
			throw new InvalidInputException("decrypt.error");
		}
		return jsonMap;
	}

	public String getName() {
		return "AESDescryptFilter";
	}
}
