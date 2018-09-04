package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWxGender </p>
 * <p> Description: 微信：用户的性别 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWxGender {
    $1      ("1"    , "男性"), 
    $2      ("2"    , "女性"), 
    $0      ("0"    , "未知");

    private String item;
    private String desc;

    private EWxGender(String item, String desc) {
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
        return "WX_GENDER";
    }
}
