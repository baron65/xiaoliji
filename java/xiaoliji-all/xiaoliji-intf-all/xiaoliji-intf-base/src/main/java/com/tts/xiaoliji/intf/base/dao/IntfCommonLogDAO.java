package com.tts.xiaoliji.intf.base.dao;

import java.util.Map;

import com.tts.xiaoliji.intf.base.dto.IntfCommonLogDTO;

public abstract interface IntfCommonLogDAO {
	public abstract void insert(IntfCommonLogDTO paramIntfCommonLogDTO);

	public abstract IntfCommonLogDTO findOnlyOne(String paramString1, String paramString2);

	public abstract boolean updateOnlyOne(String paramString1, String paramString2, Map<String, Object> paramMap);
}
