package com.tts.xiaoliji.intf.base.sao;

import java.util.Map;

import com.alibaba.dubbo.rpc.service.GenericException;

public abstract interface OTPSAO {
	public abstract void sendSms(String phone, String otpTpl, Map<String, String> smsParam) throws GenericException;

	public abstract void verifySms(String phone,String otpCode) throws GenericException;
}
