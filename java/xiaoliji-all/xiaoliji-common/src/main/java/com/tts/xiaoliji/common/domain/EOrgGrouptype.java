package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EOrgGrouptype </p>
 * <p> Description: 机构：组织类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EOrgGrouptype {
    $1      ("1"    , "企业"), 
    $2      ("2"    , "机关"), 
    $3      ("3"    , "事业单位"), 
    $4      ("4"    , "社会团体"), 
    $5      ("5"    , "其他组织机构");

    private String item;
    private String desc;

    private EOrgGrouptype(String item, String desc) {
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
        return "ORG_GROUPTYPE";
    }
}
