package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

import com.tts.xiaoliji.common.dto.rap.common.CustInfoDTO;

/**
 * <p> Title: QueryCustInfoByOpenidResponse </p>
 * <p> Description: 根据微信openid查询用户信息 xiaoliji-cust.queryCustInfoByOpenid </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class QueryCustInfoByOpenidResponse extends com.tts.xiaoliji.common.dto.rap.ResponseBaseDTO {

    // 用户信息#custInfo#+
    private CustInfoDTO custInfo;

    public CustInfoDTO getCustInfo() {
        return custInfo;
    }

    public void setCustInfo(CustInfoDTO custInfo) {
        this.custInfo = custInfo;
    }

}
