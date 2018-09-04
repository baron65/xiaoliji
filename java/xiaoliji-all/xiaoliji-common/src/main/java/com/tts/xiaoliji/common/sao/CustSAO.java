package com.tts.xiaoliji.common.sao;

import org.springframework.stereotype.Component;

import com.tts.xiaoliji.common.dto.rap.xiaolijicust.AddLoginLogRequest;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.AddLoginLogResponse;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.QueryCustInfoByOpenidRequest;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.QueryCustInfoByOpenidResponse;

@Component
public class CustSAO extends MyBaseSAO {

    public QueryCustInfoByOpenidResponse queryCustInfoByOpenid(QueryCustInfoByOpenidRequest request) throws Exception {
        QueryCustInfoByOpenidResponse response = new QueryCustInfoByOpenidResponse();
        forward("xiaoliji-cust.queryCustInfoByOpenid", request, response);
        return response;
    }

    public AddLoginLogResponse addLoginLog(AddLoginLogRequest request) throws Exception {
        AddLoginLogResponse response = new AddLoginLogResponse();
        forward("xiaoliji-cust.addLoginLog", request, response);
        return response;
    }

    @Override
    protected String getSysPre() {
        return "xiaoliji";
    }
}