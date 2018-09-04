package com.tts.xiaoliji.intf.base.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class GlobalAttrDTO {
	@Id
	private String key;
	private String jsonContent;
	private Date lastUpdateDate;
	private String status;

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getJsonContent() {
		return this.jsonContent;
	}

	public void setJsonContent(String jsonContent) {
		this.jsonContent = jsonContent;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
