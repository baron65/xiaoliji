package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EDayrateMethod </p>
 * <p> Description: 日利率计算方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EDayrateMethod {
    $ACT    ("ACT"  , "基础利率除以实际天数，跨年的情况下，实际天数分段计算"), 
    $ACTF   ("ACTF" , "基础利率除以实际天数，实际天数为计算开始日期所在的日历年的天数"), 
    $ACTT   ("ACTT" , "基础利率除以实际天数，实际天数为计算到日期所在的日历年的天数"), 
    $D360   ("D360" , "基础利率除以360"), 
    $D365   ("D365" , "基础利率除以365"), 
    $D030   ("D030" , "基础利率除以30");

    private String item;
    private String desc;

    private EDayrateMethod(String item, String desc) {
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
        return "DAYRATE_METHOD";
    }
}
