package com.tts.xiaoliji.common.service;

import com.tts.xiaoliji.common.dao.mybatis.dto.CustFriend;
import com.tts.xiaoliji.common.dao.mybatis.dto.CustInfo;
import com.tts.xiaoliji.common.dao.mybatis.dto.WxLoginLog;
import com.tts.xiaoliji.common.domain.EYesno;
import com.tts.xiaoliji.common.dto.rap.common.CustInfoDTO;
import com.tts.xiaoliji.common.dto.rap.common.FriendInfoDTO;
import com.tts.xiaoliji.common.dto.rap.common.WxLoginLogDTO;
import com.tts.xiaoliji.common.utils.MyAmountUtils;

import cn.openlo.common.util.DateUtil;
import cn.openlo.exception.LOException;

public class BeanConvertService {

	public static CustFriend toCustFriend(FriendInfoDTO from) throws LOException {

		if (null == from) {
			return null;
		}

		CustFriend bean = new CustFriend();

		// 好友ID
		bean.setFriendId(from.getFriendId());
		// 客户号
		bean.setCustNo(from.getCustNo());
		// 客户名称
		bean.setName(from.getName());
		// 性别
		bean.setGender(from.getGender());
		// 登记日期
		bean.setDateReg(DateUtil.printNowCompactDate());
		// 已删除
		bean.setFlagDeleted(EYesno.$N.getItem());
		// 备注
		bean.setRemark(from.getRemark());

		return bean;
	}

	public static FriendInfoDTO toFriendInfoDTO(CustFriend from) throws LOException {

		if (null == from) {
			return null;
		}

		FriendInfoDTO bean = new FriendInfoDTO();

		// 好友ID
		bean.setFriendId(from.getFriendId());
		// 客户号
		bean.setCustNo(from.getCustNo());
		// 客户名称
		bean.setName(from.getName());
		// 性别
		bean.setGender(from.getGender());
		// 备注
		bean.setRemark(from.getRemark());

		return bean;
	}

	public static CustInfo toCustInfo(CustInfoDTO from) throws LOException {

		if (null == from) {
			return null;
		}

		CustInfo bean = new CustInfo();

		// 客户号
		bean.setCustNo(from.getCustNo());
		// 微信ID
		bean.setWxOpenid(from.getWxOpenid());
		// 注册日期时间
		bean.setDateRegister(from.getDateRegister());
		// 好友上限
		bean.setMaxFriendCnt(MyAmountUtils.toInt(from.getMaxFriendCnt()));
		// 往来记录上限
		bean.setMaxRecordCnt(MyAmountUtils.toInt(from.getMaxRecordCnt()));

		return bean;
	}

	public static CustInfoDTO toCustInfoDTO(CustInfo from) throws LOException {

		if (null == from) {
			return null;
		}

		CustInfoDTO bean = new CustInfoDTO();

		// 客户号
		bean.setCustNo(from.getCustNo());
		// 微信ID
		bean.setWxOpenid(from.getWxOpenid());
		// 注册日期时间
		bean.setDateRegister(from.getDateRegister());
		// 好友上限
		bean.setMaxFriendCnt(MyAmountUtils.toS(from.getMaxFriendCnt()));
		// 往来记录上限
		bean.setMaxRecordCnt(MyAmountUtils.toS(from.getMaxRecordCnt()));

		return bean;
	}

	public static WxLoginLog toWxLoginLog(WxLoginLogDTO from) throws LOException {

		if (null == from) {
			return null;
		}

		WxLoginLog bean = new WxLoginLog();

		// 用户唯一标识
		bean.setOpenid(from.getOpenid());
		// 用户在开放平台的唯一标识符
		bean.setUnionid(from.getUnionid());
		// 会话密钥
		bean.setSessionKey(from.getSessionKey());
		// 微信登录时获取的code
		bean.setJsCode(from.getJsCode());
		// 用户昵称
		bean.setNickName(from.getNickName());
		// 用户头像
		bean.setAvatarUrl(from.getAvatarUrl());
		// 用户的性别
		bean.setGender(from.getGender());
		// 用户所在城市
		bean.setCity(from.getCity());
		// 用户所在省份
		bean.setProvince(from.getProvince());
		// 用户所在国家
		bean.setCountry(from.getCountry());
		// 用户的语言，简体中文为zh_CN
		bean.setLanguage(from.getLanguage());
		// 微信返回码
		bean.setWxErrcode(from.getWxErrcode());
		// 微信返回消息
		bean.setWxErrmsg(from.getWxErrmsg());
		// 备注
		bean.setRemark(from.getRemark());

		return bean;
	}

	public static WxLoginLogDTO toWxLoginLogDTO(WxLoginLog from) throws LOException {

		if (null == from) {
			return null;
		}

		WxLoginLogDTO bean = new WxLoginLogDTO();

		// 用户唯一标识
		bean.setOpenid(from.getOpenid());
		// 用户在开放平台的唯一标识符
		bean.setUnionid(from.getUnionid());
		// 会话密钥
		bean.setSessionKey(from.getSessionKey());
		// 微信登录时获取的code
		bean.setJsCode(from.getJsCode());
		// 用户昵称
		bean.setNickName(from.getNickName());
		// 用户头像
		bean.setAvatarUrl(from.getAvatarUrl());
		// 用户的性别
		bean.setGender(from.getGender());
		// 用户所在城市
		bean.setCity(from.getCity());
		// 用户所在省份
		bean.setProvince(from.getProvince());
		// 用户所在国家
		bean.setCountry(from.getCountry());
		// 用户的语言，简体中文为zh_CN
		bean.setLanguage(from.getLanguage());
		// 微信返回码
		bean.setWxErrcode(from.getWxErrcode());
		// 微信返回消息
		bean.setWxErrmsg(from.getWxErrmsg());
		// 备注
		bean.setRemark(from.getRemark());

		return bean;
	}
}