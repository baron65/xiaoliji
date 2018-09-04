package com.tts.xiaoliji.common.dto.rap.gwwx;

/**
 * <p> Title: Jscode2sessionResponse </p>
 * <p> Description: code 换取 session_key gw-wx.jscode2session </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class Jscode2sessionResponse extends com.tts.xiaoliji.common.dto.rap.ResponseBaseDTO {

    // 错误码
    private String errcode;

    // 错误消息
    private String errmsg;

    // 用户唯一标识
    private String openid;

    // 会话密钥
    private String session_key;

    // 用户在开放平台的唯一标识符
    private String unionid;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

}
