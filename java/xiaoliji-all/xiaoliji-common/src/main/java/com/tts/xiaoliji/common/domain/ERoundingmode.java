package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ERoundingmode </p>
 * <p> Description: 数字舍入模式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ERoundingmode {
    $R0     ("R0"   , "ROUND_UP"), 
    $R1     ("R1"   , "ROUND_DOWN"), 
    $R2     ("R2"   , "ROUND_CEILING"), 
    $R3     ("R3"   , "ROUND_FLOOR"), 
    $R4     ("R4"   , "ROUND_HALF_UP"), 
    $R5     ("R5"   , "ROUND_HALF_DOWN"), 
    $R6     ("R6"   , "ROUND_HALF_EVEN"), 
    $R7     ("R7"   , "ROUND_UNNECESSARY");

    private String item;
    private String desc;

    private ERoundingmode(String item, String desc) {
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
        return "ROUNDINGMODE";
    }
}
