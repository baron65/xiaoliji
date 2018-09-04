package com.tts.xiaoliji.common.filter;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.tts.xiaoliji.common.utils.LocalDataHelper;

import cn.openlo.service.OutboundServiceFilter;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component("localDataOutboundServiceFilter")
public class LocalDataOutboundServiceFilter implements OutboundServiceFilter {
    private List<String> excludeLOS;
    private LocalDataHelper localDataHelper;

    public void setExcludeLOS(List<String> excludeLOS) {
        this.excludeLOS = excludeLOS;
    }

    public void setLocalDataHelper(LocalDataHelper localDataHelper) {
        this.localDataHelper = localDataHelper;
    }

    public boolean matches(ServiceRequest request, ServiceContext serviceContext) {
        if ((!CollectionUtils.isEmpty(excludeLOS)) && (excludeLOS.contains(request.getServiceName()))) {
            return false;
        }
        return true;
    }

    public int getOrder() {
        return -2147483646;
    }

    public void doFilter(ServiceRequest request, ServiceResponse serviceResponse, ServiceContext serviceContext) {
        localDataHelper.remove();
    }

    public String toString() {
        return "JnlNoOutboundServiceFilter [excludeLOS=" + excludeLOS + ", getOrder()=" + getOrder() + "]";
    }
}