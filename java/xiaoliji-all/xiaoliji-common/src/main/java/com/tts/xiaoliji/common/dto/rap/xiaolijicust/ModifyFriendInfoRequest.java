package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

import cn.openlo.service.validation.VNotEmpty;

import com.tts.xiaoliji.common.dto.rap.common.FriendInfoDTO;

/**
 * <p> Title: ModifyFriendInfoRequest </p>
 * <p> Description: 修改好友信息 xiaoliji-cust.modifyFriendInfo </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class ModifyFriendInfoRequest extends com.tts.xiaoliji.common.dto.rap.RequestBaseDTO {

    // 好友ID
    @VNotEmpty(message = "请指定好友id")
    private String        friendId;

    // 联系人信息#friendInfo#-
    private FriendInfoDTO friendInfo;

    // 后台的sessionKey
    private String        ttsSessionKey;

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

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
