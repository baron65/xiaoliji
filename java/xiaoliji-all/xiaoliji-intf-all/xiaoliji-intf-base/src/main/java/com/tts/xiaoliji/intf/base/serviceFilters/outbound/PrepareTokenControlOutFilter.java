package com.tts.xiaoliji.intf.base.serviceFilters.outbound;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.utils.TokenUtil;

import cn.openlo.common.beanutils.BeanToMap;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("prepareTokenOutFilter")
public class PrepareTokenControlOutFilter extends AbstractIntfOutboundFilter {
	Logger logger = LoggerFactory.getLogger(getClass());

	public boolean matches(ServiceRequest request, ServiceContext serviceContext) {
		return true;
	}

	public int getOrder() {
		return 90;
	}

	public String getName() {
		return "prepareTokenOutFilter";
	}

	public void afterFilter(ServiceRequest request, ServiceResponse serviceResponse, ServiceContext serviceContext) {
		generateToken(serviceResponse);
	}

	private void generateToken(ServiceResponse serviceResponse) {
		String tokenKey = TokenUtil.getRandomString();

		IntfSession.getSession().setAttribute("_token", tokenKey);
		Map modelMap = null;
		if (serviceResponse.getModel() == null) {
			modelMap = new HashMap();
		} else if (!(serviceResponse.getModel() instanceof Map)) {
			try {
				modelMap = (Map) BeanToMap.toMap(serviceResponse.getModel());
			} catch (Exception e) {
				this.logger.error(e.getMessage(), e);
			}
		} else {
			modelMap = (Map) serviceResponse.getModel();
		}
		modelMap.put("_token", tokenKey);
		serviceResponse.setModel(modelMap);
	}
}
