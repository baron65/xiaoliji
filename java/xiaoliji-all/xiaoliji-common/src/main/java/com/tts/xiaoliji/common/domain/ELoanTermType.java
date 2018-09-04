package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanTermType </p>
 * <p> Description: 贷款：贷款期限类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanTermType {
    $S      ("S"    , "短期"), 
    $N      ("N"    , "中期"), 
    $L      ("L"    , "长期");

    private String item;
    private String desc;

    private ELoanTermType(String item, String desc) {
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
        return "LOAN_TERM_TYPE";
    }
}
