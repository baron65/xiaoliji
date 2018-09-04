package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

import cn.openlo.service.validation.VNotEmpty;

/**
 * <p> Title: QueryFriendInfoRequest </p>
 * <p> Description: 查询好友信息 xiaoliji-cust.queryFriendInfo </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class QueryFriendInfoRequest extends com.tts.xiaoliji.common.dto.rap.RequestBaseDTO {

    // 好友ID
    @VNotEmpty(message = "请指定好友id")
    private String friendId;

    // 后台的sessionKey
    private String ttsSessionKey;

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getTtsSessionKey() {
        return ttsSessionKey;
    }

    public void setTtsSessionKey(String ttsSessionKey) {
        this.ttsSessionKey = ttsSessionKey;
    }

}
