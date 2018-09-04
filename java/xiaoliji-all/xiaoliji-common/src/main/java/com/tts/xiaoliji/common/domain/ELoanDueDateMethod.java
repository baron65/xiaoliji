package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanDueDateMethod </p>
 * <p> Description: 贷款：收款日计算方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanDueDateMethod {
    $EQU    ("EQU"  , "等于计算日期"), 
    $ADD    ("ADD"  , "计算日期加N天"), 
    $BOM    ("BOM"  , "计算日期的月初Begin of month"), 
    $EOM    ("EOM"  , "计算日期的月末End of month"), 
    $FOM    ("FOM"  , "等于计算日期当月的固定天Fixed day of month"), 
    $NEX    ("NEX"  , "计算日期遇节假日向后顺延到下一个工作日"), 
    $PRE    ("PRE"  , "计算日期遇节假日向前顺延到上一个工作日");

    private String item;
    private String desc;

    private ELoanDueDateMethod(String item, String desc) {
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
        return "LOAN_DUE_DATE_METHOD";
    }
}
