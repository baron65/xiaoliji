package com.tts.xiaoliji.intf.base.constant;

public enum EnumEventName {
	REGIST("register_event", "��������"), LOGIN("login_event", "��������");

	private String name;
	private String desc;

	private EnumEventName(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
