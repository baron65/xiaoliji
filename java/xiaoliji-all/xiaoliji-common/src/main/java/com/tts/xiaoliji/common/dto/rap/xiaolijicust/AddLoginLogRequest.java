package com.tts.xiaoliji.common.dto.rap.xiaolijicust;

import com.tts.xiaoliji.common.dto.rap.common.WxLoginLogDTO;

/**
 * <p> Title: AddLoginLogRequest </p>
 * <p> Description: 记录登录日志 xiaoliji-cust.addLoginLog </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class AddLoginLogRequest extends com.tts.xiaoliji.common.dto.rap.RequestBaseDTO {

    // 用户信息#wxLoginLog#+
    private WxLoginLogDTO wxLoginLog;

    public WxLoginLogDTO getWxLoginLog() {
        return wxLoginLog;
    }

    public void setWxLoginLog(WxLoginLogDTO wxLoginLog) {
        this.wxLoginLog = wxLoginLog;
    }

}
