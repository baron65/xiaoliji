package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

import com.tts.xiaoliji.common.dto.rap.common.FriendInfoDTO;

/**
 * <p> Title: AddFriendRequest </p>
 * <p> Description: 新增好友 xiaoliji-cust.addFriend </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class AddFriendRequest extends com.tts.xiaoliji.common.dto.rap.RequestBaseDTO {

    // 联系人信息#friendInfo#-
    private FriendInfoDTO friendInfo;

    // 后台的sessionKey
    private String        ttsSessionKey;

    public FriendInfoDTO getFriendInfo() {
        return friendInfo;
    }

    public void setFriendInfo(FriendInfoDTO friendInfo) {
        this.friendInfo = friendInfo;
    }

    public String getTtsSessionKey() {
        return ttsSessionKey;
    }

    public void setTtsSessionKey(String ttsSessionKey) {
        this.ttsSessionKey = ttsSessionKey;
    }

}
