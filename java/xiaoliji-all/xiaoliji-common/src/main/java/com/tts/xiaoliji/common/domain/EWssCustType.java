package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssCustType </p>
 * <p> Description: 财富销售：客户类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssCustType {
    $P      ("P"    , "个人"), 
    $C      ("C"    , "机构"), 
    $S      ("S"    , "机构下子客户"), 
    $N      ("N"    , "内部产品");

    private String item;
    private String desc;

    private EWssCustType(String item, String desc) {
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
        return "WSS_CUST_TYPE";
    }
}
