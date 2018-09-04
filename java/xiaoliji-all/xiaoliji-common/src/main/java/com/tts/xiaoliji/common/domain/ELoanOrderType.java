package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanOrderType </p>
 * <p> Description: 贷款：还款排序方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanOrderType {
    $ASC    ("ASC"  , "顺序"), 
    $DESC   ("DESC" , "倒序"), 
    $LIST   ("LIST" , "列表");

    private String item;
    private String desc;

    private ELoanOrderType(String item, String desc) {
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
        return "LOAN_ORDER_TYPE";
    }
}
