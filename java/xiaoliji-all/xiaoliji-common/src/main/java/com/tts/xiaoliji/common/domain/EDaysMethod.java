package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EDaysMethod </p>
 * <p> Description: 天数计算方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EDaysMethod {
    $ACT    ("ACT"  , "按实际天数计算"), 
    $D360N  ("D360N", "每个月都是30天，2月遇月末补充的天数计入下一个周期"), 
    $D360C  ("D360C", "每个月都是30天，2月遇月末补充的天数计入当前周期"), 
    $D365   ("D365" , "忽略2月29日"), 
    $FIX    ("FIX"  , "不管实际天数，计算天数都为固定值");

    private String item;
    private String desc;

    private EDaysMethod(String item, String desc) {
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
        return "DAYS_METHOD";
    }
}
