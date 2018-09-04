package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssDocTransType </p>
 * <p> Description: 财富销售：纸质合同的出入库操作类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssDocTransType {
    $T1     ("T1"   , "入库"), 
    $T2     ("T2"   , "分发"), 
    $T3     ("T3"   , "发放"), 
    $T4     ("T4"   , "遗失"), 
    $T5     ("T5"   , "回销"), 
    $T6     ("T6"   , "回收"), 
    $T7     ("T7"   , "归集");

    private String item;
    private String desc;

    private EWssDocTransType(String item, String desc) {
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
        return "WSS_DOC_TRANS_TYPE";
    }
}
