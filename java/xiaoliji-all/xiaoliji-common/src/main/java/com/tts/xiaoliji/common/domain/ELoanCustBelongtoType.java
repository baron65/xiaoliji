package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanCustBelongtoType </p>
 * <p> Description: 贷款：客户归属关系 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum ELoanCustBelongtoType {
    $BUSINESS("BUSINESS", "业务归属"), 
    $SALES  ("SALES", "销售归属"), 
    $DUE_DUTY("DUE_DUTY", "催收归属");

    private String item;
    private String desc;

    private ELoanCustBelongtoType(String item, String desc) {
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
        return "LOAN_CUST_BELONGTO_TYPE";
    }
}
