package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssRorMethod </p>
 * <p> Description: 财富销售：产品报价方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssRorMethod {
    $M1     ("M1"   , "不报价"), 
    $M2     ("M2"   , "上下业绩基准"), 
    $M3     ("M3"   , "业绩基准"), 
    $M4     ("M4"   , "根据订单期限，使用时间区间报价"), 
    $M5     ("M5"   , "根据订单期限，使用最新报价"), 
    $M6     ("M6"   , "根据订单期限、认购金额、使用时间区间报价");

    private String item;
    private String desc;

    private EWssRorMethod(String item, String desc) {
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
        return "WSS_ROR_METHOD";
    }
}
