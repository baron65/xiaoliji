package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanIoaDateMethod </p>
 * <p> Description: 贷款：罚息结算日的规则 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum ELoanIoaDateMethod {
    $C      ("C"    , "跟随本息计算日"), 
    $P      ("P"    , "跟随本息应收日"), 
    $G      ("G"    , "跟随本息宽限期到期日"), 
    $M      ("M"    , "每月固定日");

    private String item;
    private String desc;

    private ELoanIoaDateMethod(String item, String desc) {
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
        return "LOAN_IOA_DATE_METHOD";
    }
}
