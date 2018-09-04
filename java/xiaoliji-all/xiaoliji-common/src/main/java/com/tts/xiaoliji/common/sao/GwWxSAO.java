package com.tts.xiaoliji.common.sao;

import org.springframework.stereotype.Component;

import com.tts.xiaoliji.common.dto.rap.gwwx.Jscode2sessionRequest;
import com.tts.xiaoliji.common.dto.rap.gwwx.Jscode2sessionResponse;

@Component
public class GwWxSAO extends MyBaseSAO {
    public Jscode2sessionResponse jscode2session(Jscode2sessionRequest request) throws Exception {
    	Jscode2sessionResponse response = new Jscode2sessionResponse();
        forward("gw-wx.jscode2session", request, response);
        return response;
    }

    @Override
    protected String getSysPre() {
        return "xiaoliji";
    }
}