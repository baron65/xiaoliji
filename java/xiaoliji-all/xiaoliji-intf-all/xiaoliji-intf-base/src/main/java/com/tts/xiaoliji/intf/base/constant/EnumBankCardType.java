package com.tts.xiaoliji.intf.base.constant;

public enum EnumBankCardType {
	CORP_ACCT("00"), DEBIT_CARD("01"), CREDIT_CARD("02"), E_ACCT("03");

	private String name;

	private EnumBankCardType(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
