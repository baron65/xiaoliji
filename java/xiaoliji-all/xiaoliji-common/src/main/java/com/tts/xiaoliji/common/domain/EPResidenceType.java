package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPResidenceType </p>
 * <p> Description: 个人：居住状况 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPResidenceType {
    $1      ("1"    , "自置"), 
    $2      ("2"    , "按揭"), 
    $3      ("3"    , "亲属楼宇"), 
    $4      ("4"    , "集体宿舍"), 
    $5      ("5"    , "租房"), 
    $6      ("6"    , "共有住宅"), 
    $7      ("7"    , "其他"), 
    $9      ("9"    , "未知");

    private String item;
    private String desc;

    private EPResidenceType(String item, String desc) {
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
        return "P_RESIDENCE_TYPE";
    }
}
