package com.tts.xiaoliji.intf.base.sao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.openlo.protocol.Protocol;
import cn.openlo.service.LOSClient;
import cn.openlo.service.LOServiceClient;

@Component
public class IntfLoginSAOImpl extends IntfBaseSAO implements IntfLoginSAO {
	@LOSClient(calleename = "wss-intf-portal.addSafeDevice", protocol = Protocol.DUBBO)
	private LOServiceClient saveSafeDevice;

	public Map<String, Object> saveSafeDevice(String userId, String deviceId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("deviceId", deviceId);
		return super.sendRequest(this.saveSafeDevice, params);
	}

	protected String getSysPre() {
		return "INTF";
	}
}
