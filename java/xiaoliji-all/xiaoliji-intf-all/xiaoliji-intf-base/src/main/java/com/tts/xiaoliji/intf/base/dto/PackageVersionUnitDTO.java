package com.tts.xiaoliji.intf.base.dto;

import java.util.List;

public class PackageVersionUnitDTO {
	private String prefix;
	private List<PackageVersionItemDTO> itemList;

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public List<PackageVersionItemDTO> getItemList() {
		return this.itemList;
	}

	public void setItemList(List<PackageVersionItemDTO> itemList) {
		this.itemList = itemList;
	}
}
