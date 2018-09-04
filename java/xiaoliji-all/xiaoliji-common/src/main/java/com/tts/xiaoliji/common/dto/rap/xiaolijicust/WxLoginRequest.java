package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

import com.tts.xiaoliji.common.dto.rap.common.WxCustInfoDTO;

/**
 * <p> Title: WxLoginRequest </p>
 * <p> Description: 登录 xiaoliji-cust.wxLogin </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class WxLoginRequest extends com.tts.xiaoliji.common.dto.rap.RequestBaseDTO {

    // 用户信息#wxCustInfo#+
    private WxCustInfoDTO custInfo;

    // 微信登录时获取的code
    private String        jsCode;

    public WxCustInfoDTO getCustInfo() {
        return custInfo;
    }

    public void setCustInfo(WxCustInfoDTO custInfo) {
        this.custInfo = custInfo;
    }

    public String getJsCode() {
        return jsCode;
    }

    public void setJsCode(String jsCode) {
        this.jsCode = jsCode;
    }

}
