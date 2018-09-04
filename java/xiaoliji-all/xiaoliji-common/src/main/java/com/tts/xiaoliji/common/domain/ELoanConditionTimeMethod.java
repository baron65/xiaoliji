package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanConditionTimeMethod </p>
 * <p> Description: 贷款：还款条件项的连续方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanConditionTimeMethod {
    $ME     ("ME"   , "可以超过（下一条件项的）生效从，不能超过计算日期"), 
    $LE     ("LE"   , "不能超过（下一条件项的）生效从"), 
    $EE     ("EE"   , "以（下一条件项的）生效从为界");

    private String item;
    private String desc;

    private ELoanConditionTimeMethod(String item, String desc) {
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
        return "LOAN_CONDITION_TIME_METHOD";
    }
}
