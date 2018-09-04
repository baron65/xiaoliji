package com.tts.xiaoliji.common.filter;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.tts.xiaoliji.common.utils.LocalDataHelper;

import cn.openlo.exception.LOSException;
import cn.openlo.service.InboundServiceFilter;
import cn.openlo.service.ServiceContext;
import cn.openlo.service.ServiceRequest;

@Component("localDataInboundServiceFilter")
public class LocalDataInboundServiceFilter implements InboundServiceFilter {
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

    public void doFilter(ServiceRequest request, ServiceContext serviceContext) throws LOSException {
        localDataHelper.setCompanyCode((String) request.getParameters().get("companyCode"));
        localDataHelper.setLanguage((String) request.getParameters().get("language"));
    }

    public String toString() {
        return "JnlNoInboundServiceFilter [excludeLOS=" + excludeLOS + ", getOrder()=" + getOrder() + "]";
    }
}