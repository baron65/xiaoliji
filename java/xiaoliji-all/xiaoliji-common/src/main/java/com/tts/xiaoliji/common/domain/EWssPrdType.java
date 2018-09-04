package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssPrdType </p>
 * <p> Description: 财富销售：产品类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssPrdType {
    $MONETARY("MONETARY", "货币类产品"), 
    $EXPECTED("EXPECTED", "预期收益型产品"), 
    $FLOATING("FLOATING", "浮动收益型产品"), 
    $NET    ("NET"  , "净值型产品"), 
    $STRUCTURE("STRUCTURE", "结构化产品");

    private String item;
    private String desc;

    private EWssPrdType(String item, String desc) {
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
        return "WSS_PRD_TYPE";
    }
}
