package com.tts.xiaoliji.cust.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.xiaoliji.common.ext.dao.mybatis.client.ExtNumberMapper;

@Service
public class CustNumberService {

	@Autowired
	private ExtNumberMapper extNumberMapper;

	public String nextCustNo() throws Exception {

		String prefix = "WX_CUST_NO";

		int seq = extNumberMapper.getNextNumber(prefix, "");

		String format = "%1$s%2$05d";

		String result = String.format(format, "WX_", seq);

		return result;
	}
}