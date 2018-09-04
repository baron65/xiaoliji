package com.tts.xiaoliji.common.dto.rap.xiaolijiacct;

/**
 * <p> Title: QueryAcctRecordListRequest </p>
 * <p> Description: 查询往来记录 xiaoliji-acct.queryAcctRecordList </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class QueryAcctRecordListRequest extends com.tts.xiaoliji.common.dto.rap.RequestBaseDTO {

    // 后台的sessionKey
    private String ttsSessionKey;

    public String getTtsSessionKey() {
        return ttsSessionKey;
    }

    public void setTtsSessionKey(String ttsSessionKey) {
        this.ttsSessionKey = ttsSessionKey;
    }

}
