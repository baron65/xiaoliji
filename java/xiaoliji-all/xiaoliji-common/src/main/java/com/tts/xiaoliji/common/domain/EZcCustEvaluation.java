package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EZcCustEvaluation </p>
 * <p> Description: 租车：用户评价 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EZcCustEvaluation {
    $S1     ("S1"   , "一星"), 
    $S2     ("S2"   , "两星"), 
    $S3     ("S3"   , "三星"), 
    $S4     ("S4"   , "四星"), 
    $S5     ("S5"   , "五星");

    private String item;
    private String desc;

    private EZcCustEvaluation(String item, String desc) {
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
        return "ZC_CUST_EVALUATION";
    }
}
