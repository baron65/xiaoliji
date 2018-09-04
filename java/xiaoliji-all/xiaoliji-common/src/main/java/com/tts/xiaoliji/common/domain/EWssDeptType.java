package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssDeptType </p>
 * <p> Description: 财富销售：部门类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssDeptType {
    $L1     ("L1"   , "金控总部"), 
    $L2     ("L2"   , "金服总部"), 
    $L3     ("L3"   , "事业部"), 
    $L4     ("L4"   , "事业部分部"), 
    $L5     ("L5"   , "城市公司"), 
    $L6     ("L6"   , "团队");

    private String item;
    private String desc;

    private EWssDeptType(String item, String desc) {
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
        return "WSS_DEPT_TYPE";
    }
}
