package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import java.math.BigDecimal;
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
import com.tts.xiaoliji.intf.base.dao.IntfCommonLogDAO;
import com.tts.xiaoliji.intf.base.dto.IntfCommonLogDTO;
import com.tts.xiaoliji.intf.base.mongo.dao.IntfLogMongoDAOImpl;

import cn.openlo.box.BoxFactory;
import cn.openlo.exception.LOException;
import cn.openlo.exception.LOSException;
import cn.openlo.gear.jnl.JnlNoHelper;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("intfLogInboundFilter")
public class IntfLogInboundFilter extends AbstractIntfInboudFilter {
	@Autowired
	private JnlNoHelper jnlNoHelper;
	private IntfCommonLogDAO intfCommonLogDAO;
	private boolean recordLog = true;
	@Autowired
	private List<IntfCommonLogDAO> logDaoList;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public int getOrder() {
		return 40;
	}

	public String getName() {
		return "intfLogFilter";
	}

	public boolean matches(ServiceRequest paramServiceRequest, ServiceContext paramServiceContext) {
		return this.recordLog;
	}

	public void preFilter(ServiceRequest paramServiceRequest, ServiceContext paramServiceContext) throws LOSException {
		String channelJnlNo = null;

		try {
			channelJnlNo = this.jnlNoHelper.generate().getStringValue();
		} catch (LOException e) {
			this.logger.debug("----------------+WARN+-------------shouldn't go here!!  channelJnlNo is NULL !!!!");
			return;
		}
		Date startTime = new Date();
		paramServiceContext.setData("startTime", startTime);
		paramServiceContext.setData("channelJnlNo", channelJnlNo);

		String userNo = IntfSession.getSession().getUserId();
		if (!StringUtils.hasText(userNo)) {
			return;
		}
		IntfCommonLogDTO intfCommonLogDTO = new IntfCommonLogDTO();
		intfCommonLogDTO.setChannelJnlNo(channelJnlNo);

		intfCommonLogDTO.setUserNo(userNo);
		intfCommonLogDTO.setDeviceId((String) paramServiceRequest.getParameters().get("_deviceId"));
		intfCommonLogDTO.setChannelDate((String) paramServiceRequest.getParameters().get("channelDate"));
		intfCommonLogDTO.setAcNo((String) paramServiceRequest.getParameters().get("acNo"));
		intfCommonLogDTO.setTicketId(IntfSession.getSession().getId());
		intfCommonLogDTO.setTransAmount((BigDecimal) paramServiceRequest.getParameters().get("transAmount"));
		intfCommonLogDTO.setStartTime(startTime);
		intfCommonLogDTO.setRequestId((String) paramServiceRequest.getParameters().get("requestId"));
		intfCommonLogDTO.setServerId(paramServiceRequest.getServiceName());
		intfCommonLogDTO.setChannelId((String) paramServiceRequest.getParameters().get("_channel_id"));
		intfCommonLogDTO.setProdNo((String) paramServiceRequest.getParameters().get("prodNo"));
		intfCommonLogDTO.setExtendData1((String) paramServiceRequest.getParameters().get("extendData1"));
		intfCommonLogDTO.setExtendData2((String) paramServiceRequest.getParameters().get("extendData2"));
		intfCommonLogDTO.setClientVer((String) paramServiceRequest.getParameters().get("_client_version_no"));
		intfCommonLogDTO.setInstanceId(BoxFactory.getBox().getName());

		Map<String, String> clientInfo = (Map) paramServiceRequest.getParameters().get("_request_client_info");
		if (clientInfo != null) {
			intfCommonLogDTO.setClientIp((String) clientInfo.get("remoteAddr"));
			intfCommonLogDTO.setClientOs((String) clientInfo.get("os"));
			intfCommonLogDTO.setClientBrowserVersion((String) clientInfo.get("broswer"));
			intfCommonLogDTO.setRemoteHost((String) clientInfo.get("remoteHost"));
			intfCommonLogDTO.setHttpMethod((String) clientInfo.get("requestMethod"));
		}
		this.intfCommonLogDAO.insert(intfCommonLogDTO);
	}

	@PostConstruct
	public void initialize() {
		if ((this.intfCommonLogDAO == null) && (this.logDaoList.size() != 0)) {
			for (IntfCommonLogDAO dao : this.logDaoList) {
				if ((dao instanceof IntfLogMongoDAOImpl)) {
					this.intfCommonLogDAO = dao;
					break;
				}
			}
			if (this.intfCommonLogDAO == null) {
				this.intfCommonLogDAO = ((IntfCommonLogDAO) this.logDaoList.get(0));
			}
		}
	}
}
