package com.tts.xiaoliji.common.dto.rap;

import cn.openlo.gear.dataobject.BaseVOSupport;

/**
 * Title: RequestBaseDTO
 * <p>
 * Description: 服务响应参数的基类
 * <p>
 * Copyright: openlo.cn Copyright (C) 2016
 * 
 * @since 2016年10月2日
 */
public class ResponseBaseDTO extends BaseVOSupport {
    private String responseCode = "000000";
    private String responseMsg = "Successful";

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

}
