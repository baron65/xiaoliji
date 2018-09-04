package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanDisbStatus </p>
 * <p> Description: 贷款：放款状态 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanDisbStatus {
    $0      ("0"    , "待放款"), 
    $1      ("1"    , "放款中"), 
    $2      ("2"    , "失败"), 
    $3      ("3"    , "成功"), 
    $4      ("4"    , "中止");

    private String item;
    private String desc;

    private ELoanDisbStatus(String item, String desc) {
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
        return "LOAN_DISB_STATUS";
    }
}
