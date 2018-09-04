package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ECashFlag </p>
 * <p> Description: 钞汇标志 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum ECashFlag {
    $0      ("0"    , "现钞"), 
    $1      ("1"    , "现汇"), 
    $2      ("2"    , "均可");

    private String item;
    private String desc;

    private ECashFlag(String item, String desc) {
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
        return "CASH_FLAG";
    }
}
