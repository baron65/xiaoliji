package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssStaffTitleRm </p>
 * <p> Description: 财富销售：RM职级 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssStaffTitleRm {
    $11     ("11"   , "客户经理1级"), 
    $12     ("12"   , "客户经理2级"), 
    $13     ("13"   , "客户经理3级"), 
    $21     ("21"   , "理财经理1级"), 
    $22     ("22"   , "理财经理2级"), 
    $23     ("23"   , "理财经理3级"), 
    $31     ("31"   , "高级理财经理1级"), 
    $32     ("32"   , "高级理财经理2级"), 
    $33     ("33"   , "高级理财经理3级"), 
    $41     ("41"   , "财富顾问1级"), 
    $42     ("42"   , "财富顾问2级"), 
    $43     ("43"   , "财富顾问3级"), 
    $51     ("51"   , "私人银行家1级"), 
    $52     ("52"   , "私人银行家2级"), 
    $53     ("53"   , "私人银行家3级"), 
    $61     ("61"   , "团队总监1级"), 
    $62     ("62"   , "团队总监2级"), 
    $63     ("63"   , "团队总监3级"), 
    $64     ("64"   , "团队总监4级"), 
    $71     ("71"   , "分公司总经理1级"), 
    $72     ("72"   , "分公司总经理2级"), 
    $73     ("73"   , "分公司总经理3级"), 
    $74     ("74"   , "分公司总经理4级");

    private String item;
    private String desc;

    private EWssStaffTitleRm(String item, String desc) {
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
        return "WSS_STAFF_TITLE_RM";
    }
}
