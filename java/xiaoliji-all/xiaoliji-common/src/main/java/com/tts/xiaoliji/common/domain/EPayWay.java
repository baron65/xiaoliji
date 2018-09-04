package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPayWay </p>
 * <p> Description: 支付方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPayWay {
    $TCMS   ("TCMS" , "资金管理系统"), 
    $CFB    ("CFB"  , "CFB"), 
    $THIRD  ("THIRD", "第三方");

    private String item;
    private String desc;

    private EPayWay(String item, String desc) {
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
        return "PAY_WAY";
    }
}
