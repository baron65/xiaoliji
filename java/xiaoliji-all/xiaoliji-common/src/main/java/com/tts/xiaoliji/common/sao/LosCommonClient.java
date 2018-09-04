package com.tts.xiaoliji.common.sao;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import cn.openlo.protocol.Protocol;
import cn.openlo.protocol.ProtocolClientRegistry;
import cn.openlo.service.CallType;
import cn.openlo.service.ServiceClient;
import cn.openlo.service.ServiceRequest;
import cn.openlo.service.ServiceResponse;

@Component
public class LosCommonClient
{
  @Value("${gear.name}")
  private String gearName;
  
  public ServiceResponse sendRequest(ServiceRequest request)
  {
    if (null == request) {
      throw new NullPointerException("request");
    }
    ServiceClient serviceClient = ProtocolClientRegistry.get(Protocol.DUBBO);
    Properties serviceConfig = new Properties();
    setCommonProperties(request, serviceConfig);
    return serviceClient.sendRequest(this.gearName, serviceConfig, request);
  }
  
  public ServiceResponse sendRequest(ServiceRequest request, Properties serviceConfig)
  {
    if (null == request) {
      throw new NullPointerException("request");
    }
    if (null == serviceConfig) {
      throw new NullPointerException("serviceConfig");
    }
    setCommonProperties(request, serviceConfig);
    
    Protocol protocol = (Protocol)serviceConfig.get("protocol");
    
    ServiceClient serviceClient = ProtocolClientRegistry.get(protocol);
    ServiceResponse response = serviceClient.sendRequest(this.gearName, serviceConfig, request);
    return response;
  }
  
  public void asyncSendRequest(ServiceRequest request, Properties serviceConfig)
  {
    if (null == request) {
      throw new NullPointerException("request");
    }
    if (null == serviceConfig) {
      throw new NullPointerException("serviceConfig");
    }
    setCommonProperties(request, serviceConfig);
    serviceConfig.put("callType", CallType.async);
    Protocol protocol = (Protocol)serviceConfig.get("protocol");
    if (null == protocol) {
      protocol = Protocol.DUBBO;
    }
    ServiceClient serviceClient = ProtocolClientRegistry.get(protocol);
    serviceClient.sendRequest(this.gearName, serviceConfig, request);
  }
  
  public void onewaySendRequest(ServiceRequest request, Properties serviceConfig)
  {
    if (null == request) {
      throw new NullPointerException("request");
    }
    if (null == serviceConfig) {
      throw new NullPointerException("serviceConfig");
    }
    serviceConfig.put("callType", CallType.oneway);
    setCommonProperties(request, serviceConfig);
    Protocol protocol = (Protocol)serviceConfig.get("protocol");
    if (null == protocol) {
      protocol = Protocol.DUBBO;
    }
    ServiceClient serviceClient = ProtocolClientRegistry.get(protocol);
    serviceClient.sendRequest(this.gearName, serviceConfig, request);
  }
  
  private void setCommonProperties(ServiceRequest request, Properties serviceConfig)
  {
    Protocol protocol = (Protocol)serviceConfig.get("protocol");
    if (null == protocol) {
      protocol = Protocol.DUBBO;
    }
    serviceConfig.put("calleename", request.getServiceName());
    serviceConfig.put("protocol", protocol);
    serviceConfig.put("callername", this.gearName);
    serviceConfig.put("clientname", getLOSClientName(this.gearName, request.getServiceName()));
  }
  
  private Object getLOSClientName(String callerName, String svcName)
  {
    return callerName + "_" + "CLIENT";
  }
}
