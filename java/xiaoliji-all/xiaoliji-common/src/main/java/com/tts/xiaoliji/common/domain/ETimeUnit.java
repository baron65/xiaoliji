package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ETimeUnit </p>
 * <p> Description: 时间单位 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ETimeUnit {
    $D      ("D"    , "天"), 
    $W      ("W"    , "周"), 
    $B      ("B"    , "双周"), 
    $M      ("M"    , "月"), 
    $Q      ("Q"    , "季"), 
    $Y      ("Y"    , "年");

    private String item;
    private String desc;

    private ETimeUnit(String item, String desc) {
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
        return "TIME_UNIT";
    }
}
