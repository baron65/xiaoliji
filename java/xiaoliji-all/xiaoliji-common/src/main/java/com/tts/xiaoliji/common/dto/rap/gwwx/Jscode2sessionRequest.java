package com.tts.xiaoliji.common.dto.rap.gwwx;

/**
 * <p> Title: Jscode2sessionRequest </p>
 * <p> Description: code 换取 session_key gw-wx.jscode2session </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class Jscode2sessionRequest extends com.tts.xiaoliji.common.dto.rap.RequestBaseDTO {

    // 小程序唯一标识
    private String appid;

    // 填写为 authorization_code
    private String grant_type;

    // 登录时获取的 code
    private String js_code;

    // 小程序的 app secret
    private String secret;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getJs_code() {
        return js_code;
    }

    public void setJs_code(String js_code) {
        this.js_code = js_code;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

}
