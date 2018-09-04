package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EZcPriceUnit </p>
 * <p> Description: 租车：计价单位 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EZcPriceUnit {
    $YD     ("YD"   , "元/天"), 
    $YT     ("YT"   , "元/次"), 
    $YO     ("YO"   , "元/单");

    private String item;
    private String desc;

    private EZcPriceUnit(String item, String desc) {
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
        return "ZC_PRICE_UNIT";
    }
}
