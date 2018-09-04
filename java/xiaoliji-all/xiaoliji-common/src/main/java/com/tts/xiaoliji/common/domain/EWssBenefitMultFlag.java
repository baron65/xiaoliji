package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssBenefitMultFlag </p>
 * <p> Description: 财富销售：多受益权标识 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssBenefitMultFlag {
    $1      ("1"    , "多受益权"), 
    $2      ("2"    , "单受益权");

    private String item;
    private String desc;

    private EWssBenefitMultFlag(String item, String desc) {
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
        return "WSS_BENEFIT_MULT_FLAG";
    }
}
