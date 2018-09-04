package com.tts.xiaoliji.intf.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tts.xiaoliji.common.dto.rap.xiaolijicust.WxLoginRequest;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.WxLoginResponse;
import com.tts.xiaoliji.intf.core.service.IntfLoginService;

import cn.openlo.exception.LOSException;
import cn.openlo.gear.exception.GenericBizException;
import cn.openlo.service.LOS;
import cn.openlo.service.LOSFilters;
import cn.openlo.service.validation.Valid;

@Controller
public class IntfLoginController {

    private Logger           logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IntfLoginService intfLoginService;

    @LOS(name = "xiaoliji-intf-cust.wxLogin", enableProtocols = {
            cn.openlo.protocol.Protocol.HTTP }, properties = "encType=encPreAES")
    @LOSFilters(excludeList = { "userAccessCheckFilter" })
    public WxLoginResponse staffLogin(@Valid WxLoginRequest request) throws LOSException {
        WxLoginResponse response;
        try {
            response = intfLoginService.wxLogin(request);
        }
        catch (GenericBizException e) {
            throw e;
        }
        catch (Exception e) {
            throw new GenericBizException("L99999", e);
        }

        return response;
    }
}