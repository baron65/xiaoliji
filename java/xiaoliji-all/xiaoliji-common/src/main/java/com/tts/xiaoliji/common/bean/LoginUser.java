package com.tts.xiaoliji.common.bean;

public class LoginUser {

    // 客户号
    private String custNo;

    // 注册日期yyyyMMdd
    private String dateRegister;

    // 好友上限
    private String maxFriendCnt;

    // 往来记录上限
    private String maxRecordCnt;

    // 微信ID
    private String wxOpenid;

    // 用户头像
    private String avatarUrl;

    // 用户所在城市
    private String city;

    // 用户所在国家
    private String country;

    // 用户的性别0-女；1-男；2-未说明性别；
    private String gender;

    // 用户的语言
    private String language;

    // 用户昵称
    private String nickName;

    // 用户所在省份
    private String province;

    private String mobilePhone;

    private String loginToken;

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }

    public String getMaxFriendCnt() {
        return maxFriendCnt;
    }

    public void setMaxFriendCnt(String maxFriendCnt) {
        this.maxFriendCnt = maxFriendCnt;
    }

    public String getMaxRecordCnt() {
        return maxRecordCnt;
    }

    public void setMaxRecordCnt(String maxRecordCnt) {
        this.maxRecordCnt = maxRecordCnt;
    }

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    @Override
    public String toString() {
        return "LoginUser [custNo=" + custNo + ", dateRegister=" + dateRegister + ", maxFriendCnt=" + maxFriendCnt
                + ", maxRecordCnt=" + maxRecordCnt + ", wxOpenid=" + wxOpenid + ", avatarUrl=" + avatarUrl + ", city="
                + city + ", country=" + country + ", gender=" + gender + ", language=" + language + ", nickName="
                + nickName + ", province=" + province + ", mobilePhone=" + mobilePhone + ", loginToken=" + loginToken
                + "]";
    }
}