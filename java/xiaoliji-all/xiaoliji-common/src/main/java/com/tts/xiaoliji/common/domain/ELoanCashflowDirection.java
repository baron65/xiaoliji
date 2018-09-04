package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanCashflowDirection </p>
 * <p> Description: 贷款：现金流方向 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanCashflowDirection {
    $SI     ("SI"   , "应收ShouldInput"), 
    $SO     ("SO"   , "应付ShouldOutput"), 
    $I      ("I"    , "实收Input"), 
    $O      ("O"    , "实付Output"), 
    $BI     ("BI"   , "代收BehalfInput"), 
    $BO     ("BO"   , "代付BehalfOutput"), 
    $R      ("R"    , "冲销"), 
    $D      ("D"    , "减免");

    private String item;
    private String desc;

    private ELoanCashflowDirection(String item, String desc) {
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
        return "LOAN_CASHFLOW_DIRECTION";
    }
}
