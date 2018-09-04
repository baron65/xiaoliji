package com.tts.xiaoliji.intf.base.serviceFilters.outbound;

import java.util.Date;
import java.util.HashMap;
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
import com.tts.xiaoliji.intf.base.mongo.dao.IntfLogMongoDAOImpl;

import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("intfLogOutboundFilter")
public class IntfLogOutboundFilter extends AbstractIntfOutboundFilter {
	private IntfCommonLogDAO intfCommonLogDAO;
	@Autowired
	private List<IntfCommonLogDAO> logDaoList;
	private Logger logger = LoggerFactory.getLogger(getClass());

	public int getOrder() {
		return 40;
	}

	public String getName() {
		return "intfLogFilter";
	}

	public void afterFilter(ServiceRequest paramServiceRequest, ServiceResponse paramServiceResponse,
			ServiceContext paramServiceContext) {
		String userNo = IntfSession.getSession().getUserId();
		if (!StringUtils.hasText(userNo)) {
			return;
		}
		String channelJnlNo = (String) paramServiceContext.getData("channelJnlNo");
		Date endTime = new Date();
		Date startTime = (Date) paramServiceContext.getData("startTime");
		String serverId = paramServiceRequest.getServiceName();
		if (channelJnlNo == null) {
			this.logger.debug("----------------+WARN+-------------shouldn't go here!!  channelJnlNo is NULL !!!!");
			return;
		}
		Map<String, Object> updateArgs = new HashMap<String,Object>();
		updateArgs.put("responseCode", paramServiceResponse.getResponseCode());
		if (StringUtils.hasText(paramServiceResponse.getResponseMsg())) {
			updateArgs.put("responseMsg", paramServiceResponse.getResponseMsg());
		}
		updateArgs.put("time", Long.valueOf(endTime.getTime() - startTime.getTime()));
		updateArgs.put("endTime", endTime);
		if (!this.intfCommonLogDAO.updateOnlyOne(channelJnlNo, serverId, updateArgs)) {
			this.logger.error("insert log error, the channelJnlNo is " + channelJnlNo);
		}
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
