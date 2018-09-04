package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanCashflowKind </p>
 * <p> Description: 贷款：现金流种类 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanCashflowKind {
    $O      ("O"    , "罚息IOA"), 
    $OP     ("OP"   , "本金罚息"), 
    $OI     ("OI"   , "利息罚息"), 
    $OB     ("OB"   , "本利罚息"), 
    $OO     ("OO"   , "罚息罚息"), 
    $OC     ("OC"   , "税费罚息"), 
    $P      ("P"    , "本金Principle"), 
    $I      ("I"    , "利息Interest"), 
    $C      ("C"    , "税费Charge"), 
    $B      ("B"    , "本金和利息");

    private String item;
    private String desc;

    private ELoanCashflowKind(String item, String desc) {
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
        return "LOAN_CASHFLOW_KIND";
    }
}
