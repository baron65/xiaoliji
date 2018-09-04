package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssAmtOrShare </p>
 * <p> Description: 财富销售：金额还是份额 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssAmtOrShare {
    $AMT    ("AMT"  , "金额"), 
    $SHARE  ("SHARE", "份额");

    private String item;
    private String desc;

    private EWssAmtOrShare(String item, String desc) {
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
        return "WSS_AMT_OR_SHARE";
    }
}
