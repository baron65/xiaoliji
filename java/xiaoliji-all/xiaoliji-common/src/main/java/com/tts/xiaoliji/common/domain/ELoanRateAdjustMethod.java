package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ELoanRateAdjustMethod </p>
 * <p> Description: 贷款：利率调整方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ELoanRateAdjustMethod {
    $NOADJ  ("NOADJ", "不调整"), 
    $M1D1   ("M1D1" , "每年一月一日调整"), 
    $IMMED  ("IMMED", "立即调整"), 
    $NEXT   ("NEXT" , "下一期的期初调整"), 
    $DATE   ("DATE" , "固定日期调整");

    private String item;
    private String desc;

    private ELoanRateAdjustMethod(String item, String desc) {
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
        return "LOAN_RATE_ADJUST_METHOD";
    }
}
