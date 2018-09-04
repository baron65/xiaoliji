package com.tts.xiaoliji.intf.base.utils;

import java.util.List;
import java.util.Map;

import com.tts.xiaoliji.intf.base.IntfSession;

public class IntfSessionUtil {
	static final String LOGIN = "login.";
	static final String PWD_ERR_CNT = "pwdErrCnt";
	static final String SMSCHECK = "smscheck.";
	static final String SMSCHECKKEY = "smsCheckKey";
	static final String BANKLISTKEY = "bankListKey";
	public static final String ROLELISTKEY = "globalRoleList";

	public static Integer getPwdErrCnt(String loginName) {
		return (Integer) IntfSession.getSession().getGlobalAttribute("login." + loginName, "pwdErrCnt");
	}

	public static void setPwdErrCnt(String loginName, Integer pwdErrCnt) {
		IntfSession.getSession().setGlobalAttribute("login." + loginName, "pwdErrCnt", pwdErrCnt);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getMobileCheckRecord(String mobile) {
		return (Map<String, Object>) IntfSession.getSession().getGlobalAttribute("smscheck." + mobile, "smsCheckKey");
	}

	public static void setMobileCheckRecord(String mobile, Map smsSendMap) {
		IntfSession.getSession().setGlobalAttribute("smscheck." + mobile, "smsCheckKey", smsSendMap);
	}

	public static Integer getMobileCheckError(String mobile) {
		Map<String, Object> map = getMobileCheckRecord(mobile);
		if (map == null) {
			return Integer.valueOf(0);
		}
		return (Integer) map.get("_errCount");
	}

	public static void setCacheBankList(List bankList) {
		IntfSession.getSession().setGlobalAttribute("bankListKey", "bankListKey", bankList);
	}

	public static List getCacheBankList() {
		return (List) IntfSession.getSession().getGlobalAttribute("bankListKey", "bankListKey", List.class);
	}

	@Deprecated
	public static List getRoleList() {
		return (List) IntfSession.getSession().getGlobalAttribute("globalRoleList", "globalRoleList", List.class);
	}

	@Deprecated
	public static void setRoleList(List roleList) {
		IntfSession.getSession().setGlobalAttribute("globalRoleList", "globalRoleList", roleList);
	}
}
