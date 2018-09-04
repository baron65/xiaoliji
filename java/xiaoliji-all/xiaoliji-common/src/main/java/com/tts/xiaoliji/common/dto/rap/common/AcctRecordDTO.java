package com.tts.xiaoliji.common.dto.rap.common;

import java.util.List;

import com.tts.xiaoliji.common.dto.rap.common.AcctProjectDTO;

/**
 * <p> Title: AcctRecordDTO </p>
 * <p> Description: 公共类型[AcctRecordDTO]  </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class AcctRecordDTO {

    // 金额
    private String               amount;

    // 日期yyyyMMdd
    private String               date;

    // 备注
    private String               remark;

    // 往来类型in-收礼金；out-送礼金；
    private String               type;

    // 往来记录号
    private String               acctRecordId;

    // 好友ID
    private String               friendId;

    // 项目列表#acctProject#+
    private List<AcctProjectDTO> projectList;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAcctRecordId() {
        return acctRecordId;
    }

    public void setAcctRecordId(String acctRecordId) {
        this.acctRecordId = acctRecordId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public List<AcctProjectDTO> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<AcctProjectDTO> projectList) {
        this.projectList = projectList;
    }

}
