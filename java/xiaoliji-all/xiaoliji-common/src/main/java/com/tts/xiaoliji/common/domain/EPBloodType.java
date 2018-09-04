package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPBloodType </p>
 * <p> Description: 个人：血型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPBloodType {
    $O      ("O"    , "O型"), 
    $A      ("A"    , "A型"), 
    $B      ("B"    , "B型"), 
    $AB     ("AB"   , "AB型"), 
    $U      ("U"    , "未知");

    private String item;
    private String desc;

    private EPBloodType(String item, String desc) {
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
        return "P_BLOOD_TYPE";
    }
}
