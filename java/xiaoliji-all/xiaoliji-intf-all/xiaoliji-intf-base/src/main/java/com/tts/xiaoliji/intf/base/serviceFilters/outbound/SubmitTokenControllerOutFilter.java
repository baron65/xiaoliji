package com.tts.xiaoliji.intf.base.serviceFilters.outbound;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.utils.TokenUtil;

import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("submitTokenOutFilter")
public class SubmitTokenControllerOutFilter extends AbstractIntfOutboundFilter {
	public int getOrder() {
		return 90;
	}

	public String getName() {
		return "tokenControlFilter";
	}

	public void afterFilter(ServiceRequest request, ServiceResponse serviceResponse, ServiceContext serviceContext) {
		if (!"000000".equals(serviceResponse.getResponseCode())) {
			generateToken(serviceResponse);
		}
	}

	private void generateToken(ServiceResponse serviceResponse) {
		String tokenKey = TokenUtil.getRandomString();

		IntfSession.getSession().setAttribute("_token", tokenKey);
		Map modelMap = (Map) serviceResponse.getModel();
		if (modelMap != null) {
			modelMap.put("_token", tokenKey);
		}
	}
}
