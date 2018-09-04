package com.tts.xiaoliji.intf.base.cache;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import cn.openlo.common.util.PropertiesUtil;
import cn.openlo.exception.LOException;
import cn.openlo.gear.cache.AbstractCacheBean;
import cn.openlo.panel.PanelFactory;
import cn.openlo.panel.PanelURL;

@Component("gearCache")
public class GearPropertyCache extends AbstractCacheBean {
    private final Logger logger = LoggerFactory.getLogger(GearPropertyCache.class);

    private String propertyFile;

    public String getPropertyFile() {
        return this.propertyFile;
    }

    public void setPropertyFile(String propertyFile) {
        this.propertyFile = propertyFile;
    }

    protected void doRefresh() {
        try {
            String rsaContent = PanelFactory.getPanel().get(new PanelURL("gear/loan-intf-encrypt.properties"));
            Properties properties = PropertiesUtil.toProperties(rsaContent);
            Set<Map.Entry<Object, Object>> items = properties.entrySet();
            for (Map.Entry<Object, Object> item : items) {
                String nameString = StringUtils.trimWhitespace((String) item.getKey());
                String valueString = StringUtils.trimWhitespace((String) item.getValue());
                if ("loan.intf.aes.encrypt".equals(nameString)) {
                    put("enableAES", Boolean.valueOf(valueString));
                }
                else if ("loan.intf.rsa.encrypt".equals(nameString)) {
                    put("enableRSA", Boolean.valueOf(valueString));
                }
                else if ("loan.intf.environment.info".equals(nameString)) {
                    put("environmentInfo", valueString);
                }
                else if ("loan.intf.only.vip.access".equals(nameString)) {
                    put("vipCheckFlag", Boolean.valueOf(valueString));
                }
                else if ("loan.intf.vip.phone.list".equals(nameString)) {
                    Set<String> phoneSet = new HashSet<String>();
                    String[] phoneArray = StringUtils.delimitedListToStringArray(valueString, "|");
                    if (phoneArray != null) {
                        phoneSet.addAll(Arrays.asList(phoneArray));
                        put("vipMobileSet", phoneSet);
                    }
                }
                else if ("loan.intf.eacct.ocr.switch.off".equals(nameString)) {
                    put("eacctOcrSwitch", Boolean.valueOf(valueString));
                }
                else if ("loan.intf.regist.risk.switch.off".equals(nameString)) {
                    put("rigstRiskSwitch", Boolean.valueOf(valueString));
                }
            }
        }
        catch (LOException e) {
            this.logger.error(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String valueString = "13800138000|13800138001|13800138002";
        Set<String> phoneSet = new HashSet<String>();
        String[] phoneArray = StringUtils.delimitedListToStringArray(valueString, "|");
        System.out.println(phoneArray.length);
        if (phoneArray != null) {
            phoneSet.addAll(Arrays.asList(phoneArray));
            System.out.println("phoneSet is not empty, the size is {}" + phoneSet.size());
        }
    }
}
