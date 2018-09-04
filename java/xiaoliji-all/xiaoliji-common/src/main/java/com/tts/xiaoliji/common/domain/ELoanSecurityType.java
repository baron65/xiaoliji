package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanSecurityType </p>
 * <p> Description: 贷款：担保方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanSecurityType {
    $S01    ("S01"  , "保证"), 
    $S02    ("S02"  , "抵押"), 
    $S03    ("S03"  , "质押"), 
    $S04    ("S04"  , "信用"), 
    $S05    ("S05"  , "保证+质押");

    private String item;
    private String desc;

    private ELoanSecurityType(String item, String desc) {
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
        return "LOAN_SECURITY_TYPE";
    }
}
