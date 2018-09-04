package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssPrdOrBenefit </p>
 * <p> Description: 财富销售：产品或受益权 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssPrdOrBenefit {
    $P      ("P"    , "产品"), 
    $B      ("B"    , "受益权");

    private String item;
    private String desc;

    private EWssPrdOrBenefit(String item, String desc) {
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
        return "WSS_PRD_OR_BENEFIT";
    }
}
