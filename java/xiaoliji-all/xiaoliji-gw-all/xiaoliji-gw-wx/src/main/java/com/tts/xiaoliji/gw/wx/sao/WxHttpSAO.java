package com.tts.xiaoliji.gw.wx.sao;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.tts.xiaoliji.common.dto.rap.RequestBaseDTO;
import com.tts.xiaoliji.common.dto.rap.gwwx.Jscode2sessionRequest;
import com.tts.xiaoliji.common.dto.rap.gwwx.Jscode2sessionResponse;
import com.tts.xiaoliji.gw.wx.utils.HttpUtils;

import cn.openlo.common.beanutils.BeanToMap;

@Component
public class WxHttpSAO {

    Logger         logger = LoggerFactory.getLogger(getClass());

    @Value("${wx.http.url.jscode2session}")
    private String urlJscode2session;

    /**
     * 向综拓同步产品
     *
     */
    public Jscode2sessionResponse jscode2session(Jscode2sessionRequest request) throws Exception {
        String url = urlJscode2session;
        Map<String, Object> params = toHttpParams(request);

        String text = wxHttps(url, params);

        Jscode2sessionResponse response = JSON.parseObject(text, Jscode2sessionResponse.class);
        return response;
    }

    public String wxHttps(String url, Map<String, Object> params) throws Exception {
        logger.info("wx.https.url: " + url);
        logger.info("wx.https.params: " + params);

        String text = HttpUtils.get(url, params);

        logger.info("wx.https.result: " + text);

        return text;
    }

    public Map<String, Object> toHttpParams(RequestBaseDTO request) throws Exception {
        Map<String, Object> params = (Map<String, Object>) BeanToMap.toMap(request);

        params.remove("channel");
        params.remove("channelJnlNo");
        params.remove("channelDate");
        params.remove("operUserName");
        params.remove("operStaffNo");
        params.remove("channel");
        params.remove("channelDate");
        params.remove("channelJnlNo");
        params.remove("sourceSystemId");

        return params;
    }
}