package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.exception.InvalidConfigException;

import cn.openlo.common.util.LOJsonUtil;
import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("notAlterPrepareInFilter")
public class NotAlterPrepareInboundFilter extends AbstractIntfInboudFilter {
	public boolean matches(ServiceRequest paramServiceRequest, ServiceContext paramServiceContext) {
		return true;
	}

	public int getOrder() {
		return 100;
	}

	public String getName() {
		return "notAlterPrepareFilter";
	}

	public void preFilter(ServiceRequest paramServiceRequest, ServiceContext context) throws LOSException {
		Map<String, String> properties = context.getLosProperties();
		String importantFiledAttr = (String) properties.get("noAlterImportantKeys");
		if (StringUtils.isEmpty(importantFiledAttr)) {
			throw new InvalidConfigException("prepareTrans.importantFiled.null");
		}
		String[] importantFileds = importantFiledAttr.split("\\|");
		Map<String, Object> importData = new HashMap<String, Object>();
		for (String importantFiled : importantFileds) {
			importData.put(importantFiled,
					LOJsonUtil.objectToJsonString(paramServiceRequest.getParameters().get(importantFiled)));
		}
		IntfSession.getSession().setAttribute("nalter_import_data", importData);
		context.setData("confirmData", importData);
	}
}
