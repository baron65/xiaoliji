package com.tts.xiaoliji.intf.base.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.tts.xiaoliji.common.bean.LoginUser;
import com.tts.xiaoliji.intf.base.IntfBaseRequest;
import com.tts.xiaoliji.intf.base.IntfSession;
import com.tts.xiaoliji.intf.base.IntfSessionManager;

import cn.openlo.common.beanutils.BeanToMap;
import cn.openlo.common.util.LOJsonUtil;
import cn.openlo.service.ServiceResponse;

public class JunitUtils {

    private static final Logger logger = LoggerFactory.getLogger("IntfJunit");

    public static Map<String, Object> generateIntfCommonParams(IntfSession session, boolean encrypt) {
        Map<String, Object> commonParams = generateCommonParams();
        return generateIntfParams(commonParams, session, encrypt);
    }

    @SuppressWarnings("unchecked")
    public static <T> Map<String, Object> generateIntfParams(T origBean, IntfSession session, boolean encrypt) {
        try {
            Map<String, Object> businessParams = (Map<String, Object>) BeanToMap.toMap(origBean);
            Map<String, Object> params = generateCommonParams();
            params.putAll(businessParams);
            if (encrypt) {
                params = generateEncParams(params, session);
            }
            if (session != null) {
                params.put("UFO-SESSION-ID", session.getId());
            }
            return params;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static void validResponse(ServiceResponse response, IntfSession session, String responseCode) {
        try {
            String encKey = "";
            if (session != null) {
                if (session.isLogin()) {
                    encKey = (String) session.getAttribute("_sessionAESKey_", String.class);
                }
                else {
                    encKey = (String) session.getAttribute("_sessionAESKey_", String.class);
                }
            }
            logger.info("response is {}", LOJsonUtil.objectToJsonString(response));
            String actResponseCode = response.getResponseCode();
            Assert.assertTrue(responseCode.equals(actResponseCode));

            Map<String, Object> model = (Map<String, Object>) response.getModel();
            if (model != null) {
                String enData = (String) model.get("_enData_");
                if (StringUtils.hasText(enData)) {
                    String decryptString = AESUtil.decrypt(enData, encKey);
                    logger.info("descryptData is {}", decryptString);
                }
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void validResponse(ServiceResponse response, IntfSession session) {
        validResponse(response, session, "000000");
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> generateEncParams(Map<String, Object> origParam, IntfSession session) {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.putAll(origParam);
            String aesKey = "";
            if (session.isLogin()) {
                aesKey = (String) session.getAttribute("_sessionAESKey_", String.class);
                if (StringUtils.isEmpty(aesKey)) {
                    aesKey = TokenUtil.getRandomString(16);
                    session.setAttribute("_sessionAESKey_", aesKey);
                }
            }
            else {
                aesKey = (String) session.getAttribute("_sessionPreLoginAESKey_", String.class);
                if (StringUtils.isEmpty(aesKey)) {
                    aesKey = TokenUtil.getRandomString(16);
                    session.setAttribute("_sessionPreLoginAESKey_", aesKey);
                }
            }
            IntfBaseRequest commonBean = new IntfBaseRequest();
            BeanUtils.populate(commonBean, params);
            removeCommonParameter(params, IntfBaseRequest.class);
            String origString = LOJsonUtil.objectToJsonString(params);
            String encString = AESUtil.encrypt(origString, aesKey);
            params = new HashMap<String, Object>();
            params.putAll((Map<String, Object>) BeanToMap.toMap(commonBean));
            params.put("reqData", encString);
            return params;
        }
        catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static Map<String, Object> removeCommonParameter(Map<String, Object> params, Class<?> clazz) {
        try {
            PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
            Set<String> needRemove = new HashSet<String>();
            for (PropertyDescriptor pd : pds) {
                if (params.containsKey(pd.getName())) {
                    needRemove.add(pd.getName());
                }
            }
            for (String removeKey : SafeWrapperUtil.safe(needRemove)) {
                params.remove(removeKey);
            }
            return params;
        }
        catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }

    public static IntfSession loginUser(IntfSessionManager intfSessioManager, String userId) {
        IntfSession session = intfSessioManager.createIntfSession();
        session.init("88999900");
        LoginUser userInfo = new LoginUser();
        userInfo.setCustNo(userId);
        IntfSession.getSession().login(userInfo);
        return session;
    }

    public static Map<String, Object> generateCommonParams() {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("_channel_id", "01");
        request.put("_client_version_no", "1.1.0");
        request.put("_deviceId", "JunitTest");
        request.put("_request_client_info", null);
        return request;
    }

    public static Map<String, Object> updatePageParams(Map<String, Object> request) {
        if (request == null) {
            request = generateCommonParams();
        }
        request.put("currentPage", Integer.valueOf(0));
        request.put("queryNum", Integer.valueOf(20));
        return request;
    }
}
