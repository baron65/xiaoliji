package com.tts.xiaoliji.intf.base.sao;

import java.util.List;
import java.util.Map;

public interface NotifySAO {
	public abstract void notify(List<Map<String, Object>> paramList, String paramString1, String paramString2,
			String paramString3);

	public abstract void sendNotice(Map<String, Object> paramMap);
}
