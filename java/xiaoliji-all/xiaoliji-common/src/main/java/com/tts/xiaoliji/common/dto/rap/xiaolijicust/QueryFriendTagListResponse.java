package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

import java.util.List;

import com.tts.xiaoliji.common.dto.rap.common.FriendTagDTO;

/**
 * <p> Title: QueryFriendTagListResponse </p>
 * <p> Description: 查询可以用来标记好友的标签 xiaoliji-cust.queryFriendTagList </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class QueryFriendTagListResponse extends com.tts.xiaoliji.common.dto.rap.ResponseBaseDTO {

    // 标签列表（for friend）#friendTag#-
    private List<FriendTagDTO> friendTagList;

    public List<FriendTagDTO> getFriendTagList() {
        return friendTagList;
    }

    public void setFriendTagList(List<FriendTagDTO> friendTagList) {
        this.friendTagList = friendTagList;
    }

}
