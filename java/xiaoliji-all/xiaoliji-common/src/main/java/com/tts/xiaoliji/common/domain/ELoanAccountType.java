package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanAccountType </p>
 * <p> Description: 贷款：账户类别 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanAccountType {
    $DISB   ("DISB" , "放款账号"), 
    $REPY   ("REPY" , "还款账号"), 
    $BOTH   ("BOTH" , "放款、还款账号"), 
    $GUAR   ("GUAR" , "保证金账号"), 
    $THID   ("THID" , "第三方收款账号");

    private String item;
    private String desc;

    private ELoanAccountType(String item, String desc) {
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
        return "LOAN_ACCOUNT_TYPE";
    }
}
