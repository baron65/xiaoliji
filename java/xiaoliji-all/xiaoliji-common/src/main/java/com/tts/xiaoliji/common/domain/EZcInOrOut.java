package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EZcInOrOut </p>
 * <p> Description: 租车：取还车标识 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EZcInOrOut {
    $O      ("O"    , "取车"), 
    $I      ("I"    , "还车");

    private String item;
    private String desc;

    private EZcInOrOut(String item, String desc) {
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
        return "ZC_IN_OR_OUT";
    }
}
