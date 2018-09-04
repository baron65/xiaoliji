package com.tts.xiaoliji.intf.base.serviceFilters.outbound;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.IntfBaseResponse;
import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.serviceFilters.FilterUtil;
import com.tts.xiaoliji.intf.base.utils.AESUtil;
import com.tts.xiaoliji.intf.base.utils.IntfJsonUtil;

import cn.openlo.common.beanutils.BeanToMap;
import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("aesEncryptOutboundFilter")
public class AESEncryptOutboundFilter extends AbstractIntfOutboundFilter {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public boolean matches(ServiceRequest request, ServiceContext serviceContext) {
		return true;
	}

	public int getOrder() {
		return 10;
	}

	public String getName() {
		return "AESEncryptFilter";
	}

	public void afterFilter(ServiceRequest request, ServiceResponse serviceResponse, ServiceContext serviceContext)
			throws LOSException {
		String encKey = getEncKey(serviceResponse, serviceContext);
		if (StringUtils.isEmpty(encKey)) {
			return;
		}
		Object model = serviceResponse.getModel();

		Map<String, Object> responseMap = new HashMap<String, Object>();

		Map<String, Object> commonMap = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(IntfBaseResponse.class);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

			Map<String, Object> totalMap = generateMapFromModel(model);
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				commonMap.put(key, totalMap.remove(key));
			}
			responseMap.putAll(commonMap);
			if (!CollectionUtils.isEmpty(totalMap)) {
				String content = IntfJsonUtil.objectToJsonString(totalMap);
				if (this.logger.isInfoEnabled()) {
					this.logger.info("Before encrypt, the business response model is {}", content);
				}
				responseMap.putAll(generateEncMap(content, encKey));
			}
		} catch (Exception e1) {
			this.logger.error(e1.getMessage(), e1);
		}
		if ((responseMap != null) && (!responseMap.isEmpty())) {
			model = null;
			serviceResponse.setModel(responseMap);
		}
	}

	private String getEncKey(ServiceResponse serviceResponse, ServiceContext context) {
		String encKey = "";
		if (serviceResponse != null) {
			IntfSession session = IntfSession.getSession();
			encKey = FilterUtil.fetchKeyFromSession(session, context);
		}
		return encKey;
	}

	private Map<String, Object> generateMapFromModel(Object model) throws Exception {
		Map<String, Object> totalMap = null;
		if ((model instanceof Map)) {
			totalMap = (Map) model;
		} else {
			totalMap = (Map) BeanToMap.toMap(model);
		}
		if (totalMap == null) {
			totalMap = new HashMap<String, Object>();
		}
		return totalMap;
	}

	private Map<String, Object> generateEncMap(String content, String encKey) {
		Map<String, Object> encMap = new HashMap<String, Object>();
		try {
			String encValue = AESUtil.encrypt(content, encKey);
			encMap.put("_enData_", encValue);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}
		return encMap;
	}
}
