package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;

import cn.openlo.common.util.LOJsonUtil;
import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("notAlterSubmitInFilter")
public class NotAlterSubmitInboundFilter extends AbstractIntfInboudFilter {
	public boolean matches(ServiceRequest request, ServiceContext serviceContext) {
		return true;
	}

	public int getOrder() {
		return 100;
	}

	public String getName() {
		return "notAlterSubmitFilter";
	}

	@SuppressWarnings("unchecked")
	public void preFilter(ServiceRequest request, ServiceContext serviceContext) throws LOSException {
		Map<String, Object> importData = (Map<String, Object>) IntfSession.getSession().getAttribute("nalter_import_data");
		if ((importData == null) || (importData.keySet().size() == 0)) {
			throw new InvalidConditionException("prepare.msg.lost");
		}
		for (String importFiled : importData.keySet()) {
			Object preData = importData.get(importFiled);
			Object subData = LOJsonUtil.objectToJsonString(request.getParameters().get(importFiled));
			if (preData == null) {
				if (subData != null) {
					throw new InvalidConditionException("submitData.altered.error");
				}
			} else if (!preData.equals(subData)) {
				throw new InvalidConditionException("submitData.altered.error");
			}
		}
	}
}
