package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanPayStatus </p>
 * <p> Description: 贷款：期供还款状态 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum ELoanPayStatus {
    $F      ("F"    , "还清"), 
    $P      ("P"    , "计划"), 
    $N      ("N"    , "正常"), 
    $O      ("O"    , "逾期");

    private String item;
    private String desc;

    private ELoanPayStatus(String item, String desc) {
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
        return "LOAN_PAY_STATUS";
    }
}
