package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPTitle </p>
 * <p> Description: 个人：职称 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPTitle {
    $0      ("0"    , "无"), 
    $1      ("1"    , "高级"), 
    $2      ("2"    , "中级"), 
    $3      ("3"    , "初级"), 
    $9      ("9"    , "未知");

    private String item;
    private String desc;

    private EPTitle(String item, String desc) {
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
        return "P_TITLE";
    }
}
