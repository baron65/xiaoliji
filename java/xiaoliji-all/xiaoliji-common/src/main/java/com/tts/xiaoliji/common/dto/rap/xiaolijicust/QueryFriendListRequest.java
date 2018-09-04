package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

/**
 * <p> Title: QueryFriendListRequest </p>
 * <p> Description: 查询好友列表 xiaoliji-cust.queryFriendList </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class QueryFriendListRequest extends com.tts.xiaoliji.common.dto.rap.RequestBaseDTO {

    // 后台的sessionKey
    private String ttsSessionKey;

    public String getTtsSessionKey() {
        return ttsSessionKey;
    }

    public void setTtsSessionKey(String ttsSessionKey) {
        this.ttsSessionKey = ttsSessionKey;
    }

}
