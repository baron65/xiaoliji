package com.tts.xiaoliji.common.dto.rap;

import cn.openlo.gear.dataobject.BaseFormSupport;

/**
 * Title: RequestBaseDTO
 * <p>
 * Description: 服务请求参数的基类
 * <p>
 * Copyright: openlo.cn Copyright (C) 2016
 * 
 * @since 2016年10月2日
 */
public class RequestBaseDTO extends BaseFormSupport {

    private String channel;

    private String channelJnlNo;

    private String channelDate;

    private String operUserName;

    private String operStaffNo;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelJnlNo() {
        return channelJnlNo;
    }

    public void setChannelJnlNo(String channelJnlNo) {
        this.channelJnlNo = channelJnlNo;
    }

    public String getChannelDate() {
        return channelDate;
    }

    public void setChannelDate(String channelDate) {
        this.channelDate = channelDate;
    }

    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }

    public String getOperStaffNo() {
        return operStaffNo;
    }

    public void setOperStaffNo(String operStaffNo) {
        this.operStaffNo = operStaffNo;
    }
}