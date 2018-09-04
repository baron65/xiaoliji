package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanAmountType </p>
 * <p> Description: 贷款：贷款金额类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum ELoanAmountType {
    $D      ("D"    , "放款金额"), 
    $R      ("R"    , "应收金额"), 
    $O      ("O"    , "逾期金额"), 
    $P      ("P"    , "收款金额");

    private String item;
    private String desc;

    private ELoanAmountType(String item, String desc) {
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
        return "LOAN_AMOUNT_TYPE";
    }
}
