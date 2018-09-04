package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ECurrency </p>
 * <p> Description: 币种 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum ECurrency {
    $036    ("036"  , "澳元"), 
    $124    ("124"  , "加元"), 
    $156    ("156"  , "人民币"), 
    $344    ("344"  , "港元"), 
    $392    ("392"  , "日元"), 
    $702    ("702"  , "新加坡元"), 
    $826    ("826"  , "英镑"), 
    $840    ("840"  , "美元"), 
    $910    ("910"  , "欧元");

    private String item;
    private String desc;

    private ECurrency(String item, String desc) {
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
        return "CURRENCY";
    }
}
