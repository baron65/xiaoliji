package com.tts.xiaoliji.intf.base;

public class IntfClientInfo {
    private String remoteAddr;
    private String remoteHost;
    private String requestMethod;
    private String os;
    private String broswer;
    private String channelId;
    private String clientIp;

    public String getRemoteAddr() {
        return this.remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getRemoteHost() {
        return this.remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getOs() {
        return this.os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBroswer() {
        return this.broswer;
    }

    public void setBroswer(String broswer) {
        this.broswer = broswer;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

}
