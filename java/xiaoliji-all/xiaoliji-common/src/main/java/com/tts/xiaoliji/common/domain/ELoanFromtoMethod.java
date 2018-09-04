package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanFromtoMethod </p>
 * <p> Description: 贷款：贷款始末日期取值方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanFromtoMethod {
    $FDTD   ("FDTD" , "开始日跟随放款日变化，到期日跟随放款日变化"), 
    $FDTT   ("FDTT" , "开始日跟随放款日变化，到期日不变"), 
    $FFTT   ("FFTT" , "开始日不变，到期日不变");

    private String item;
    private String desc;

    private ELoanFromtoMethod(String item, String desc) {
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
        return "LOAN_FROMTO_METHOD";
    }
}
