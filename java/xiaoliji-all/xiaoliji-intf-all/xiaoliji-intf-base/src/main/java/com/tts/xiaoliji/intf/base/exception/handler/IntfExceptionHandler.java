package com.tts.xiaoliji.intf.base.exception.handler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.intf.base.exception.IntfRuntimeException;

import cn.openlo.box.BoxFactory;
import cn.openlo.common.util.LOJsonUtil;
import cn.openlo.exception.JumpException;
import cn.openlo.exception.LOSException;
import cn.openlo.exception.ValidateFailException;
import cn.openlo.gear.cache.Cache;
import cn.openlo.gear.exception.GenericBizException;
import cn.openlo.gear.exception.GenericBizExceptionHandler;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

public class IntfExceptionHandler extends GenericBizExceptionHandler {
//	private static final String EMPTY_STRING = "";
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource(name = "_intf_gear_message_source")
	private MessageSource gearMessageSource;
	private Locale defaultLocale = Locale.SIMPLIFIED_CHINESE;
	@Autowired
	@Qualifier("gearCache")
	private Cache cacheService;

	@SuppressWarnings("unchecked")
	public void handleException(ServiceRequest request, ServiceResponse serviceResponse, ServiceContext serviceContext,
			Exception exception) throws JumpException {
		serviceResponse.setFailCause(null);
		this.logger.error(exception.getMessage(), exception);
		if ((exception instanceof LOSException)) {
			String errCode = "";
			String message = "";
			if ((exception instanceof GenericBizException)) {
				GenericBizException e = (GenericBizException) exception;
				errCode = e.getErrorCode();
				if (e.isErrorMessageSet()) {
					message = e.getErrorMessage();
				} else {
					message = getErrMsg(e.getErrorCode(), e.getArgs(), request.getLocale());
				}
			} else if ((exception instanceof ValidateFailException)) {
				ValidateFailException validateExp = (ValidateFailException) exception;
				String detailMsg = validateExp.getMessage();
				if (StringUtils.hasText(detailMsg)) {
					List<Map<String, Object>> errMsgList = (List<Map<String, Object>>) LOJsonUtil.jsonStringToObject(detailMsg, List.class);
					if (!CollectionUtils.isEmpty(errMsgList)) {
						String field = (String) ((Map<String, Object>) errMsgList.get(0)).get("field");
						errCode = (String) ((Map<String, Object>) errMsgList.get(0)).get("message");
						message = getErrMsg(errCode, new Object[] { field }, request.getLocale());
					}
					if ((StringUtils.isEmpty(message)) && (!StringUtils.isEmpty(errCode))) {
						message = errCode;
					}
				}
			}
			serviceResponse.setResponseCode(errCode);
			serviceResponse.setResponseMsg(message);
		}
		IntfRuntimeException e = null;
		if ((exception.getCause() instanceof IntfRuntimeException)) {
			e = (IntfRuntimeException) exception.getCause();
		}
		if ((exception instanceof IntfRuntimeException)) {
			e = (IntfRuntimeException) exception;
		}
		if (e != null) {
			this.logger.debug("error messageSet is : " + e.isErrorMessageSet());
			String message;
			if (e.isErrorMessageSet()) {
				message = e.getErrorMessage();
			} else {
				try {
					message = this.gearMessageSource.getMessage(e.getErrorCode(), e.getArgs(), request.getLocale());
					this.logger.debug("error message resolve is : " + message);
					e.setErrorMessage(message);
				} catch (Exception e1) {
					this.logger.error("GearMessageSource getMessage failed!", e1);
					try {
						message = this.gearMessageSource.getMessage(e.getErrorCode(), e.getArgs(), this.defaultLocale);
					} catch (Exception e2) {
						this.logger.error("GearMessageSource getMessage default failed!", e2);
						message = "";
					}
				}
			}
			if (isDevelopEnv()) {
				message = e.getErrorCode() + "|" + BoxFactory.getBox().getName() + "-" + message;
			}
			serviceResponse.setResponseCode(e.getErrorCode());
			serviceResponse.setResponseMsg(message);
		}
	}

	private boolean isDevelopEnv() {
		boolean result = false;
		String envir = (String) this.cacheService.get("environmentInfo", String.class);
		if (("develop".equalsIgnoreCase(envir)) || ("test".equalsIgnoreCase(envir))) {
			result = true;
		}
		return result;
	}

	private String getErrMsg(String errCode, Object[] args, Locale locale) {
		String message = "";
		try {
			message = this.gearMessageSource.getMessage(errCode, args, locale);
		} catch (Exception e1) {
			this.logger.error("GearMessageSource getMessage failed!", e1);
			try {
				message = this.gearMessageSource.getMessage(errCode, args, this.defaultLocale);
			} catch (Exception e2) {
				this.logger.error("GearMessageSource getMessage default failed!", e2);
				message = "";
			}
		}
		return message;
	}
}
