package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssPrdStatus </p>
 * <p> Description: 财富销售：产品状态 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssPrdStatus {
    $0      ("0"    , "开放期"), 
    $1      ("1"    , "募集期"), 
    $2      ("2"    , "发行成功"), 
    $3      ("3"    , "发行失败"), 
    $4      ("4"    , "停止交易"), 
    $5      ("5"    , "停止申购"), 
    $6      ("6"    , "停止赎回"), 
    $7      ("7"    , "权益登记"), 
    $8      ("8"    , "红利发放"), 
    $9      ("9"    , "产品封闭"), 
    $a      ("a"    , "产品终止"), 
    $b      ("b"    , "预约认购期");

    private String item;
    private String desc;

    private EWssPrdStatus(String item, String desc) {
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
        return "WSS_PRD_STATUS";
    }
}
