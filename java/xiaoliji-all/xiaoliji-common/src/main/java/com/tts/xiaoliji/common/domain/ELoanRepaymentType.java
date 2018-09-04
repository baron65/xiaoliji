package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanRepaymentType </p>
 * <p> Description: 贷款：还款方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanRepaymentType {
    $T01    ("T01"  , "利随本清"), 
    $T02    ("T02"  , "固定周期付息，一次还本"), 
    $T03    ("T03"  , "等额本息"), 
    $T04    ("T04"  , "等额本金"), 
    $T05    ("T05"  , "气球贷"), 
    $T06    ("T06"  , "不规则还款"), 
    $T07    ("T07"  , "组合还款法"), 
    $T08    ("T08"  , "平息还款法（平均拆分本金、利息）"), 
    $T09    ("T09"  , "平息还款法（不拆分本金、利息）");

    private String item;
    private String desc;

    private ELoanRepaymentType(String item, String desc) {
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
        return "LOAN_REPAYMENT_TYPE";
    }
}
