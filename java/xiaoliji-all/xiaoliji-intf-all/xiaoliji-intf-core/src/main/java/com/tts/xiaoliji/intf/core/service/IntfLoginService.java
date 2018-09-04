package com.tts.xiaoliji.intf.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.common.bean.LoginUser;
import com.tts.xiaoliji.common.dto.rap.common.CustInfoDTO;
import com.tts.xiaoliji.common.dto.rap.common.WxCustInfoDTO;
import com.tts.xiaoliji.common.dto.rap.common.WxLoginLogDTO;
import com.tts.xiaoliji.common.dto.rap.gwwx.Jscode2sessionRequest;
import com.tts.xiaoliji.common.dto.rap.gwwx.Jscode2sessionResponse;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.AddLoginLogRequest;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.QueryCustInfoByOpenidRequest;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.QueryCustInfoByOpenidResponse;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.WxLoginRequest;
import com.tts.xiaoliji.common.dto.rap.xiaolijicust.WxLoginResponse;
import com.tts.xiaoliji.common.sao.CustSAO;
import com.tts.xiaoliji.common.sao.GwWxSAO;
import com.tts.xiaoliji.common.utils.MyNumberGen;
import com.tts.xiaoliji.intf.base.IntfSession;

import cn.openlo.gear.exception.GenericBizException;

@Service
public class IntfLoginService {

    @Value("${wx.xiaoliji.appid}")
    private String  appid;

    @Value("${wx.xiaoliji.secret}")
    private String  secret;

    @Value("${wx.xiaoliji.grantType}")
    private String  grantType;

    @Autowired
    private GwWxSAO gwWxSAO;

    @Autowired
    private CustSAO custSAO;

    public WxLoginResponse wxLogin(WxLoginRequest request) throws Exception {
        String jsCode = request.getJsCode();

        // 调用wx服务，用微信登录码换取openid
        Jscode2sessionResponse jscode2sessionResponse = jscode2session(jsCode);

        String openid = jscode2sessionResponse.getOpenid();
        String wxErrcode = jscode2sessionResponse.getErrcode();
        String wxErrmsg = jscode2sessionResponse.getErrmsg();

        // 记录登录日志
        saveLoginLog(request, jscode2sessionResponse);

        // wx服务报错
        if (StringUtils.hasText(wxErrcode) && !"0".equals(wxErrcode)) {
            throw new GenericBizException("WX0001", new Object[] { wxErrcode, wxErrmsg });
        }

        // 未获得预期的openid
        if (StringUtils.isEmpty(openid)) {
            throw new GenericBizException("C01001", new Object[] { jsCode });
        }

        // 根据openid查询用户信息
        CustInfoDTO custInfoDTO = getCustInfoByOpenid(openid);
        LoginUser user = new LoginUser();
        {
            // 客户号
            user.setCustNo(custInfoDTO.getCustNo());
            // 注册日期yyyyMMdd
            user.setDateRegister(custInfoDTO.getDateRegister());
            // 好友上限
            user.setMaxFriendCnt(custInfoDTO.getMaxFriendCnt());
            // 往来记录上限
            user.setMaxRecordCnt(custInfoDTO.getMaxRecordCnt());
            // 微信ID
            user.setWxOpenid(custInfoDTO.getWxOpenid());
        }

        WxCustInfoDTO wxCustInfoDTO = request.getCustInfo();
        if (null != wxCustInfoDTO) {
            // 用户头像
            user.setAvatarUrl(wxCustInfoDTO.getAvatarUrl());
            // 用户所在城市
            user.setCity(wxCustInfoDTO.getCity());
            // 用户所在国家
            user.setCountry(wxCustInfoDTO.getCountry());
            // 用户的性别0-女；1-男；2-未说明性别；
            user.setGender(wxCustInfoDTO.getGender());
            // 用户的语言
            user.setLanguage(wxCustInfoDTO.getLanguage());
            // 用户昵称
            user.setNickName(wxCustInfoDTO.getNickName());
            // 用户所在省份
            user.setProvince(wxCustInfoDTO.getProvince());
        }

        String ttsSessionKey = MyNumberGen.uuid();
        IntfSession.getSession().login(user, ttsSessionKey);

        WxLoginResponse result = new WxLoginResponse();
        result.setTtsSessionKey(ttsSessionKey);
        return result;
    }

    private CustInfoDTO getCustInfoByOpenid(String openid) throws Exception {
        QueryCustInfoByOpenidRequest request = new QueryCustInfoByOpenidRequest();
        request.setWxOpenid(openid);

        QueryCustInfoByOpenidResponse response = custSAO.queryCustInfoByOpenid(request);

        CustInfoDTO custInfoDTO = response.getCustInfo();
        return custInfoDTO;
    }

    public Jscode2sessionResponse jscode2session(String jsCode) throws Exception {
        Jscode2sessionRequest jscode2sessionRequest;
        {
            jscode2sessionRequest = new Jscode2sessionRequest();
            jscode2sessionRequest.setAppid(appid);
            jscode2sessionRequest.setSecret(secret);
            jscode2sessionRequest.setGrant_type(grantType);
            jscode2sessionRequest.setJs_code(jsCode);
        }
        Jscode2sessionResponse jscode2sessionResponse = gwWxSAO.jscode2session(jscode2sessionRequest);
        return jscode2sessionResponse;
    }

    public void saveLoginLog(WxLoginRequest wxLoginRequest, Jscode2sessionResponse jscode2sessionResponse)
            throws Exception {
        String jsCode = wxLoginRequest.getJsCode();

        String openid = jscode2sessionResponse.getOpenid();
        String unionid = jscode2sessionResponse.getUnionid();
        String sessionKey = jscode2sessionResponse.getSession_key();
        String wxErrcode = jscode2sessionResponse.getErrcode();
        String wxErrmsg = jscode2sessionResponse.getErrmsg();

        WxLoginLogDTO wxLoginLogDTO = new WxLoginLogDTO();
        wxLoginLogDTO.setOpenid(openid);
        wxLoginLogDTO.setUnionid(unionid);
        wxLoginLogDTO.setSessionKey(sessionKey);
        wxLoginLogDTO.setJsCode(jsCode);
        wxLoginLogDTO.setWxErrcode(wxErrcode);
        wxLoginLogDTO.setWxErrmsg(wxErrmsg);

        WxCustInfoDTO wxCustInfoDTO = wxLoginRequest.getCustInfo();
        if (null != wxCustInfoDTO) {
            String nickName = wxCustInfoDTO.getNickName();
            String avatarUrl = wxCustInfoDTO.getAvatarUrl();
            String gender = wxCustInfoDTO.getGender();
            String city = wxCustInfoDTO.getCity();
            String province = wxCustInfoDTO.getProvince();
            String country = wxCustInfoDTO.getCountry();
            String language = wxCustInfoDTO.getLanguage();
            wxLoginLogDTO.setNickName(nickName);
            wxLoginLogDTO.setAvatarUrl(avatarUrl);
            wxLoginLogDTO.setGender(gender);
            wxLoginLogDTO.setCity(city);
            wxLoginLogDTO.setProvince(province);
            wxLoginLogDTO.setCountry(country);
            wxLoginLogDTO.setLanguage(language);
        }

        AddLoginLogRequest addLoginLogRequest = new AddLoginLogRequest();
        addLoginLogRequest.setWxLoginLog(wxLoginLogDTO);

        custSAO.addLoginLog(addLoginLogRequest);
    }
}