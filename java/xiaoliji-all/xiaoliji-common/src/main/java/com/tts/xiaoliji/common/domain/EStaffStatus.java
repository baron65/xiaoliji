package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EStaffStatus </p>
 * <p> Description: 员工状态 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EStaffStatus {
    $S01    ("S01"  , "在岗"), 
    $S02    ("S02"  , "离岗"), 
    $S03    ("S03"  , "离职");

    private String item;
    private String desc;

    private EStaffStatus(String item, String desc) {
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
        return "STAFF_STATUS";
    }
}
