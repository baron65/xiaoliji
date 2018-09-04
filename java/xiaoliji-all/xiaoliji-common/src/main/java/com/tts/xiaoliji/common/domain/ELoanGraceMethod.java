package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanGraceMethod </p>
 * <p> Description: 贷款：宽限期方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanGraceMethod {
    $N      ("N"    , "不宽限"), 
    $D      ("D"    , "宽限固定自然天数"), 
    $W      ("W"    , "宽限固定工作日天数"), 
    $M      ("M"    , "月内宽限，不固定天数");

    private String item;
    private String desc;

    private ELoanGraceMethod(String item, String desc) {
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
        return "LOAN_GRACE_METHOD";
    }
}
