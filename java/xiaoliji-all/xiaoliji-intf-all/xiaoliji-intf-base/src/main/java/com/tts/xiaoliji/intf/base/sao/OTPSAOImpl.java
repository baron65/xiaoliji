package com.tts.xiaoliji.intf.base.sao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.service.GenericException;

import cn.openlo.service.LOSClient;
import cn.openlo.service.LOServiceClient;

@Component
public class OTPSAOImpl extends IntfBaseSAO implements OTPSAO {
	@LOSClient(calleename = "otp_main.otpSmsSend")
	private LOServiceClient sendSmsClient;
	@LOSClient(calleename = "otp_main.otpSmsVerify")
	private LOServiceClient verifyClient;

	public void sendSms(String phone, String otpTpl, Map<String, String> smsParam) throws GenericException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", phone);
		params.put("otpTpl", otpTpl);
		if (smsParam != null) {
			params.put("smsParam", smsParam);
		}
		sendRequest(this.sendSmsClient, params);
	}

	public void verifySms(String phone, String otpCode) throws GenericException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", phone);
		params.put("otpCode", otpCode);
		sendRequest(this.verifyClient, params);
	}

	protected String getSysPre() {
		return "OTP";
	}
}
