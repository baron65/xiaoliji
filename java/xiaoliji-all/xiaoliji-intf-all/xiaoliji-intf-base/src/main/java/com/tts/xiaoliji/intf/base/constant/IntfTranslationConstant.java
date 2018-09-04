package com.tts.xiaoliji.intf.base.constant;

import java.util.HashMap;
import java.util.Map;

public class IntfTranslationConstant {
	public static Map<String, String> CURRENCY_TRANS_MAP = new HashMap<String, String>();

	static {
	    CURRENCY_TRANS_MAP.put("036", "澳元");
	    CURRENCY_TRANS_MAP.put("124", "加元");
	    CURRENCY_TRANS_MAP.put("156", "元");
	    CURRENCY_TRANS_MAP.put("344", "港元");
	    CURRENCY_TRANS_MAP.put("392", "日元");
	    CURRENCY_TRANS_MAP.put("702", "新加坡元");
	    CURRENCY_TRANS_MAP.put("826", "英镑");
	    CURRENCY_TRANS_MAP.put("840", "美元");
	    CURRENCY_TRANS_MAP.put("910", "欧元");
	}
}
