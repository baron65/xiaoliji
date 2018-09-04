package com.tts.xiaoliji.intf.base.serviceFilters.outbound;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.constant.EnumFlowStep;

import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("flowCtrlOutboudFilter")
public class FlowCtrlValidOutboundFilter extends AbstractIntfOutboundFilter {
	private Logger logger = LoggerFactory.getLogger(FlowCtrlValidOutboundFilter.class);

	public int getOrder() {
		return 110;
	}

	public String getName() {
		return "flowCtrlFilter";
	}

	public void afterFilter(ServiceRequest request, ServiceResponse serviceResponse, ServiceContext serviceContext)
			throws LOSException {
		if ("000000".equals(serviceResponse.getResponseCode())) {
			IntfSession session = IntfSession.getSession();
			Map<String, String> properties = serviceContext.getLosProperties();

			String flowKey = (String) properties.get("flowType");
			EnumFlowStep flowType = EnumFlowStep.findFLowStep(flowKey);

			String actFlow = (String) properties.get("curFlow");

			String actCtrlFlow = (String) session.getAttribute("_intf_flow_control");
			if (EnumFlowStep.Init.equals(flowType)) {
				actCtrlFlow = actFlow;
				this.logger.debug("In initial step, the initial flow string is #{}#", actCtrlFlow);
			} else if (EnumFlowStep.Final.equals(flowType)) {
				actCtrlFlow = "";
				this.logger.debug("In final step, just clean the flow string");
			} else {
				actCtrlFlow = actCtrlFlow + "|" + actFlow;
				this.logger.debug("In middle step, the flow string need to store in session is #{}#", actCtrlFlow);
			}
			if (StringUtils.hasText(actCtrlFlow)) {
				String skipStep = (String) session.getAttribute("skipFlowKey", String.class);
				if (StringUtils.hasText(skipStep)) {
					actCtrlFlow = actCtrlFlow + "|" + skipStep;
					session.removeAttribute("skipFlowKey");
				}
				session.setAttribute("_intf_flow_control", actCtrlFlow);
			} else {
				session.removeAttribute("_intf_flow_control");
			}
		} else {
			this.logger.info("flow service execute failed, just skip, not update the session flow");
		}
	}
}
