package com.tts.xiaoliji.intf.base.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {
    Logger logger = LoggerFactory.getLogger(getClass());
    // 用户中文名
    private String userName;

    private String mobilePhone;
    //
    // 用户Id 对应 staffNo
    private String userId;

    // um号，一般是邮箱前缀
    private String umNo;

    public String getUmNo() {
        return umNo;
    }

    public void setUmNo(String umNo) {
        this.umNo = umNo;
    }

    private String userStatus;

    private String deptName;

    private String sex;

    private String birthdate;

    private String idType;
    private String idNo;

    private String headImgId;

    private String newDeviceCheck;

    private String loginToken;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String custName) {
        this.userName = custName;
    }

    public String getMobilePhone() {
        return this.mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    //
    // public String getMobilePhoneSec() {
    // return this.mobilePhoneSec;
    // }
    //
    // public void setMobilePhoneSec(String mobilePhoneSec) {
    // this.mobilePhoneSec = mobilePhoneSec;
    // }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String staffNo) {
        this.userId = staffNo;
    }

    public String getUserStatus() {
        return this.userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthdate() {
        return this.birthdate;
    }

    public void setBirthdate(String birthDay) {
        this.birthdate = birthDay;
    }

    public String getHeadImgId() {
        return this.headImgId;
    }

    public void setHeadImgId(String headImgId) {
        this.headImgId = headImgId;
    }

    public String getNewDeviceCheck() {
        return this.newDeviceCheck;
    }

    public void setNewDeviceCheck(String newDeviceCheck) {
        this.newDeviceCheck = newDeviceCheck;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

}
