package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Component;

import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.exception.InvalidConditionException;
import com.tts.xiaoliji.intf.base.exception.InvalidInputException;
import com.tts.xiaoliji.intf.base.utils.DateTimeUtil;

import cn.openlo.exception.LOSException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("tokenControlInFilter")
public class TokenControllerInFilter extends AbstractIntfInboudFilter {
	public boolean matches(ServiceRequest request, ServiceContext serviceContext) {
		return true;
	}

	public int getOrder() {
		return 90;
	}

	public String getName() {
		return "tokenControlFilter";
	}

	public void preFilter(ServiceRequest request, ServiceContext serviceContext) throws LOSException {
		IntfSession session = IntfSession.getSession();

		String tokenKey = (String) request.getParameters().get("_token");
		if (StringUtils.isEmpty(tokenKey)) {
			throw new InvalidInputException("requestToken.check.isNull");
		}
		String tokenInServer = "";
		if (session.lock("_token")) {
			tokenInServer = (String) session.getAttribute("_token", String.class);
			session.removeAttribute("_token");
			session.unlock("_token");
		}
		if (StringUtils.isEmpty(tokenInServer)) {
			throw new InvalidConditionException("token.has.submit");
		}
		if (tokenInServer.equals(tokenKey)) {
			String lastMsgSummary = (String) session.getAttribute("token_trans_summary", String.class);
			String msgSummary = null;
			if (StringUtils.isNotEmpty(lastMsgSummary)) {
				msgSummary = (String) request.getParameters().get("shths");
				if (lastMsgSummary.equals(msgSummary)) {
					long lastTransTime = ((Long) session.getAttribute("token_trans_summary_time", Long.class))
							.longValue();
					long nowTime = DateTimeUtil.now().getTime();
					if (nowTime - lastTransTime < 1000L) {
						throw new InvalidConditionException("trans.has.submit");
					}
				}
			}
			if (StringUtils.isNotEmpty(msgSummary)) {
				IntfSession.getSession().setAttribute("token_trans_summary", msgSummary);
				IntfSession.getSession().setAttribute("token_trans_summary_time", DateTimeUtil.now().getTime());
			}
			return;
		}
		throw new InvalidConditionException("token.is.error");
	}
}
