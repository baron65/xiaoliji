package com.tts.xiaoliji.intf.base.serviceFilters.inbound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import cn.openlo.gear.log.ExceptionIgnoreFilter;
import cn.openlo.gear.log.LoggingOutboundServiceFilter;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

/**
 * <p>
 * Title: InnerLoggingOutboundServiceFilter
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: openlo.cn Copyright (C) 2017
 * </p>
 *
 * @author yangshiyin
 * @version
 * @since 2017年6月5日
 */
@Component("intfLoggingOutboundServiceFilter")
public class IntfLoggingOutboundServiceFilter extends LoggingOutboundServiceFilter {
    private final Logger log;

    public IntfLoggingOutboundServiceFilter() {
        this.log = LoggerFactory.getLogger(IntfLoggingOutboundServiceFilter.class);
    }

    public void doFilter(ServiceRequest request, ServiceResponse response, ServiceContext context) {
        try {
            String msg = JSON.toJSONString(response, new ExceptionIgnoreFilter(), new SerializerFeature[0]);
            if (msg.length() > 1024) {
                msg = msg.substring(0, 1024) + " ......";
            }
            this.log.info("Invoked<{}>:{}", request.getServiceName(), msg);
        }
        catch (Exception ex) {
            this.log.error("log error", ex);
        }
    }

    public String toString() {
        return "IntfLoggingOutboundServiceFilter [getOrder()=" + getOrder() + "]";
    }
}
