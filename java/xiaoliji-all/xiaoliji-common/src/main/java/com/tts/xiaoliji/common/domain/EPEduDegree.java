package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPEduDegree </p>
 * <p> Description: 个人：学位 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPEduDegree {
    $0      ("0"    , "其他"), 
    $1      ("1"    , "名誉博士 "), 
    $2      ("2"    , "博士"), 
    $3      ("3"    , "硕士"), 
    $4      ("4"    , "学士"), 
    $9      ("9"    , "未知");

    private String item;
    private String desc;

    private EPEduDegree(String item, String desc) {
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
        return "P_EDU_DEGREE";
    }
}
