package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPNationality </p>
 * <p> Description: 个人：国籍 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPNationality {
    $AUS    ("AUS"  , "澳大利亚"), 
    $CAN    ("CAN"  , "加拿大"), 
    $CHE    ("CHE"  , "瑞士"), 
    $CHN    ("CHN"  , "中国"), 
    $DNK    ("DNK"  , "丹麦"), 
    $GBR    ("GBR"  , "英国"), 
    $HKG    ("HKG"  , "香港"), 
    $JPN    ("JPN"  , "日本"), 
    $MAC    ("MAC"  , "澳门"), 
    $OTH    ("OTH"  , "其他"), 
    $RUS    ("RUS"  , "俄罗斯联邦"), 
    $SWE    ("SWE"  , "瑞典"), 
    $TWN    ("TWN"  , "台湾"), 
    $USA    ("USA"  , "美国");

    private String item;
    private String desc;

    private EPNationality(String item, String desc) {
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
        return "P_NATIONALITY";
    }
}
