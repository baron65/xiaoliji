package com.tts.xiaoliji.intf.base.serviceFilters.outbound;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.dao.IntfLoginLogDAO;
import com.tts.xiaoliji.intf.base.dto.IntfLoginLogDTO;
import com.tts.xiaoliji.intf.base.mongo.dao.IntfLoginLogMongoDAOImpl;

import cn.openlo.common.util.DateUtil;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("intfLoginLogOutboundFilter")
public class IntfLoginLogOutboundFilter extends AbstractIntfOutboundFilter {
	private IntfLoginLogDAO intfLoginDAO;
	@Autowired
	private List<IntfLoginLogDAO> logDaoList;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public int getOrder() {
		return 140;
	}

	public String getName() {
		return "intfLoginLogFilter";
	}

	public boolean matches(ServiceRequest request, ServiceContext serviceContext) {
		return true;
	}

	@SuppressWarnings("unchecked")
	public void afterFilter(ServiceRequest paramServiceRequest, ServiceResponse paramServiceResponse,
			ServiceContext paramServiceContext) {
		IntfLoginLogDTO loginDTO = new IntfLoginLogDTO();

		String userNo = IntfSession.getSession().getUserId();
		String channelJnlNo = (String) paramServiceContext.getData("channelJnlNo");
		Date now = DateUtil.now();
		String serverName = paramServiceRequest.getServiceName();
		String responseCode = paramServiceResponse.getResponseCode();
		String responseMsg = paramServiceResponse.getResponseMsg();

		loginDTO.setUserId(userNo);
		loginDTO.setServiceName(serverName);
		loginDTO.setChannelJnlNo(channelJnlNo);
		loginDTO.setLoginDate(now);
		loginDTO.setResponseCode(responseCode);
		loginDTO.setSessionId(IntfSession.getSession().getId());
		if (StringUtils.hasText(responseMsg)) {
			loginDTO.setResponseMsg(responseMsg);
		}
		Map<String, Object> parameterMap = (Map<String, Object>) paramServiceRequest.getParameters();
		String loginName = (String) parameterMap.get("userName");
		if (StringUtils.isEmpty(loginName)) {
			loginName = (String) parameterMap.get("loginTicket");
		}
		if (StringUtils.isEmpty(loginName)) {
			loginName = (String) parameterMap.get("token");
		}
		if ((StringUtils.isEmpty(loginDTO)) && (StringUtils.hasText(userNo))) {
			loginName = userNo;
		}
		if (parameterMap.containsKey("loginPwd")) {
			parameterMap.remove("loginPwd");
		}
		if (parameterMap.containsKey("reqData")) {
			parameterMap.remove("reqData");
		}
		if (parameterMap.containsKey("encKey")) {
			parameterMap.remove("encKey");
		}
		if (parameterMap.containsKey("password")) {
			parameterMap.remove("password");
		}
		loginDTO.setLoginName(loginName);
		loginDTO.setRequest(paramServiceRequest.getParameters());
		loginDTO.setResponse(paramServiceResponse.getModel());
		this.intfLoginDAO.insert(loginDTO);
	}

	@PostConstruct
	public void initialize() {
		if ((this.intfLoginDAO == null) && (this.logDaoList.size() != 0)) {
			for (IntfLoginLogDAO dao : this.logDaoList) {
				if ((dao instanceof IntfLoginLogMongoDAOImpl)) {
					this.intfLoginDAO = dao;
					this.logger.info("Found mongo login dao.");
					break;
				}
			}
			if (this.intfLoginDAO == null) {
				this.intfLoginDAO = ((IntfLoginLogDAO) this.logDaoList.get(0));
			}
		}
	}
}
