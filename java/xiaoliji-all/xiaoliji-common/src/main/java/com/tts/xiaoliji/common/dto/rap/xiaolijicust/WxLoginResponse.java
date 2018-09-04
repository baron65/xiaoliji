package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

/**
 * <p> Title: WxLoginResponse </p>
 * <p> Description: 登录 xiaoliji-cust.wxLogin </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class WxLoginResponse extends com.tts.xiaoliji.common.dto.rap.ResponseBaseDTO {

    // 后台的sessionKey
    private String ttsSessionKey;

    public String getTtsSessionKey() {
        return ttsSessionKey;
    }

    public void setTtsSessionKey(String ttsSessionKey) {
        this.ttsSessionKey = ttsSessionKey;
    }

}
