package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssPartnerRole </p>
 * <p> Description: 财富销售：产品关系人类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssPartnerRole {
    $OWNER  ("OWNER", "产品管理人"), 
    $TRUSTEE("TRUSTEE", "产品托管人"), 
    $SPONSOR("SPONSOR", "产品发起人"), 
    $COUNSELOR("COUNSELOR", "投资顾问"), 
    $MANAGER("MANAGER", "产品经理");

    private String item;
    private String desc;

    private EWssPartnerRole(String item, String desc) {
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
        return "WSS_PARTNER_ROLE";
    }
}
