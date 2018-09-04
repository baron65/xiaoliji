package com.tts.xiaoliji.gw.wx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tts.xiaoliji.common.dto.rap.gwwx.Jscode2sessionRequest;
import com.tts.xiaoliji.common.dto.rap.gwwx.Jscode2sessionResponse;
import com.tts.xiaoliji.gw.wx.sao.WxHttpSAO;

import cn.openlo.protocol.Protocol;
import cn.openlo.service.LOS;

@Controller
public class WxController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private WxHttpSAO wxHttpSAO;

	@LOS(name = "gw-wx.jscode2session", enableProtocols = { Protocol.DUBBO })
	public Jscode2sessionResponse jscode2session(Jscode2sessionRequest request) throws Exception {
		Jscode2sessionResponse response = wxHttpSAO.jscode2session(request);
		return response;
	}

}
