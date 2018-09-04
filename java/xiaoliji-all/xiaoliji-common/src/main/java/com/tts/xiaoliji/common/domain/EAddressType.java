package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EAddressType </p>
 * <p> Description: 地址类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EAddressType {
    $MAIN   ("MAIN" , "主要地址"), 
    $STANDBY("STANDBY", "备用地址"), 
    $HOME   ("HOME" , "住宅地址"), 
    $COMPANY("COMPANY", "单位地址");

    private String item;
    private String desc;

    private EAddressType(String item, String desc) {
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
        return "ADDRESS_TYPE";
    }
}
