package com.tts.xiaoliji.intf.base.constant;

import java.util.HashSet;
import java.util.Set;

public class IntfFilterConstant {
	public static final String CURRENT_FLOW_KEY = "curFlow";
	public static final String PRE_FLOW_KEY = "preFlow";
	public static final String SERVICE_CTRL_FLOW_TYPE = "flowType";
	public static final String SERVICE_CTRL_FLOW_SKIP_KEY = "skipFlowKey";
	public static final String RISK_EVENT_NAME = "eventName";
	public static final String NOALTER_IMPORTANT_KEYS = "noAlterImportantKeys";
	public static final String ENC_TYPE_REQUEST = "encType";
	public static final String ENC_TYPE_RSA_REQUEST = "encRSA";
	public static final String ENC_TYPE_PRE_AES_REQUEST = "encPreAES";
	public static final String ENC_TYPE_LOGIN_AES_REQUEST = "encLoginAES";
	public static final String ENC_DATA_KEY = "_enData_";
	public static final String SESSION_ENC_KEY_NO_USER = "_sessionPreLoginAESKey_";
	public static final String DEFAULT_SESSION_AES_KEY = "_sessionAESKey_";
	public static final String VERSION_NO = "_client_version_no";
	public static final String FUND_WX_ONLY_KEY = "_fund_only";
	public static final String TEMP_USER_OK = "_temp_user";
	public static final String PC_LIVE_USER_OK = "_pc_live_user";
	public static final String TEMP_SESSION_USER_KEY = "temp_session_user_key";
	public static final int ORDER_INTFSESSION_FILTER = 0;
	public static final int ORDER_USERACCESS_FILTER = 3;
	public static final int ORDER_MSGSUMM_FILTER = 5;
	public static final int ORDER_AESDECRYPT_FILTER = 10;
	public static final int ORDER_ILLEGALCHAR_FILTER = 15;
	public static final int ORDER_DYNAMICTOKEN_FILTER = 20;
	public static final int ORDER_INTFLOG_FILTER = 40;
	public static final int ORDER_USERCHECK_FILTER = 60;
	public static final int ORDER_TOKENCONTROL_FILTER = 90;
	public static final int ORDER_NOTALTER_FILTER = 100;
	public static final int ORDER_FLOWCTRL_FILTER = 110;
	public static final int ORDER_SMSVALID_FILTER = 120;
	public static final int ORDER_ACCTPWD_FILTER = 130;
	public static final int ORDER_LOGIN_LOG_FILTER = 140;
	public static final Set<String> ALLOW_KEY_SET = new HashSet<String>();

	static {
		ALLOW_KEY_SET.add("_client_version_no");
		ALLOW_KEY_SET.add("UFO-SESSION-ID");
		ALLOW_KEY_SET.add("reqData");
		ALLOW_KEY_SET.add("_channel_id");
		ALLOW_KEY_SET.add("_request_client_info");
		ALLOW_KEY_SET.add("_deviceId");
		ALLOW_KEY_SET.add("loginId");
	}
}
