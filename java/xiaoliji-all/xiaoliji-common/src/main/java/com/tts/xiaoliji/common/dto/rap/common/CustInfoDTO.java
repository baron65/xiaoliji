package com.tts.xiaoliji.common.dto.rap.common;

/**
 * <p> Title: CustInfoDTO </p>
 * <p> Description: 公共类型[CustInfoDTO]  </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class CustInfoDTO {

    // 客户号
    private String custNo;

    // 注册日期yyyyMMdd
    private String dateRegister;

    // 好友上限
    private String maxFriendCnt;

    // 往来记录上限
    private String maxRecordCnt;

    // 微信ID
    private String wxOpenid;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

    public String getMaxFriendCnt() {
        return maxFriendCnt;
    }

    public void setMaxFriendCnt(String maxFriendCnt) {
        this.maxFriendCnt = maxFriendCnt;
    }

    public String getMaxRecordCnt() {
        return maxRecordCnt;
    }

    public void setMaxRecordCnt(String maxRecordCnt) {
        this.maxRecordCnt = maxRecordCnt;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

}
