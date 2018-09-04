package com.tts.xiaoliji.intf.base.constant;

public enum EnumChannel {
	iOS("01"), Android("02"), PC("03"), WX("04"), Fund("05"), PcLive("06");

	private String value;

	private EnumChannel(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
