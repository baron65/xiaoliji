package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssPrdCategory </p>
 * <p> Description: 财富销售：产品类别 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssPrdCategory {
    $PUBLIC ("PUBLIC", "公募基金"), 
    $PRIVATE("PRIVATE", "私募基金"), 
    $ASSET  ("ASSET", "资管计划"), 
    $TRUST  ("TRUST", "信托"), 
    $INSURANCE("INSURANCE", "保险产品"), 
    $FINANCIAL("FINANCIAL", "理财");

    private String item;
    private String desc;

    private EWssPrdCategory(String item, String desc) {
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
        return "WSS_PRD_CATEGORY";
    }
}
