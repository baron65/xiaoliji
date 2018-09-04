package com.tts.xiaoliji.cust.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.common.dao.mybatis.client.CustInfoMapper;
import com.tts.xiaoliji.common.dao.mybatis.client.WxLoginLogMapper;
import com.tts.xiaoliji.common.dao.mybatis.dto.CustInfo;
import com.tts.xiaoliji.common.dao.mybatis.dto.CustInfoCriteria;
import com.tts.xiaoliji.common.dao.mybatis.dto.WxLoginLog;
import com.tts.xiaoliji.common.dto.rap.common.CustInfoDTO;
import com.tts.xiaoliji.common.dto.rap.common.WxLoginLogDTO;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.AddLoginLogRequest;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.AddLoginLogResponse;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.QueryCustInfoByOpenidRequest;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.QueryCustInfoByOpenidResponse;
import com.tts.xiaoliji.common.service.BeanConvertService;
import com.tts.xiaoliji.common.utils.MyNumberGen;

import cn.openlo.common.util.DateUtil;
import cn.openlo.exception.LOException;
import cn.openlo.gear.exception.GenericBizException;

@Service
public class CustService {

	@Autowired
	private CustInfoMapper custInfoMapper;
	@Autowired
	private WxLoginLogMapper wxLoginLogMapper;

	@Autowired
	private CustNumberService custNumberService;

	public QueryCustInfoByOpenidResponse queryCustInfoByOpenid(QueryCustInfoByOpenidRequest request) throws Exception {
		String openid = request.getWxOpenid();

		CustInfo custInfo = getCustInfo(openid);

		CustInfoDTO custInfoDTO = BeanConvertService.toCustInfoDTO(custInfo);

		QueryCustInfoByOpenidResponse response = new QueryCustInfoByOpenidResponse();
		response.setCustInfo(custInfoDTO);

		return response;
	}

	public AddLoginLogResponse addLoginLog(AddLoginLogRequest request) throws LOException {
		WxLoginLogDTO wxLoginLogDTO = request.getWxLoginLog();

		WxLoginLog wxLoginLog = BeanConvertService.toWxLoginLog(wxLoginLogDTO);
		save(wxLoginLog);

		AddLoginLogResponse response = new AddLoginLogResponse();
		return response;
	}

	/*
	 * public QueryCustInfoByJscodeResponse
	 * queryCustInfoByJscode(QueryCustInfoByJscodeRequest request){
	 * 
	 * // 调用wx服务，用微信登录码换取openid String jsCode = request.getJsCode();
	 * Jscode2sessionResponse jscode2sessionResponse =
	 * loginService.jscode2session(jsCode);
	 * 
	 * String openid = jscode2sessionResponse.getOpenid(); String wxErrcode =
	 * jscode2sessionResponse.getErrcode(); String wxErrmsg =
	 * jscode2sessionResponse.getErrmsg();
	 * 
	 * // 记录登录日志 WxLoginLog wxLoginLog = loginLog(request,
	 * jscode2sessionResponse);
	 * 
	 * // wx服务报错 if (!"0".equals(wxErrcode)) { throw new
	 * GenericBizException("WX0001", new Object[] { wxErrcode, wxErrmsg }); }
	 * 
	 * // 未获得预期的openid if (StringUtils.isEmpty(openid)) { throw new
	 * GenericBizException("C01001", new Object[] { jsCode }); }
	 * 
	 * 
	 * // 根据openid获取对应的custNo
	 * 
	 * IntfSession.getSession().login(user);
	 * 
	 * // TODO initAesKey(aesKey, user);
	 * 
	 * StaffLoginResponse result = new StaffLoginResponse();
	 * result.setLogonId(response.getLogonId());
	 * result.setLogonName(response.getLogonName());
	 * 
	 * String language = response.getLanguage(); if
	 * (StringUtils.isEmpty(language)) { language = "zh"; }
	 * result.setLanguage(language); return result; }
	 */

	public CustInfo getCustInfo(String wxOpenid) throws Exception {
		CustInfo custInfo = queryCustInfoByOpenid(wxOpenid);

		if (null != custInfo) {
			return custInfo;
		}

		custInfo = new CustInfo();
		custInfo.setWxOpenid(wxOpenid);
		custInfo.setDateRegister(DateUtil.printNowCompactDate());
		custInfo.setMaxFriendCnt(200);
		custInfo.setMaxRecordCnt(3000);

		save(custInfo);

		return custInfo;
	}

	public CustInfo queryCustInfoByOpenid(String wxOpenid) throws GenericBizException {
		CustInfoCriteria criterias = new CustInfoCriteria();
		CustInfoCriteria.Criteria criteria = criterias.createCriteria();

		criteria.andWxOpenidEqualTo(wxOpenid);

		List<CustInfo> list = custInfoMapper.selectByExample(criterias);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}

		if (list.size() > 1) {
			throw new GenericBizException("WX0001", new Object[] { wxOpenid });
		}

		return list.get(0);
	}

	public int save(CustInfo record) throws Exception {
		String custNo = record.getCustNo();

		if (StringUtils.isEmpty(custNo)) {
			custNo = custNumberService.nextCustNo();
			record.setCustNo(custNo);
		}

		return custInfoMapper.insert(record);
	}

	public int save(WxLoginLog record) {
		String recordId = record.getRecordId();

		if (StringUtils.isEmpty(recordId)) {
			recordId = MyNumberGen.uuid();
			record.setRecordId(recordId);
		}

		return wxLoginLogMapper.insert(record);
	}
}