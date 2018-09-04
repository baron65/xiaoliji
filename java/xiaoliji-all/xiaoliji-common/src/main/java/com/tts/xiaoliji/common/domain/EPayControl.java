package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPayControl </p>
 * <p> Description: 扣款控制 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPayControl {
    $C0     ("C0"   , "有多少扣多少"), 
    $C1     ("C1"   , "足额才扣款");

    private String item;
    private String desc;

    private EPayControl(String item, String desc) {
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
        return "PAY_CONTROL";
    }
}
