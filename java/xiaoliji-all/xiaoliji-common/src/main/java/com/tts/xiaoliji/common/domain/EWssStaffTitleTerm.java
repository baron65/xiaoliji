package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssStaffTitleTerm </p>
 * <p> Description: 财富销售：财富团队管理职级 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssStaffTitleTerm {
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

    private EWssStaffTitleTerm(String item, String desc) {
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
        return "WSS_STAFF_TITLE_TERM";
    }
}
