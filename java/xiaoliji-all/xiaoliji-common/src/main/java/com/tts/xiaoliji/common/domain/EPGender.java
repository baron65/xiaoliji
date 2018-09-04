package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPGender </p>
 * <p> Description: 个人：性别 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPGender {
    $0      ("0"    , "女性"), 
    $1      ("1"    , "男性"), 
    $2      ("2"    , "未说明性别");

    private String item;
    private String desc;

    private EPGender(String item, String desc) {
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
        return "P_GENDER";
    }
}
