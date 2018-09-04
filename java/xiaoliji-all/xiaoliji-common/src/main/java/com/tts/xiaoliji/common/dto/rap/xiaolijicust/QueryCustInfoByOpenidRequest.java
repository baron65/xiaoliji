package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

/**
 * <p> Title: QueryCustInfoByOpenidRequest </p>
 * <p> Description: 根据微信openid查询用户信息 xiaoliji-cust.queryCustInfoByOpenid </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class QueryCustInfoByOpenidRequest extends com.tts.xiaoliji.common.dto.rap.RequestBaseDTO {

    // 微信ID
    private String wxOpenid;

    public String getWxOpenid() {
        return wxOpenid;
    }

    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

}
