package com.tts.xiaoliji.common.dto.rap.xiaolijiacct;

import com.tts.xiaoliji.common.dto.rap.common.AcctRecordDTO;

/**
 * <p> Title: AddAcctRecordRequest </p>
 * <p> Description: 新增往来记录 xiaoliji-acct.addAcctRecord </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class AddAcctRecordRequest extends com.tts.xiaoliji.common.dto.rap.RequestBaseDTO {

    // 往来记录#acctRecord#-
    private AcctRecordDTO acctRecord;

    // 后台的sessionKey
    private String        ttsSessionKey;

    public AcctRecordDTO getAcctRecord() {
        return acctRecord;
    }

    public void setAcctRecord(AcctRecordDTO acctRecord) {
        this.acctRecord = acctRecord;
    }

    public String getTtsSessionKey() {
        return ttsSessionKey;
    }

    public void setTtsSessionKey(String ttsSessionKey) {
        this.ttsSessionKey = ttsSessionKey;
    }

}
