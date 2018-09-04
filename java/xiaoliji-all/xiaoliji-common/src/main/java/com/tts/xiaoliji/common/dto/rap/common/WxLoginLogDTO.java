package com.tts.xiaoliji.common.dto.rap.common;

import cn.openlo.service.validation.VEnum;

/**
 * <p> Title: WxLoginLogDTO </p>
 * <p> Description: 公共类型[WxLoginLogDTO]  </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class WxLoginLogDTO {

    // 用户头像
    private String avatarUrl;

    // 用户所在城市
    private String city;

    // 用户所在国家
    private String country;

    // 客户号
    private String custNo;

    // 用户的性别0-女；1-男；2-未说明性别；
    @VEnum(enums = { "", "0", "1", "2"})
    private String gender;

    // 微信登录时获取的code
    private String jsCode;

    // 用户的语言
    private String language;

    // 用户昵称
    private String nickName;

    // 微信ID
    private String openid;

    // 用户所在省份
    private String province;

    // 会话密钥
    private String sessionKey;

    // 用户在开放平台的唯一标识符
    private String unionid;

    // 微信登录错误码
    private String wxErrcode;

    // 微信登录错误消息
    private String wxErrmsg;

    // 备注
    private String remark;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJsCode() {
        return jsCode;
    }

    public void setJsCode(String jsCode) {
        this.jsCode = jsCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getWxErrcode() {
        return wxErrcode;
    }

    public void setWxErrcode(String wxErrcode) {
        this.wxErrcode = wxErrcode;
    }

    public String getWxErrmsg() {
        return wxErrmsg;
    }

    public void setWxErrmsg(String wxErrmsg) {
        this.wxErrmsg = wxErrmsg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
