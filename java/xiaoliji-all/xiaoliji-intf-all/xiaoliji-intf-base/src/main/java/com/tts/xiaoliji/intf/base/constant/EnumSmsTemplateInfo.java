package com.tts.xiaoliji.intf.base.constant;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.tts.xiaoliji.intf.base.exception.InvalidInputException;

import cn.openlo.exception.LOSException;

public enum EnumSmsTemplateInfo {
	Register("regist", "SMS_INTF_20160922002", EnumPhoneType.Upload), WXRegister("wxregist", "SMS_INTF_20160922002",
			EnumPhoneType.Upload), BindCard("bindCard", "SMS_INTF_20160922007", EnumPhoneType.Upload), LoginPwd(
					"loginPwd", "SMS_INTF_20160922003", EnumPhoneType.Upload), ReplacePhone("replacePhone",
							"SMS_INTF_20160922008", EnumPhoneType.Upload), FindPwd("findPwd", "SMS_INTF_20160922004",
									EnumPhoneType.SessionUser), ModifyPwd("modifyPwd", "SMS_INTF_20160922006",
											EnumPhoneType.SessionUser), ReplaceUserPhone("replaceUserPhone",
													"SMS_INTF_20160922008",
													EnumPhoneType.SessionUser), SessionUser("user", "ALL_INTF1003",
															EnumPhoneType.SessionUser), SpecialSession("business",
																	"ALL_INTF2001",
																	EnumPhoneType.SpecialSession), CardIdentity(
																			"cardIdentity", "SMS_INTF_20160922005",
																			EnumPhoneType.SpecialSession), SafeIdentity(
																					"safeIdentity",
																					"SMS_INTF_20160922001",
																					EnumPhoneType.SpecialSession), MOPActivity(
																							"mop",
																							"SMS_INTF_20160922013",
																							EnumPhoneType.Upload), FUNDRegist(
																									"fundReg",
																									"SMS_INTF_20161214001",
																									EnumPhoneType.Upload), FUNDValid(
																											"fundValid",
																											"SMS_INTF_20161214002",
																											EnumPhoneType.SpecialSession), Illegal(
																													"illegal",
																													"",
																													EnumPhoneType.Upload);

	private static Map<String, EnumSmsTemplateInfo> smsTemplateMap;
	private String type;
	private String templateId;
	private EnumPhoneType phoneType;

	static {
		smsTemplateMap = new HashMap<String,EnumSmsTemplateInfo>();
		for (EnumSmsTemplateInfo template : EnumSet.allOf(EnumSmsTemplateInfo.class)) {
			smsTemplateMap.put(template.type, template);
		}
	}

	private EnumSmsTemplateInfo(String type, String templateId, EnumPhoneType phoneType) {
		this.type = type;
		this.templateId = templateId;
		this.phoneType = phoneType;
	}

	public String getType() {
		return this.type;
	}

	public String getTemplateId() {
		return this.templateId;
	}

	public EnumPhoneType getPhoneType() {
		return this.phoneType;
	}

	public static EnumSmsTemplateInfo getSmsTemplateInfo(String type) throws LOSException {
		EnumSmsTemplateInfo tempateInfo = (EnumSmsTemplateInfo) smsTemplateMap.get(type);
		if (tempateInfo == null) {
			throw new InvalidInputException("invalid.sms.type");
		}
		return tempateInfo;
	}

	public static enum EnumPhoneType {
		Upload, SessionUser, SpecialSession;

		private EnumPhoneType() {
		}
	}
}
