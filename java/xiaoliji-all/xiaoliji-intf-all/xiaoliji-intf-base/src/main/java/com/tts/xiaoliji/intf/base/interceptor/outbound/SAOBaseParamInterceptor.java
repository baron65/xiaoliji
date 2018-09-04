package com.tts.xiaoliji.intf.base.interceptor.outbound;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;

import cn.openlo.common.util.DateUtil;
import cn.openlo.common.util.LOJsonUtil;
import cn.openlo.exception.DateFormatException;
import cn.openlo.exception.LOException;
import cn.openlo.exception.LOSException;
import cn.openlo.gear.jnl.JnlNoHelper;
import cn.openlo.service.OutboundServiceInterceptor;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("baseParamInterceptor")
public class SAOBaseParamInterceptor implements OutboundServiceInterceptor {
//	private static final String channel = "channel";
//	private static final String channelDate = "channelDate";
//	private static final String channelJnlNo = "channelJnlNo";
//	private static final String sourceSystemId = "sourceSystemId";
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private JnlNoHelper jnlNoHelper;

	public boolean match(ServiceRequest paramServiceRequest, ServiceContext paramServiceContext) {
		return true;
	}

	public int getOrder() {
		return 0;
	}

	@SuppressWarnings("unchecked")
	public void intercept(ServiceRequest request, ServiceContext serviceContext) throws LOSException {
		Map<String, Object> params = (Map<String, Object>) request.getParameters();
		params.put("channel", IntfSession.getSession().getAttribute("_channel_id"));//访问订单要做渠道转换
		try {
			params.put("channelJnlNo", this.jnlNoHelper.generate().getStringValue());
		} catch (LOException e) {
			this.logger.error(e.getMessage(), e);
			throw new InvalidConditionException(e.getMessage());
		}
		try {
			params.put("channelDate", DateUtil.printNowCompactDate());
		} catch (DateFormatException e) {
			this.logger.error(e.getMessage(), e);
		}
		params.put("sourceSystemId", "1001");

		this.logger.debug("invoke service: " + request.getServiceName() + " params is : "
				+ LOJsonUtil.objectToJsonString(params));
	}
}
