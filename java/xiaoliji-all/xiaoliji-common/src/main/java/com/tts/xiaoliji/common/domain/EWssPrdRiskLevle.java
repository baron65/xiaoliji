package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssPrdRiskLevle </p>
 * <p> Description: 财富销售：产品风险等级 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssPrdRiskLevle {
    $0      ("0"    , "未评级"), 
    $1      ("1"    , "低风险"), 
    $2      ("2"    , "中低风险"), 
    $3      ("3"    , "中等风险"), 
    $4      ("4"    , "中高风险"), 
    $5      ("5"    , "高风险");

    private String item;
    private String desc;

    private EWssPrdRiskLevle(String item, String desc) {
        this.item = item;
        this.desc = desc;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean equals(String item) {
        return this.item.equals(item);
    }

    public static String getCodeName() {
        return "WSS_PRD_RISK_LEVLE";
    }
}
