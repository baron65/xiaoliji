package com.tts.xiaoliji.common.sao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.tts.xiaoliji.common.dto.rap.RequestBaseDTO;
import com.tts.xiaoliji.common.dto.rap.ResponseBaseDTO;

import cn.openlo.common.beanutils.BeanToMap;
import cn.openlo.common.beanutils.MapToBean;
import cn.openlo.common.util.DateUtil;
import cn.openlo.common.util.LOJsonUtil;
import cn.openlo.exception.DateFormatException;
import cn.openlo.exception.LOException;
import cn.openlo.gear.exception.GenericBizException;
import cn.openlo.gear.jnl.impl.ThreadLocalJnlNoHelper;
import cn.openlo.service.FacadeServiceClient;
import cn.openlo.service.LOServiceClient;
import cn.openlo.service.ServiceResponse;

public abstract class MyBaseSAO {
    @Autowired
    private ThreadLocalJnlNoHelper jnlNoHelper;
    @Value("${gear.system.id}")
    private String systemId;
    @Value("${gear.channel.id}")
    private String channelId;
    @Autowired
    private CommonSAO commonSAO;
    
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected void forward(String serviceName, RequestBaseDTO request, ResponseBaseDTO response) throws Exception {

        Map<String, Object> params = (Map<String, Object>) BeanToMap.toMap(request);
        preHandle(params);

        Map<String, Object> res = this.commonSAO.invoke(serviceName, params);

        MapToBean.toBean(response, res, true, "yyyyMMddHHmmss");
    }
    
    protected Map<String, Object> sendRequest(LOServiceClient client, Map<String, Object> params, boolean throwResponseError)
            throws GenericBizException {
        preHandle(params);
        String calleeName = ((FacadeServiceClient) client).getCalleeName();
        this.logger.debug("[CalleeName=" + calleeName + "]入参为:" + JSON.toJSONString(params));
        ServiceResponse response = client.sendRequest(params);
        this.logger.debug("[CalleeName=" + calleeName + "]结果为:" + JSON.toJSONString(response));
        Map<String, Object> result = null;
        result = extractRealResponse(response, throwResponseError);
        return result;
    }
    
    protected void preHandle(Map<String, Object> params) throws GenericBizException {
        if (params.get("channel") == null) {
            params.put("channel", this.channelId);
        }
        if (params.get("channelDate") == null) {
            try {
                params.put("channelDate", DateUtil.printCompactDate(new Date()));
            }
            catch (DateFormatException e1) {
                throw new GenericBizException("100000", "日期格式化异常");
            }
        }
        if (params.get("channelJnlNo") == null) {
            try {
                params.put("channelJnlNo", this.jnlNoHelper.generate().getStringValue());
            }
            catch (LOException e) {
                throw new GenericBizException("100000", "流水号生成异常");
            }
        }
        params.put("sourceSystemId", this.systemId);
    }

    @SuppressWarnings("unchecked")
    protected Map<String, Object> extractRealResponse(ServiceResponse response, boolean throwResponseError) throws GenericBizException {
        if (response == null) {
            throw new GenericBizException("service.res.isnull");
        }
        this.logger.warn("Request send to {} failed, response code is {}, responseMsg is {}",
            new Object[] { getSysPre(), response.getResponseCode(), response.getResponseMsg() });

        if (!"000000".equals(response.getResponseCode()) && throwResponseError) {
            throw new GenericBizException(response.getResponseCode(), response.getResponseMsg());
        }

        Map<String, Object> result = new HashMap<String, Object>();
        Object model = response.getModel();
        if (model != null) {
            try {
                result = (Map<String, Object>) BeanToMap.toMap(model);
            }
            catch (Exception e) {
                this.logger.error(e.getMessage(), e);
                this.logger.error("Failed to transfer model to map, the model is {}", LOJsonUtil.objectToJsonString(model));
                throw new RuntimeException(getSysPre() + "|" + "err.response");
            }
        }
        return result;
    }

    protected abstract String getSysPre();
}
