package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanFirstLastTermCalcMethod </p>
 * <p> Description: 贷款：首末期计算方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanFirstLastTermCalcMethod {
    $T      ("T"    , "期供当做一整期处理"), 
    $A      ("A"    , "期供按照实际天数所占比例计算");

    private String item;
    private String desc;

    private ELoanFirstLastTermCalcMethod(String item, String desc) {
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
        return "LOAN_FIRST_LAST_TERM_CALC_METHOD";
    }
}
