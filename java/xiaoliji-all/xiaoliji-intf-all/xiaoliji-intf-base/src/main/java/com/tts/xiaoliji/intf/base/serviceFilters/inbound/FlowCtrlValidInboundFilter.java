package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.constant.EnumFlowStep;
import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;
import com.tts.xiaoliji.intf.base.exception.InvalidConfigException;

import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("flowCtrlInboudFilter")
public class FlowCtrlValidInboundFilter extends AbstractIntfInboudFilter {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public boolean matches(ServiceRequest request, ServiceContext serviceContext) {
		return true;
	}

	public int getOrder() {
		return 110;
	}

	public String getName() {
		return "flowCtrlFilter";
	}

	public void preFilter(ServiceRequest request, ServiceContext serviceContext) throws LOSException {
		IntfSession session = IntfSession.getSession();
		Map<String, String> properties = serviceContext.getLosProperties();
		String flowTypeKey = (String) properties.get("flowType");
		EnumFlowStep flowType = EnumFlowStep.findFLowStep(flowTypeKey);
		if (flowType == null) {
			throw new InvalidConfigException("flow.config.error");
		}
		if (EnumFlowStep.Init.equals(flowType)) {
			this.logger.info("start intf flow, just mark it");
		} else {
			String actCtrlFlow = (String) session.getAttribute("_intf_flow_control");

			String expectFlow = (String) properties.get("preFlow");
			if (StringUtils.isEmpty(actCtrlFlow)) {
				throw new InvalidConditionException("flow.empty");
			}
			if (StringUtils.isEmpty(expectFlow)) {
				throw new InvalidConfigException("illegal.flow.config");
			}
			if (!actCtrlFlow.contains(expectFlow)) {
				throw new InvalidConditionException("flow.illegal");
			}
		}
	}
}
