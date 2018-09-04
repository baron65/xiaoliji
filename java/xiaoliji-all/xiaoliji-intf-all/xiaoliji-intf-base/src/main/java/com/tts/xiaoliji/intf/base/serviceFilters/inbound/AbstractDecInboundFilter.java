package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.constant.IntfFilterConstant;

import cn.openlo.common.util.LOJsonUtil;
import cn.openlo.exception.LOSException;
import cn.openlo.gear.cache.Cache;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

public abstract class AbstractDecInboundFilter extends AbstractIntfInboudFilter {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	@Qualifier("gearCache")
	private Cache intfCache;

	public abstract Map<String, Object> descryptData(ServiceRequest paramServiceRequest,
			ServiceContext paramServiceContext, String paramString) throws LOSException;

	public boolean matches(ServiceRequest request, ServiceContext serviceContext) {
		boolean result = ((Boolean) this.intfCache.get("enableAES", Boolean.class)).booleanValue();

		return result;
	}

	public int getOrder() {
		return 10;
	}

	@SuppressWarnings("unchecked")
	public void preFilter(ServiceRequest request, ServiceContext serviceContext) throws LOSException {
		Map<String, Object> params = (Map<String, Object>) request.getParameters();
		removeIllegalParam(params);
		Object reqData = params.get("reqData");
		if (!(reqData instanceof String)) {
			this.logger.debug("reqData not string, just skip the aes decrypt filter.");
			return;
		}
		String encData = (String) reqData;
		if (StringUtils.hasText(encData)) {
			Map<String, Object> descryptParams = descryptData(request, serviceContext, encData);
			if (CollectionUtils.isEmpty(descryptParams)) {
				this.logger.debug("descryptParams is an empty map, just skip it");
				params.remove("reqData");
				return;
			}
			params.remove("reqData");
			if ((descryptParams.values() != null) && (descryptParams.values().contains(null))) {
				for (Map.Entry<String, Object> item : descryptParams.entrySet()) {
					if (item.getValue() != null) {
						params.put(item.getKey(), item.getValue());
					}
				}
			} else {
				params.putAll(descryptParams);
			}
			if (this.logger.isInfoEnabled()) {
				this.logger.info("The reqeust name is {}, the params is {}.", request.getServiceName(),
						LOJsonUtil.objectToJsonString(request.getParameters()));
			}
		} else {
			this.logger.warn("Request need to be enctrypt, but there isn't encKey, the request detail is as flows");
			this.logger.warn("serviceName: #{}#, params: #{}#", request.getServiceName(), request.getParameters());
		}
	}

	protected void removeIllegalParam(Map<String, Object> params) {
		Set<String> keySet = params.keySet();
		Set<String> illegalSet = new HashSet<String>();
		for (String key : emptyIfNull(keySet)) {
			if (!IntfFilterConstant.ALLOW_KEY_SET.contains(key)) {
				this.logger.warn("Key {} is not allowed, remove it from params.", key);
				illegalSet.add(key);
			}
		}
		for (String key : emptyIfNull(illegalSet)) {
			params.remove(key);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> Iterable<T> emptyIfNull(Iterable<T> iterable) {
		return (Iterable<T>) (iterable == null ? Collections.emptyList().iterator() : iterable);
	}

	protected String getEncType(ServiceRequest request, ServiceContext serviceContext) {
		Map<String, String> serviceProperties = serviceContext.getLosProperties();
		String encType = (String) serviceProperties.get("encType");
		this.logger.debug("esaAttr " + request.getServiceName() + " encType is : " + encType);
		return encType;
	}
}
