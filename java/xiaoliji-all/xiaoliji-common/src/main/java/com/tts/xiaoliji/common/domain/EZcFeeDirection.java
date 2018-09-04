package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EZcFeeDirection </p>
 * <p> Description: 租车：费用方向 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EZcFeeDirection {
    $SI     ("SI"   , "应收"), 
    $SO     ("SO"   , "应付"), 
    $AI     ("AI"   , "实收"), 
    $AO     ("AO"   , "实付");

    private String item;
    private String desc;

    private EZcFeeDirection(String item, String desc) {
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
        return "ZC_FEE_DIRECTION";
    }
}
