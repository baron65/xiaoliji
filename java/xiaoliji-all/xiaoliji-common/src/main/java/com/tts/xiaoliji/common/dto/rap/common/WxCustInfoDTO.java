package com.tts.xiaoliji.common.dto.rap.common;

import cn.openlo.service.validation.VEnum;

/**
 * <p> Title: WxCustInfoDTO </p>
 * <p> Description: 公共类型[WxCustInfoDTO]  </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class WxCustInfoDTO {

    // 用户头像
    private String avatarUrl;

    // 用户所在城市
    private String city;

    // 用户所在国家
    private String country;

    // 用户的性别0-女；1-男；2-未说明性别；
    @VEnum(enums = { "", "0", "1", "2"})
    private String gender;

    // 用户的语言
    private String language;

    // 用户昵称
    private String nickName;

    // 用户所在省份
    private String province;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}
