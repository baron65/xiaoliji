package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanTermAmountCalcMethod </p>
 * <p> Description: 贷款：期供金额计算方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanTermAmountCalcMethod {
    $C01    ("C01"  , "利随本清"), 
    $C02    ("C02"  , "等额本息"), 
    $C03    ("C03"  , "等额本金"), 
    $C04    ("C04"  , "不规则还款"), 
    $C08    ("C08"  , "平息还款法（平均拆分本金、利息）"), 
    $C09    ("C09"  , "平息还款法（不拆分本金、利息）");

    private String item;
    private String desc;

    private ELoanTermAmountCalcMethod(String item, String desc) {
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
        return "LOAN_TERM_AMOUNT_CALC_METHOD";
    }
}
