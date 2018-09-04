package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssDocTransStatus </p>
 * <p> Description: 财富销售：纸质合同出入库操作的状态 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssDocTransStatus {
    $S1     ("S1"   , "发起"), 
    $S2     ("S2"   , "完成"), 
    $S3     ("S3"   , "遗失"), 
    $S4     ("S4"   , "已取消");

    private String item;
    private String desc;

    private EWssDocTransStatus(String item, String desc) {
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
        return "WSS_DOC_TRANS_STATUS";
    }
}
