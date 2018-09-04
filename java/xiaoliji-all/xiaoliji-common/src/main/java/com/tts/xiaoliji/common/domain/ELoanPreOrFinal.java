package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanPreOrFinal </p>
 * <p> Description: 贷款：期供先付后付 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanPreOrFinal {
    $T0     ("T0"   , "付款时间是在期末"), 
    $T1     ("T1"   , "付款时间是在期初");

    private String item;
    private String desc;

    private ELoanPreOrFinal(String item, String desc) {
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
        return "LOAN_PRE_OR_FINAL";
    }
}
