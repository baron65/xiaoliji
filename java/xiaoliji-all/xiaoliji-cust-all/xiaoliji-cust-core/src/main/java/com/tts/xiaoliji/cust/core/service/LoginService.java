package com.tts.xiaoliji.cust.core.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    /*
    	@Value("${wx.xiaoliji.appid}")
    	private String appid;
    
    	@Value("${wx.xiaoliji.secret}")
    	private String secret;
    
    	@Value("${wx.xiaoliji.grantType}")
    	private String grantType;
    
    	@Autowired
    	private GwWxSAO gwWxSAO;
    	
    	@Autowired
    	private WxLoginLogMapper wxLoginLogMapper;
    
    
    	public Jscode2sessionResponse wxLogin(String jsCode) throws Exception {
    		// 调用wx服务，用微信登录码换取openid
    		Jscode2sessionResponse jscode2sessionResponse = jscode2session(jsCode);
    		return jscode2sessionResponse;
    	}
    	
    		String openid = jscode2sessionResponse.getOpenid();
    		String wxErrcode = jscode2sessionResponse.getErrcode();
    		String wxErrmsg = jscode2sessionResponse.getErrmsg();
    
    		// 记录登录日志
    		WxLoginLog wxLoginLog = loginLog(request, jscode2sessionResponse);
    
    		// wx服务报错
    		if (!"0".equals(wxErrcode)) {
    			throw new GenericBizException("WX0001", new Object[] { wxErrcode, wxErrmsg });
    		}
    
    		// 未获得预期的openid
    		if (StringUtils.isEmpty(openid)) {
    			throw new GenericBizException("C01001", new Object[] { jsCode });
    		}
    		
    		CustInfo custInfo = custService.getCustInfo(openid);
    
    		// 根据openid获取对应的custNo
    		
    		IntfSession.getSession().login(user);
    
    		// TODO initAesKey(aesKey, user);
    
    		StaffLoginResponse result = new StaffLoginResponse();
    		result.setLogonId(response.getLogonId());
    		result.setLogonName(response.getLogonName());
    
    		String language = response.getLanguage();
    		if (StringUtils.isEmpty(language)) {
    			language = "zh";
    		}
    		result.setLanguage(language);
    		return result;
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
    
    	public int saveWxLoginLog(WxLoginLog record) {
    		String recordId = record.getRecordId();
    
    		if (StringUtils.isEmpty(recordId)) {
    			recordId = MyNumberGen.uuid();
    			record.setRecordId(recordId);
    		}
    
    		return wxLoginLogMapper.insert(record);
    	}
    	
    	public WxLoginLog loginLog(WxLoginRequest request, Jscode2sessionResponse jscode2sessionResponse){
    		String jsCode = request.getJsCode();
    
    		String openid = jscode2sessionResponse.getOpenid();
    		String unionid = jscode2sessionResponse.getUnionid();
    		String sessionKey = jscode2sessionResponse.getSession_key();
    		String wxErrcode = jscode2sessionResponse.getErrcode();
    		String wxErrmsg = jscode2sessionResponse.getErrmsg();
    
    
    		WxLoginLog wxLoginLog = new WxLoginLog();
    		{
    			wxLoginLog.setOpenid(openid);
    			wxLoginLog.setUnionid(unionid);
    			wxLoginLog.setSessionKey(sessionKey);
    			wxLoginLog.setJsCode(jsCode);
    			wxLoginLog.setWxErrcode(wxErrcode);
    			wxLoginLog.setWxErrmsg(wxErrmsg);
    			
    			CustInfoDTO custInfoDto = request.getCustInfo();
    			if (null != custInfoDto) {
    				String nickName = custInfoDto.getNickName();
    				String avatarUrl = custInfoDto.getAvatarUrl();
    				String gender = custInfoDto.getGender();
    				String city = custInfoDto.getCity();
    				String province = custInfoDto.getProvince();
    				String country = custInfoDto.getCountry();
    				String language = custInfoDto.getLanguage();
    			wxLoginLog.setNickName(nickName);
    			wxLoginLog.setAvatarUrl(avatarUrl);
    			wxLoginLog.setGender(gender);
    			wxLoginLog.setCity(city);
    			wxLoginLog.setProvince(province);
    			wxLoginLog.setCountry(country);
    			wxLoginLog.setLanguage(language);
    			}
    		}
    
    		saveWxLoginLog(wxLoginLog);
    		
    		return wxLoginLog;
    	}
    
    	public int addFriend() {
    		return 0;
    	}
    	*/
}
