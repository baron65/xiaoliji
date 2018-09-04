package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssInvestorType </p>
 * <p> Description: 财富销售：投资人类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssInvestorType {
    $0      ("0"    , "个人"), 
    $1      ("1"    , "金融机构"), 
    $2      ("2"    , "中小企业"), 
    $3      ("3"    , "国资、国企背景企业"), 
    $4      ("4"    , "产品");

    private String item;
    private String desc;

    private EWssInvestorType(String item, String desc) {
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
        return "WSS_INVESTOR_TYPE";
    }
}
