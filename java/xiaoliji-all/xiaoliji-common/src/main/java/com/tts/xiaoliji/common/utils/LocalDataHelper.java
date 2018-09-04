package com.tts.xiaoliji.common.utils;

import org.springframework.util.StringUtils;

public class LocalDataHelper {

    private String defCompanyCode;
    private String defLanguage;

    private static final ThreadLocal<String> threadCompanyCode = new ThreadLocal<>();
    private static final ThreadLocal<String> threadLanguage = new ThreadLocal<>();

    public void setCompanyCode(String companyCode) {
        threadCompanyCode.set(companyCode);
    }

    public void setLanguage(String language) {
        threadLanguage.set(language);
    }

    public String getCompanyCode() {
        String companyCode = threadCompanyCode.get();

        if (StringUtils.isEmpty(companyCode)) {
            return defCompanyCode;
        }
        else {
            return companyCode;
        }
    }

    public String getLanguage() {
        String language = threadLanguage.get();

        if (StringUtils.isEmpty(language)) {
            return defLanguage;
        }
        else {
            return language;
        }
    }

    public void removeCompanyCode() {
        threadCompanyCode.remove();
    }

    public void removeLanguage() {
        threadLanguage.remove();
    }

    public void remove() {
        removeCompanyCode();
        removeLanguage();
    }

    public String getDefCompanyCode() {
        return defCompanyCode;
    }

    public void setDefCompanyCode(String defCompanyCode) {
        this.defCompanyCode = defCompanyCode;
    }

    public String getDefLanguage() {
        return defLanguage;
    }

    public void setDefLanguage(String defLanguage) {
        this.defLanguage = defLanguage;
    }
}