package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPIdtype </p>
 * <p> Description: 个人：证件类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPIdtype {
    $0      ("0"    , "身份证"), 
    $1      ("1"    , "护照"), 
    $2      ("2"    , "军官证"), 
    $3      ("3"    , "士兵证"), 
    $4      ("4"    , "港澳居民来往内地通行证"), 
    $5      ("5"    , "户口簿"), 
    $6      ("6"    , "外国护照"), 
    $7      ("7"    , "其它"), 
    $8      ("8"    , "文职证"), 
    $9      ("9"    , "警官证"), 
    $J      ("J"    , "台湾同胞来往内地通行证");

    private String item;
    private String desc;

    private EPIdtype(String item, String desc) {
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
        return "P_IDTYPE";
    }
}
