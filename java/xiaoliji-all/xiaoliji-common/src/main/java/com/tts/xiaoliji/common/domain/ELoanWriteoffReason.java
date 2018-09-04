package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanWriteoffReason </p>
 * <p> Description: 贷款：核销原因 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum ELoanWriteoffReason {
    $M01    ("M01"  , "借款人破产"), 
    $M02    ("M02"  , "借款人失踪");

    private String item;
    private String desc;

    private ELoanWriteoffReason(String item, String desc) {
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
        return "LOAN_WRITEOFF_REASON";
    }
}
