package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanApplyStatus </p>
 * <p> Description: 贷款：申请状态 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanApplyStatus {
    $S0     ("S0"   , "新建"), 
    $S1     ("S1"   , "审批中"), 
    $S2     ("S2"   , "审批通过"), 
    $S3     ("S3"   , "审批不通过"), 
    $S4     ("S4"   , "撤单"), 
    $S5     ("S5"   , "中止");

    private String item;
    private String desc;

    private ELoanApplyStatus(String item, String desc) {
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
        return "LOAN_APPLY_STATUS";
    }
}
