package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssCustRelationRole </p>
 * <p> Description: 财富销售：客户归属的角色 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EWssCustRelationRole {
    $RM     ("RM"   , "理财经理"), 
    $CM     ("CM"   , "客户经理");

    private String item;
    private String desc;

    private EWssCustRelationRole(String item, String desc) {
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
        return "WSS_CUST_RELATION_ROLE";
    }
}
