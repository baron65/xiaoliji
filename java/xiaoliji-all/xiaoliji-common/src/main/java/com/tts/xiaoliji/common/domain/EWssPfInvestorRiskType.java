package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssPfInvestorRiskType </p>
 * <p> Description: 财富销售：私募基金投资者风险类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EWssPfInvestorRiskType {
    $0      ("0"    , "未评定"), 
    $1      ("1"    , "保守型"), 
    $2      ("2"    , "稳健型"), 
    $3      ("3"    , "平衡型"), 
    $4      ("4"    , "成长型"), 
    $5      ("5"    , "进取型");

    private String item;
    private String desc;

    private EWssPfInvestorRiskType(String item, String desc) {
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
        return "WSS_PF_INVESTOR_RISK_TYPE";
    }
}
