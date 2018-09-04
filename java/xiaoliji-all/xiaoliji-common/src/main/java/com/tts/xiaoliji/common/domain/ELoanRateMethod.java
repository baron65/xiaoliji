package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanRateMethod </p>
 * <p> Description: 贷款：利率取值方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanRateMethod {
    $V      ("V"    , "取固定值Value"), 
    $R      ("R"    , "参考基准利率Reference"), 
    $I      ("I"    , "基于正常利率调整Interest（逾期利率专用）");

    private String item;
    private String desc;

    private ELoanRateMethod(String item, String desc) {
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
        return "LOAN_RATE_METHOD";
    }
}
