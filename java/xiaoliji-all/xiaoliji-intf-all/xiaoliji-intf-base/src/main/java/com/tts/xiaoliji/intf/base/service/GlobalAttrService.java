package com.tts.xiaoliji.intf.base.service;

public abstract interface GlobalAttrService {
	public abstract void setGlobalAttribute(String paramString1, String paramString2, Object paramObject);

	public abstract Object getGlobalAttribute(String paramString1, String paramString2);

	public abstract <T> T getGlobalAttribute(String paramString1, String paramString2, Class<T> paramClass);

	public abstract Object removeGlobalAttribute(String paramString1, String paramString2);
}
