package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanConditionGroup </p>
 * <p> Description: 贷款：计算条件组 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanConditionGroup {
    $B      ("B"    , "本金Principle+利息Interest"), 
    $O      ("O"    , "罚息IOA"), 
    $P      ("P"    , "本金Principle"), 
    $I      ("I"    , "利息Interest"), 
    $C      ("C"    , "税费Charge"), 
    $OP     ("OP"   , "本金罚息IOA of Principle"), 
    $OI     ("OI"   , "利息罚息IOA of Interest"), 
    $OO     ("OO"   , "罚息罚息"), 
    $OB     ("OB"   , "本利罚息"), 
    $OC     ("OC"   , "税费罚息");

    private String item;
    private String desc;

    private ELoanConditionGroup(String item, String desc) {
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
        return "LOAN_CONDITION_GROUP";
    }
}
