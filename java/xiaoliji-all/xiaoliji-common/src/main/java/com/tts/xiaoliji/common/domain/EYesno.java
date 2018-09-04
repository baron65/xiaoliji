package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EYesno </p>
 * <p> Description: 是否 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EYesno {
    $Y      ("Y"    , "是"), 
    $N      ("N"    , "否");

    private String item;
    private String desc;

    private EYesno(String item, String desc) {
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
        return "YESNO";
    }
}
