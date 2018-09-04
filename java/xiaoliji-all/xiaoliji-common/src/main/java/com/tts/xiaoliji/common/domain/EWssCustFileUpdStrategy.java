package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssCustFileUpdStrategy </p>
 * <p> Description: 财富销售：客户关联材料的更新策略 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssCustFileUpdStrategy {
    $NO     ("NO"   , "永不更新"), 
    $ADD    ("ADD"  , "持续增加"), 
    $REP    ("REP"  , "替换旧材料");

    private String item;
    private String desc;

    private EWssCustFileUpdStrategy(String item, String desc) {
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
        return "WSS_CUST_FILE_UPD_STRATEGY";
    }
}
