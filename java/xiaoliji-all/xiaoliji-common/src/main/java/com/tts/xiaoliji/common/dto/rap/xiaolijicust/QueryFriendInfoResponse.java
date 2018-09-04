package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

import com.tts.xiaoliji.common.dto.rap.common.FriendInfoDTO;

/**
 * <p> Title: QueryFriendInfoResponse </p>
 * <p> Description: 查询好友信息 xiaoliji-cust.queryFriendInfo </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class QueryFriendInfoResponse extends com.tts.xiaoliji.common.dto.rap.ResponseBaseDTO {

    // 联系人信息#friendInfo#+
    private FriendInfoDTO friendInfo;

    public FriendInfoDTO getFriendInfo() {
        return friendInfo;
    }

    public void setFriendInfo(FriendInfoDTO friendInfo) {
        this.friendInfo = friendInfo;
    }

}
