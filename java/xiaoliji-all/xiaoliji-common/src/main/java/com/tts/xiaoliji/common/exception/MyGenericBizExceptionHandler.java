package com.tts.xiaoliji.common.exception;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.tts.xiaoliji.common.utils.LocalDataHelper;

import cn.openlo.exception.JumpException;
import cn.openlo.gear.exception.GenericBizException;
import cn.openlo.gear.exception.GenericRuntimeException;
import cn.openlo.gear.exception.GenericUnknowException;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceExceptionHandler;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

public class MyGenericBizExceptionHandler implements ServiceExceptionHandler {
    private static final String EMPTY_STRING = "unknow error";
    private static Locale localeEN = Locale.ENGLISH;
    private static Locale localeZH = Locale.CHINESE;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "_gear_message_source")
    private MessageSource gearMessageSource;

    @Autowired
    private LocalDataHelper localDataHelper;

    private boolean setFailCause = false;
    private boolean clearFailCause = true;

    public int getOrder() {
        return Integer.MIN_VALUE;
    }

    public void handleException(ServiceRequest request, ServiceResponse serviceResponse, ServiceContext serviceContext, Exception exception)
            throws JumpException {
        if ((exception instanceof GenericRuntimeException)) {
            exception = ((GenericRuntimeException) exception).unwrapException();
        }

        if ((exception instanceof GenericBizException)) {
            GenericBizException gbe = (GenericBizException) exception;
            String message = parseMessage(gbe);
            serviceResponse.setResponseCode(gbe.getErrorCode());
            serviceResponse.setResponseMsg(message);
            logger.error("Service<{}> throws GenericBizException, code = {}, message = {}",
                new Object[] { request.getServiceName(), gbe.getErrorCode(), message, exception });

            if (clearFailCause) {
                serviceResponse.setFailCause(null);
            }
            else if ((serviceResponse.getFailCause() == null) || (setFailCause)) {
                serviceResponse.setFailCause(gbe);
            }
            if (gbe.getModel() != null) {
                serviceResponse.setModel(gbe.getModel());
            }
        }
        else if ((exception instanceof GenericUnknowException)) {
            GenericUnknowException gue = (GenericUnknowException) exception;
            serviceResponse.setResponseCode(gue.getErrorCode());
            serviceResponse.setResponseMsg(gue.getErrorMsg());
            logger.error("Service<{}> throws GenericUnknowException, code = {}, message = {}",
                new Object[] { request.getServiceName(), gue.getErrorCode(), gue.getErrorMsg(), exception });

            if (clearFailCause) {
                serviceResponse.setFailCause(null);
            }
            else if ((serviceResponse.getFailCause() == null) || (setFailCause)) {
                serviceResponse.setFailCause(gue);
            }
        }
        else {
            logger.error("Service<{}> throws Exception, message = {}",
                new Object[] { request.getServiceName(), exception.getMessage(), exception });
        }
    }

    public String resolveMessage(Exception exception) {
        if ((exception instanceof GenericUnknowException)) {
            return ((GenericUnknowException) exception).getErrorMsg();
        }
        if ((exception instanceof GenericRuntimeException)) {
            return parseMessage(((GenericRuntimeException) exception).unwrapException());
        }
        if ((exception instanceof GenericBizException)) {
            return parseMessage((GenericBizException) exception);
        }

        return exception.getMessage();
    }

    private String parseMessage(GenericBizException gbe) {
        if (gbe.isErrorMessageSet()) {
            return gbe.getErrorMessage();
        }

        String message = null;
        try {
            if (gearMessageSource != null) {
                Locale locale = getLocale();
                message = gearMessageSource.getMessage(gbe.getErrorCode(), gbe.getArgs(), locale);
            }
        }
        catch (Exception innerExcetion) {
            message = EMPTY_STRING;
        }
        return message;
    }

    public void setSetFailCause(boolean setFailCause) {
        this.setFailCause = setFailCause;
    }

    public void setClearFailCause(boolean clearFailCause) {
        this.clearFailCause = clearFailCause;
    }

    public Locale getLocale() {
        String language = localDataHelper.getLanguage();

        if ("en".equalsIgnoreCase(language)) {
            return localeEN;
        }
        else if ("zh".equalsIgnoreCase(language)) {
            return localeZH;
        }
        else {
            return localeZH;
        }
    }
}
