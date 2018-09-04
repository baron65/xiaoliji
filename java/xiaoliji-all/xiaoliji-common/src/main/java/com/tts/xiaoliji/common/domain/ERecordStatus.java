package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ERecordStatus </p>
 * <p> Description: 记录的状态 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ERecordStatus {
    $A      ("A"    , "活动的Active"), 
    $D      ("D"    , "无效的Delete");

    private String item;
    private String desc;

    private ERecordStatus(String item, String desc) {
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
        return "RECORD_STATUS";
    }
}
