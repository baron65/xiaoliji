package com.tts.xiaoliji.intf.base.dao;

import com.tts.xiaoliji.intf.base.dto.GlobalAttrDTO;

public abstract interface GlobalAttrDAO {
	public abstract void saveGlobalAttr(GlobalAttrDTO paramGlobalAttrDTO);

	public abstract GlobalAttrDTO findGlobalAttr(String paramString);

	public abstract GlobalAttrDTO findValidGlobalAttr(String paramString);

	public abstract boolean updateGlobalAttr(GlobalAttrDTO paramGlobalAttrDTO);
}
