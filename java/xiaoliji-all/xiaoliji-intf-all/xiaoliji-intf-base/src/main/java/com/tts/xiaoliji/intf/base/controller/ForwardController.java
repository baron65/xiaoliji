package com.tts.xiaoliji.intf.base.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.tts.xiaoliji.common.bean.LoginUser;
import com.tts.xiaoliji.common.dto.rap.RequestBaseDTO;
import com.tts.xiaoliji.common.dto.rap.ResponseBaseDTO;
import com.tts.xiaoliji.common.sao.CommonSAO;
import com.tts.xiaoliji.intf.base.IntfSession;

import cn.openlo.common.beanutils.BeanToMap;
import cn.openlo.common.beanutils.MapToBean;
import cn.openlo.common.util.DateUtil;
import cn.openlo.exception.DateFormatException;
import cn.openlo.exception.LOException;
import cn.openlo.gear.exception.GenericBizException;
import cn.openlo.gear.jnl.JnlNoHelper;

public abstract class ForwardController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CommonSAO      commonSAO;

    @Value("${gear.system.id}")
    private String         systemId;

    @Autowired
    private JnlNoHelper    jnlNoHelper;

    protected void forward(String serviceName, RequestBaseDTO request, ResponseBaseDTO response) throws Exception {

        // 获取登录用户的信息
        IntfSession innerSession = IntfSession.getSession();
        if (null != innerSession) {
            LoginUser user = innerSession.getUser();
            if (null != user) {
                request.setOperStaffNo(user.getCustNo());
            }
        }

        Map<String, Object> params = (Map<String, Object>) BeanToMap.toMap(request);
        preHandle(params);

        Map<String, Object> res = this.commonSAO.invoke(serviceName, params);

        MapToBean.toBean(response, res, true, "yyyyMMddHHmmss");
    }

    protected void preHandle(Map<String, Object> req) throws GenericBizException {
        Map<String, Object> newRequest = new HashMap();
        String channelDate = null;
        try {
            channelDate = DateUtil.getDateString(new Date(), "yyyyMMdd");
        }
        catch (DateFormatException e) {
            throw new GenericBizException("100000", new Object[] { e.getMessage() });
        }
        newRequest.put("channel", this.systemId);
        newRequest.put("channelDate", channelDate);
        try {
            newRequest.put("channelJnlNo", this.jnlNoHelper.generate().getStringValue());
        }
        catch (LOException e) {
            throw new GenericBizException("100000", new Object[] { e.getMessage() });
        }
        if (req == null) {
            req = new HashMap();
        }
        req.putAll(newRequest);
    }

}
