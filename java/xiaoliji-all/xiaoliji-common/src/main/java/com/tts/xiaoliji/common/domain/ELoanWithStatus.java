package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanWithStatus </p>
 * <p> Description: 贷款：借据（带状态） </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum ELoanWithStatus {
    $A      ("A"    , "未结清贷款"), 
    $O      ("O"    , "逾期贷款"), 
    $S      ("S"    , "已结清贷款"), 
    $W      ("W"    , "已核销贷款");

    private String item;
    private String desc;

    private ELoanWithStatus(String item, String desc) {
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
        return "LOAN_WITH_STATUS";
    }
}
