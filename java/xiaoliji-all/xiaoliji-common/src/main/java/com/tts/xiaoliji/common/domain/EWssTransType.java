package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssTransType </p>
 * <p> Description: 财富销售：交易类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EWssTransType {
    $BUY    ("BUY"  , "认购"), 
    $REDEEM ("REDEEM", "赎回"), 
    $HOLD   ("HOLD" , "持有");

    private String item;
    private String desc;

    private EWssTransType(String item, String desc) {
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
        return "WSS_TRANS_TYPE";
    }
}
