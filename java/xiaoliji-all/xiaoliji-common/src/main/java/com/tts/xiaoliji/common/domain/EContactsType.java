package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EContactsType </p>
 * <p> Description: 联系人类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EContactsType {
    $MAIN   ("MAIN" , "联系人"), 
    $STANDBY("STANDBY", "备用联系人"), 
    $SPOUSE ("SPOUSE", "配偶"), 
    $EMERGENCY("EMERGENCY", "紧急联系人"), 
    $LEGAL  ("LEGAL", "企业的法人");

    private String item;
    private String desc;

    private EContactsType(String item, String desc) {
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
        return "CONTACTS_TYPE";
    }
}
