package com.tts.xiaoliji.cust.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tts.xiaoliji.common.controller.BaseController;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.AddLoginLogRequest;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.AddLoginLogResponse;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.QueryCustInfoByOpenidRequest;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.QueryCustInfoByOpenidResponse;
import com.tts.xiaoliji.cust.core.service.CustService;

import cn.openlo.protocol.Protocol;
import cn.openlo.service.LOS;

@Controller
public class CustController extends BaseController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustService custService;
	
	@LOS(name = "xiaoliji-cust.queryCustInfoByOpenid", enableProtocols = { Protocol.DUBBO })
	public QueryCustInfoByOpenidResponse queryCustInfoByOpenid(QueryCustInfoByOpenidRequest request) throws Exception {
		QueryCustInfoByOpenidResponse response = custService.queryCustInfoByOpenid(request);
		return response;
	}
	
	@LOS(name = "xiaoliji-cust.addLoginLog", enableProtocols = { Protocol.DUBBO })
	public AddLoginLogResponse addLoginLog(AddLoginLogRequest request) throws Exception {
		AddLoginLogResponse response = custService.addLoginLog(request);
		return response;
	}
}