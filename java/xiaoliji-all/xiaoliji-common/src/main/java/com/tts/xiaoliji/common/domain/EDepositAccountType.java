package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EDepositAccountType </p>
 * <p> Description: 存款账户类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EDepositAccountType {
    $00     ("00"   , "对公账号"), 
    $01     ("01"   , "借记卡"), 
    $02     ("02"   , "贷记卡"), 
    $03     ("03"   , "电子账号"), 
    $04     ("04"   , "活期账户"), 
    $05     ("05"   , "第三方账户");

    private String item;
    private String desc;

    private EDepositAccountType(String item, String desc) {
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
        return "DEPOSIT_ACCOUNT_TYPE";
    }
}
