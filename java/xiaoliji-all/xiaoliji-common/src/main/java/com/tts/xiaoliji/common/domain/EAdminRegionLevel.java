package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EAdminRegionLevel </p>
 * <p> Description: 行政区级别 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EAdminRegionLevel {
    $1      ("1"    , "省级"), 
    $2      ("2"    , "地级"), 
    $3      ("3"    , "县级"), 
    $4      ("4"    , "乡级（区、乡、镇）"), 
    $5      ("5"    , "村级（街道、村）");

    private String item;
    private String desc;

    private EAdminRegionLevel(String item, String desc) {
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
        return "ADMIN_REGION_LEVEL";
    }
}
