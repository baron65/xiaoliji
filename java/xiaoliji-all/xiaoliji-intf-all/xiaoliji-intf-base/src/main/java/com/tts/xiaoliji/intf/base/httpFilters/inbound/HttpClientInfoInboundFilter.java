package com.tts.xiaoliji.intf.base.httpFilters.inbound;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.openlo.exception.LOSException;
import cn.openlo.service.HttpInboundServiceFilter;
import cn.openlo.service.ServiceContext;

@Component("httpClientInfoInboundFilter")
public class HttpClientInfoInboundFilter implements HttpInboundServiceFilter {
    public int getOrder() {
        return 30;
    }

    public void doFilter(HttpServletRequest paramHttpServletRequest, ServiceContext paramServiceContext) throws LOSException {
        Map<String, String> clientInfo = getClientInfo(paramHttpServletRequest);
        paramServiceContext.setData("_request_client_info", clientInfo);
    }

    private String getOS(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent == null) {
            return "unknown";
        }
        String accessOS;
        if (userAgent.indexOf("Windows") != -1) {
            accessOS = "Windows";
        }
        else {
            if (userAgent.indexOf("Mac") != -1) {
                accessOS = "Mac";
            }
            else {
                if (userAgent.indexOf("Linux") != -1) {
                    if (userAgent.indexOf("Android") != -1) {
                        accessOS = "Android";
                    }
                    else {
                        accessOS = "Linux";
                    }
                }
                else {
                    if (userAgent.indexOf("iPhone") != -1) {
                        accessOS = "iPhone";
                    }
                    else {
                        accessOS = "unknown";
                    }
                }
            }
        }
        return accessOS;
    }

    private String getBrower(HttpServletRequest request) {

        String userAgent = request.getHeader("User-Agent");
        if (userAgent == null) {
            return "unknown ";
        }
        String accessBrower;
        String version;
        if (userAgent.indexOf("MSIE") != -1) {
            accessBrower = "IE";
            version = userAgent.substring(userAgent.indexOf("MSIE") + 5);
            version = version.substring(0, version.indexOf(";"));
        }
        else if (userAgent.indexOf("Firefox") != -1) {
            accessBrower = "Firefox";
            version = userAgent.substring(userAgent.indexOf("Firefox") + 8);
            version = version.substring(0, version.indexOf(" ") == -1 ? version.length() : version.indexOf(" "));
        }
        else if (userAgent.indexOf("Chrome") != -1) {
            accessBrower = "Chrome";
            version = userAgent.substring(userAgent.indexOf("Chrome") + 7);
            version = version.substring(0, version.indexOf(" ") == -1 ? version.length() : version.indexOf(" "));
        }
        else if (userAgent.indexOf("Mobile") != -1) {
            accessBrower = "Safari";
            version = userAgent.substring(userAgent.indexOf("Safari") + 7);
            version = version.substring(0, version.indexOf(" ") == -1 ? version.length() : version.indexOf(" "));
        }
        else {
            accessBrower = "unknown";
            version = "";
        }
        return accessBrower + " " + version;
    }

    private Map<String, String> getClientInfo(HttpServletRequest request) {
        String remoteAddr = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(remoteAddr)) {
            remoteAddr = request.getRemoteAddr();
        }
        String remoteHost = request.getRemoteHost();
        String requestMethod = request.getMethod();
        String os = getOS(request);
        String brower = getBrower(request);
        String ip = request.getHeader("X-Real-IP");
        Map<String, String> clientInfo = new HashMap<String, String>();
        clientInfo.put("remoteAddr", remoteAddr);
        clientInfo.put("remoteHost", remoteHost);
        clientInfo.put("requestMethod", requestMethod);
        clientInfo.put("os", os);
        clientInfo.put("broswer", brower);
        clientInfo.put("clientIp", ip);

        return clientInfo;
    }
}
