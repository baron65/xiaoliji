package com.tts.xiaoliji.common.dto.rap.common;

import java.util.List;

import cn.openlo.service.validation.VEnum;

import com.tts.xiaoliji.common.dto.rap.common.FriendTagDTO;

/**
 * <p> Title: FriendInfoDTO </p>
 * <p> Description: 公共类型[FriendInfoDTO]  </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class FriendInfoDTO {

    // 好友ID
    private String             friendId;

    // 性别0-女；1-男；2-未说明性别；
    @VEnum(enums = { "", "0", "1", "2"})
    private String             gender;

    // 名称
    private String             name;

    // 备注
    private String             remark;

    // 标签#friendTag#+
    private List<FriendTagDTO> tagList;

    // 客户号
    private String             custNo;

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public List<FriendTagDTO> getTagList() {
        return tagList;
    }

    public void setTagList(List<FriendTagDTO> tagList) {
        this.tagList = tagList;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

}
