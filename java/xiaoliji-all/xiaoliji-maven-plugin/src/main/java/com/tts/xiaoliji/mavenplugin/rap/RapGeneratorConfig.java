package com.tts.xiaoliji.mavenplugin.rap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RapGeneratorConfig {

    // 基本参数
    private Map<String, String> properties = new HashMap<String, String>();

    // 不在接口response bean中生成的参数
    private List<String> excludeResponseParaList;

    // 不在接口request bean中生成的参数
    private List<String> excludeRequestParaList;
    
    // object类型支持的原生java类型
    private List<String> primitiveDataTypeList;
    
    // 需要生成参数的request url
    private List<String> requestUrlList;

    // 入参校验annotation
    private List<Javavalidator> javavalidatorList;

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public void setProperty(String key, String value) {
        if (null == properties) {
            this.properties = new HashMap<String, String>();
        }
        this.properties.put(key, value);
    }

    public String getProperty(String key) {
        return this.properties.get(key);
    }

    public List<String> getExcludeResponseParaList() {
        return excludeResponseParaList;
    }

    public void setExcludeResponseParaList(List<String> excludeResponseParaList) {
        this.excludeResponseParaList = excludeResponseParaList;
    }

    public List<String> getExcludeRequestParaList() {
        return excludeRequestParaList;
    }

    public void setExcludeRequestParaList(List<String> excludeRequestParaList) {
        this.excludeRequestParaList = excludeRequestParaList;
    }

    public List<String> getPrimitiveDataTypeList() {
        return primitiveDataTypeList;
    }

    public void setPrimitiveDataTypeList(List<String> primitiveDataTypeList) {
        this.primitiveDataTypeList = primitiveDataTypeList;
    }

    public List<String> getRequestUrlList() {
        return requestUrlList;
    }

    public void setRequestUrlList(List<String> requestUrlList) {
        this.requestUrlList = requestUrlList;
    }

    public List<Javavalidator> getJavavalidatorList() {
        return javavalidatorList;
    }

    public void setJavavalidatorList(List<Javavalidator> javavalidatorList) {
        this.javavalidatorList = javavalidatorList;
    }

    public static class Javavalidator {
        private String annotationName;

        private String annotationClass;

        public String getAnnotationName() {
            return annotationName;
        }

        public void setAnnotationName(String annotationName) {
            this.annotationName = annotationName;
        }

        public String getAnnotationClass() {
            return annotationClass;
        }

        public void setAnnotationClass(String annotationClass) {
            this.annotationClass = annotationClass;
        }
    }
}