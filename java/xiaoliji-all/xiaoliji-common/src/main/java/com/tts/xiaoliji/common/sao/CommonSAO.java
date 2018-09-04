package com.tts.xiaoliji.common.sao;

import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import cn.openlo.gear.exception.GenericBizException;
import cn.openlo.protocol.Protocol;
import cn.openlo.service.CallType;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component
public class CommonSAO {
    @Autowired
    private LosCommonClient losCommonClient;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Map invoke(String serviceName, Map req) throws GenericBizException {
        ServiceRequest request = new ServiceRequest();
        request.setServiceName(serviceName);
        request.setParameters(req);
        try {
            this.logger.info("invoke start : " + request.getServiceName() + " params is :" + JSON.toJSONString(request));
            Object protocol = request.getParameters().get("protocol");
            protocol = protocol == null ? Protocol.DUBBO : protocol;
            Properties serviceConfig = new Properties();
            serviceConfig.put("protocol", protocol);
            Object asyncFlag = request.getParameters().get("callType");
            if ((asyncFlag != null) && (CallType.async.toString().equals(asyncFlag))) {
                serviceConfig.setProperty("callType", CallType.async.toString());
                this.losCommonClient.asyncSendRequest(request, serviceConfig);
                return null;
            }
            if ((asyncFlag != null) && (CallType.oneway.toString().equals(asyncFlag))) {
                serviceConfig.setProperty("callType", CallType.oneway.toString());
                this.losCommonClient.onewaySendRequest(request, serviceConfig);
                return null;
            }
            ServiceResponse response = this.losCommonClient.sendRequest(request);
            this.logger.info("invoke end : " + request.getServiceName() + " params is :" + JSON.toJSONString(response));
            if (!"000000".equals(response.getResponseCode())) {
                GenericBizException e = new GenericBizException(response.getResponseCode());
                e.setErrorMessage(response.getResponseMsg());
                throw e;
            }
            return (Map) response.getModel();
        }
        catch (Exception e) {
            if ((e instanceof GenericBizException)) {
                throw e;
            }
            this.logger.error("invoke service [" + request.getServiceName() + "]fail:" + e.getMessage(), e);
            throw new GenericBizException("900101");
        }
    }

    public ServiceResponse invoke(ServiceRequest request) throws GenericBizException {
        try {
            this.logger.info("invoke start : " + request.getServiceName() + "params is :" + JSON.toJSONString(request));
            Object protocol = request.getParameters().get("protocol");
            protocol = protocol == null ? Protocol.DUBBO : protocol;
            Properties serviceConfig = new Properties();
            serviceConfig.put("protocol", protocol);
            Object asyncFlag = request.getParameters().get("callType");
            if ((asyncFlag != null) && (CallType.async.toString().equals(asyncFlag))) {
                serviceConfig.setProperty("callType", CallType.async.toString());
                this.losCommonClient.asyncSendRequest(request, serviceConfig);
                return null;
            }
            if ((asyncFlag != null) && (CallType.oneway.toString().equals(asyncFlag))) {
                serviceConfig.setProperty("callType", CallType.oneway.toString());
                this.losCommonClient.onewaySendRequest(request, serviceConfig);
                return null;
            }
            ServiceResponse response = this.losCommonClient.sendRequest(request);
            this.logger.info("invoke end : " + request.getServiceName() + "params is :" + JSON.toJSONString(response));
            if (!"000000".equals(response.getResponseCode())) {
                GenericBizException e = new GenericBizException(response.getResponseCode());
                e.setErrorMessage(response.getResponseMsg());
                throw e;
            }
            return response;
        }
        catch (Exception e) {
            if ((e instanceof GenericBizException)) {
                throw e;
            }
            this.logger.error("invoke service [" + request.getServiceName() + "]fail:" + e.getMessage(), e);
            throw new GenericBizException("900101");
        }
    }

    public LosCommonClient getLosCommonClient() {
        return this.losCommonClient;
    }

    public void setLosCommonClient(LosCommonClient losCommonClient) {
        this.losCommonClient = losCommonClient;
    }
}
