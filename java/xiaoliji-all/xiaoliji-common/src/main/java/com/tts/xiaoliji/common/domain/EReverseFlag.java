package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EReverseFlag </p>
 * <p> Description: 冲销标识 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EReverseFlag {
    $0      ("0"    , "未冲销"), 
    $1      ("1"    , "被冲销"), 
    $2      ("2"    , "主动冲销");

    private String item;
    private String desc;

    private EReverseFlag(String item, String desc) {
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
        return "REVERSE_FLAG";
    }
}
