package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.tts.xiaoliji.intf.base.exception.InvalidInputException;

import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("serviceMsgSummaryFilter")
public class MsgSummaryCheckFilter extends AbstractIntfInboudFilter {
	public boolean matches(ServiceRequest request, ServiceContext context) {
		return true;
	}

	public int getOrder() {
		return 5;
	}

	public String getName() {
		return "msgSummaryFilter";
	}

	public void preFilter(ServiceRequest request, ServiceContext context) throws LOSException {
		String msgSummary = (String) request.getParameters().get("shths");
		if (StringUtils.isEmpty(msgSummary)) {
			throw new InvalidInputException("msgSummary.mustnot.empty");
		}
		Map params = request.getParameters();
		if (params != null) {
			Map reqMap = (Map) params.get("reqData");
			String reqMapJsonStr = JSON.toJSONString(reqMap);
			String reqMapMd5 = DigestUtils.md5Hex(reqMapJsonStr);
			if (!msgSummary.equals(reqMapMd5)) {
				throw new InvalidInputException("msgSummary.not.match");
			}
			params.remove("reqData");
		}
	}
}
