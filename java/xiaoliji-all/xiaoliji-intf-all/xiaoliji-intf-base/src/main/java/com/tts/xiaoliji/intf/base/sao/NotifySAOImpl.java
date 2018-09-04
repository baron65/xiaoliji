package com.tts.xiaoliji.intf.base.sao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;

import cn.openlo.common.util.DateUtil;
import cn.openlo.exception.DateFormatException;
import cn.openlo.exception.LOException;
import cn.openlo.gear.jnl.JnlNoHelper;
import cn.openlo.protocol.Protocol;
import cn.openlo.service.CallType;
import cn.openlo.service.LOSClient;
import cn.openlo.service.LOSClientInterceptors;
import cn.openlo.service.LOServiceClient;

@Component
public class NotifySAOImpl extends IntfBaseSAO implements NotifySAO {
	@LOSClient(calleename = "notify-gateway.sendMessage", protocol = Protocol.DUBBO, callType = CallType.oneway)
	@LOSClientInterceptors(excludeList = { "baseParamInterceptor" })
	private LOServiceClient sendMsg;
	@LOSClient(calleename = "consumeTopic-NOTIFY-send.intf", protocol = Protocol.MQ)
	private LOServiceClient notify;
	private static final Logger logger = LoggerFactory.getLogger(NotifySAOImpl.class);
	// private static final String channel = "channel";
	// private static final String channelDate = "channelDate";
	// private static final String channelJnlNo = "channelJnlNo";
	// private static final String sourceSystemId = "sourceSystemId";
	@Autowired
	private JnlNoHelper jnlNoHelper;

	public void notify(List<Map<String, Object>> noticeContent, String notifyRule, String userId, String userName) {
		Map<String, Object> params = generateCommonMap();
		params.put("sendNo", userId);
		params.put("userName", userName);
		params.put("notifyRule", notifyRule);
		params.put("noticeContent", noticeContent);
		try {
			this.sendMsg.onewaySendRequest(params);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void sendNotice(Map<String, Object> params) {
		this.notify.sendRequest(params);
	}

	public Map<String, Object> generateCommonMap() {
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			params.put("channelJnlNo", this.jnlNoHelper.generate().getStringValue());
		} catch (LOException e) {
			logger.error(e.getMessage(), e);
			throw new InvalidConditionException(e.getMessage());
		}
		try {
			params.put("channelDate", DateUtil.printNowCompactDate());
		} catch (DateFormatException e) {
			logger.error(e.getMessage(), e);
		}
		params.put("sourceSystemId", "1001");
		params.put("channel", "1001");
		return params;
	}

	protected String getSysPre() {
		return "Notify";
	}
}
