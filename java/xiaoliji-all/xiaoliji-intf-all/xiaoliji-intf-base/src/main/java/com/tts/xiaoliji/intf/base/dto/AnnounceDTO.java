package com.tts.xiaoliji.intf.base.dto;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class AnnounceDTO {
	@Id
	private String msgId;
	private String msgType;
	private String msgTitle;
	private String msgAbstract;
	private String msgContent;
	private String rwState;
	private Date displayDate;
	private String displayType;
	@Indexed
	private Date startDate;
	@Indexed
	private Date endDate;
	private String visualScope;
	private String state;
	private List<ChannelInfo> channelInfo;
	private String extend1;
	private String extend2;
	private String extend3;

	public static class ChannelInfo {
		private String linkText;
		private String linkUrl;
		private boolean existLink = false;
		private String pubChannel;

		public String getLinkText() {
			return this.linkText;
		}

		public void setLinkText(String linkText) {
			this.linkText = linkText;
		}

		public String getLinkUrl() {
			return this.linkUrl;
		}

		public void setLinkUrl(String linkUrl) {
			this.linkUrl = linkUrl;
		}

		public boolean isExistLink() {
			return this.existLink;
		}

		public void setExistLink(boolean existLink) {
			this.existLink = existLink;
		}

		public String getPubChannel() {
			return this.pubChannel;
		}

		public void setPubChannel(String pubChannel) {
			this.pubChannel = pubChannel;
		}
	}

	public String getMsgId() {
		return this.msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgType() {
		return this.msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMsgTitle() {
		return this.msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgAbstract() {
		return this.msgAbstract;
	}

	public void setMsgAbstract(String msgCue) {
		this.msgAbstract = msgCue;
	}

	public String getMsgContent() {
		return this.msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getRwState() {
		return this.rwState;
	}

	public void setRwState(String rwState) {
		this.rwState = rwState;
	}

	public Date getDisplayDate() {
		return this.displayDate;
	}

	public void setDisplayDate(Date displayDate) {
		this.displayDate = displayDate;
	}

	public String getDisplayType() {
		return this.displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<ChannelInfo> getChannelInfo() {
		return this.channelInfo;
	}

	public void setChannelInfo(List<ChannelInfo> channelInfo) {
		this.channelInfo = channelInfo;
	}

	public String getExtend1() {
		return this.extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend2() {
		return this.extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getExtend3() {
		return this.extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getVisualScope() {
		return this.visualScope;
	}

	public void setVisualScope(String visualScope) {
		this.visualScope = visualScope;
	}
}
