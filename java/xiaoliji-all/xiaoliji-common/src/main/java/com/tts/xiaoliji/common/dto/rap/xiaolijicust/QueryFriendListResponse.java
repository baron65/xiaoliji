package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

import java.util.List;

/**
 * <p> Title: QueryFriendListResponse </p>
 * <p> Description: 查询好友列表 xiaoliji-cust.queryFriendList </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class QueryFriendListResponse extends com.tts.xiaoliji.common.dto.rap.ResponseBaseDTO {

    // 联系人列表
    private List<FriendDTO> friendList;

    // 结果总数
    private String          totalCount;

    public List<FriendDTO> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<FriendDTO> friendList) {
        this.friendList = friendList;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public static class FriendDTO {

        // 性别0-女；1-男；2-未说明性别；
        private String gender;

        // 最新一次往来日期yyyyMMdd
        private String lastRecordDate;

        // 名称
        private String name;

        // 备注
        private String remark;

        // 好友ID
        private String friendId;

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getLastRecordDate() {
            return lastRecordDate;
        }

        public void setLastRecordDate(String lastRecordDate) {
            this.lastRecordDate = lastRecordDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getFriendId() {
            return friendId;
        }

        public void setFriendId(String friendId) {
            this.friendId = friendId;
        }

    }

}
