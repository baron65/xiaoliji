package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EFdmAcctDocDataMethod </p>
 * <p> Description: FDM：会计制证数据方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EFdmAcctDocDataMethod {
    $M      ("M"    , "只针对交易主数据制证"), 
    $D      ("D"    , "只针对交易明细数据制证"), 
    $B      ("B"    , "针对交易主数据和明细数据");

    private String item;
    private String desc;

    private EFdmAcctDocDataMethod(String item, String desc) {
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
        return "FDM_ACCT_DOC_DATA_METHOD";
    }
}
