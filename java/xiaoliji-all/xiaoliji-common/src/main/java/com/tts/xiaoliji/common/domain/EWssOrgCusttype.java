package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssOrgCusttype </p>
 * <p> Description: 财富销售：机构客户类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EWssOrgCusttype {
    $0      ("0"    , "保险机构"), 
    $1      ("1"    , "基金公司"), 
    $2      ("2"    , "上市公司"), 
    $3      ("3"    , "信托公司"), 
    $4      ("4"    , "证券公司"), 
    $5      ("5"    , "理财产品"), 
    $6      ("6"    , "企业年金"), 
    $7      ("7"    , "社保基金"), 
    $8      ("8"    , "其他机构");

    private String item;
    private String desc;

    private EWssOrgCusttype(String item, String desc) {
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
        return "WSS_ORG_CUSTTYPE";
    }
}
