package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EZcFeeCategory </p>
 * <p> Description: 租车：费用种类 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EZcFeeCategory {
    $R      ("R"    , "租金"), 
    $S      ("S"    , "服务费"), 
    $D      ("D"    , "押金"), 
    $M      ("M"    , "物损物耗"), 
    $I      ("I"    , "保险"), 
    $P      ("P"    , "违约金"), 
    $F      ("F"    , "定金");

    private String item;
    private String desc;

    private EZcFeeCategory(String item, String desc) {
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
        return "ZC_FEE_CATEGORY";
    }
}
