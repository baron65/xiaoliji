package com.tts.xiaoliji.intf.base.dto;

import java.util.Date;
import java.util.Map;

public class IntfLoginLogDTO {
	private String channelJnlNo;
	private String sessionId;
	private String userId;
	private String loginName;
	private String responseCode;
	private String responseMsg;
	private String serviceName;
	private Date dateCreated;
	private Date dateUpdated;
	private Date loginDate;
	private Map<?, ?> request;
	private Object response;

	public String getChannelJnlNo() {
		return this.channelJnlNo;
	}

	public void setChannelJnlNo(String channelJnlNo) {
		this.channelJnlNo = channelJnlNo;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getResponseCode() {
		return this.responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return this.responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Date getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Map<?, ?> getRequest() {
		return this.request;
	}

	public void setRequest(Map<?, ?> request) {
		this.request = request;
	}

	public Object getResponse() {
		return this.response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}
}
