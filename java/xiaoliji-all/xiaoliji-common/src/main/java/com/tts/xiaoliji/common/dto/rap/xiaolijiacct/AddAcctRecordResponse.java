package com.tts.xiaoliji.common.dto.rap.xiaolijiacct;

/**
 * <p> Title: AddAcctRecordResponse </p>
 * <p> Description: 新增往来记录 xiaoliji-acct.addAcctRecord </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class AddAcctRecordResponse extends com.tts.xiaoliji.common.dto.rap.ResponseBaseDTO {

    // 往来记录号
    private String acctRecordId;

    public String getAcctRecordId() {
        return acctRecordId;
    }

    public void setAcctRecordId(String acctRecordId) {
        this.acctRecordId = acctRecordId;
    }

}
