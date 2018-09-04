package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EZcDeliverMethod </p>
 * <p> Description: 租车：取还车方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EZcDeliverMethod {
    $M1     ("M1"   , "到店"), 
    $M2     ("M2"   , "上门");

    private String item;
    private String desc;

    private EZcDeliverMethod(String item, String desc) {
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
        return "ZC_DELIVER_METHOD";
    }
}
