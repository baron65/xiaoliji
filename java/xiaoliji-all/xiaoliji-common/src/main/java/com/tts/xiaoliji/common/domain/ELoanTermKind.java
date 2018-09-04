package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanTermKind </p>
 * <p> Description: 贷款：期供类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum ELoanTermKind {
    $X      ("X"    , "先付"), 
    $W      ("W"    , "尾款"), 
    $S      ("S"    , "首付款"), 
    $F      ("F"    , "首期"), 
    $N      ("N"    , "中间期"), 
    $L      ("L"    , "末期");

    private String item;
    private String desc;

    private ELoanTermKind(String item, String desc) {
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
        return "LOAN_TERM_KIND";
    }
}
