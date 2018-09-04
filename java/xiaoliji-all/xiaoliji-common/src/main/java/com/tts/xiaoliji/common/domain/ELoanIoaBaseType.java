package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanIoaBaseType </p>
 * <p> Description: 贷款：罚息计算基础 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanIoaBaseType {
    $B1     ("B1"   , "本金"), 
    $B2     ("B2"   , "本金+利息"), 
    $B3     ("B3"   , "本金+利息+罚息"), 
    $B4     ("B4"   , "利息");

    private String item;
    private String desc;

    private ELoanIoaBaseType(String item, String desc) {
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
        return "LOAN_IOA_BASE_TYPE";
    }
}
