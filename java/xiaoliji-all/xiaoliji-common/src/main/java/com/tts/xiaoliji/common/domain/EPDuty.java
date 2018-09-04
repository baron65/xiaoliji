package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPDuty </p>
 * <p> Description: 个人：职务 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPDuty {
    $1      ("1"    , "高级领导（行政级别局级及局级以上领导或大公司高级管理人员）"), 
    $2      ("2"    , "中级领导（行政级别局级以下领导或大公司中级管理人员）"), 
    $3      ("3"    , "一般员工"), 
    $4      ("4"    , "其他"), 
    $9      ("9"    , "未知");

    private String item;
    private String desc;

    private EPDuty(String item, String desc) {
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
        return "P_DUTY";
    }
}
