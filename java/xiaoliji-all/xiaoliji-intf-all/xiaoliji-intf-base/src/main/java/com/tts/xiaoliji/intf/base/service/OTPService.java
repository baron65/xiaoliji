package com.tts.xiaoliji.intf.base.service;

import java.util.Map;

import cn.openlo.exception.LOSException;

public abstract interface OTPService {
	public abstract Map<String, Object> sendSms(String paramString1, String paramString2) throws LOSException;

	public abstract Map<String, Object> sendSms(String paramString1, String paramString2, Map<String, String> paramMap)
			throws LOSException;

	public abstract Map<String, Object> smsVerify(String paramString) throws LOSException;
}
