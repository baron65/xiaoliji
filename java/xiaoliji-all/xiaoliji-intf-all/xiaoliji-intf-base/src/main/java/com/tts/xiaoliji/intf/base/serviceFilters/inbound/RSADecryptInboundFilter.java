package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("rsaDecryptFilter")
public class RSADecryptInboundFilter extends AbstractDecInboundFilter {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public Map<String, Object> descryptData(ServiceRequest request, ServiceContext serviceContext, String encData) {
		this.logger.info("enter into rsa descrypt filter");
		return null;
	}

	public String getName() {
		return "RSADescryptFilter";
	}
}
