package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanCashflowState </p>
 * <p> Description: 贷款：现金流状态 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanCashflowState {
    $S      ("S"    , "模拟项"), 
    $P      ("P"    , "计划项"), 
    $A      ("A"    , "实际项"), 
    $R      ("R"    , "已撤销");

    private String item;
    private String desc;

    private ELoanCashflowState(String item, String desc) {
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
        return "LOAN_CASHFLOW_STATE";
    }
}
