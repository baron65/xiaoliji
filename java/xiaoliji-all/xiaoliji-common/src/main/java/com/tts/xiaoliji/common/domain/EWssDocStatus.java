package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssDocStatus </p>
 * <p> Description: 财富销售：纸质合同的状态 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssDocStatus {
    $S1     ("S1"   , "未领用"), 
    $S2     ("S2"   , "已领用"), 
    $S3     ("S3"   , "已回销"), 
    $S4     ("S4"   , "已回收"), 
    $S5     ("S5"   , "已归集"), 
    $S6     ("S6"   , "遗失");

    private String item;
    private String desc;

    private EWssDocStatus(String item, String desc) {
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
        return "WSS_DOC_STATUS";
    }
}
