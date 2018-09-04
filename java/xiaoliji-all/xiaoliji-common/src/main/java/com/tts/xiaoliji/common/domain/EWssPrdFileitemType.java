package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssPrdFileitemType </p>
 * <p> Description: 财富销售：产品材料类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssPrdFileitemType {
    $F1     ("F1"   , "推介材料"), 
    $F2     ("F2"   , "产品报告");

    private String item;
    private String desc;

    private EWssPrdFileitemType(String item, String desc) {
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
        return "WSS_PRD_FILEITEM_TYPE";
    }
}
