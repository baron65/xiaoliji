package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPNation </p>
 * <p> Description: 个人：民族 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPNation {
    $01     ("01"   , "汉族"), 
    $02     ("02"   , "蒙古族"), 
    $03     ("03"   , "回族"), 
    $04     ("04"   , "藏族"), 
    $05     ("05"   , "维吾尔族"), 
    $06     ("06"   , "苗族"), 
    $07     ("07"   , "彝族"), 
    $08     ("08"   , "壮族"), 
    $09     ("09"   , "布依族"), 
    $10     ("10"   , "朝鲜族"), 
    $11     ("11"   , "满族"), 
    $12     ("12"   , "侗族"), 
    $13     ("13"   , "瑶族"), 
    $14     ("14"   , "白族"), 
    $15     ("15"   , "土家族"), 
    $16     ("16"   , "哈尼族"), 
    $17     ("17"   , "哈萨克族"), 
    $18     ("18"   , "傣族"), 
    $19     ("19"   , "黎族"), 
    $20     ("20"   , "傈僳族"), 
    $21     ("21"   , "佤族"), 
    $22     ("22"   , "畲族"), 
    $23     ("23"   , "高山族"), 
    $24     ("24"   , "拉祜族"), 
    $25     ("25"   , "水族"), 
    $26     ("26"   , "东乡族"), 
    $27     ("27"   , "纳西族"), 
    $28     ("28"   , "景颇族"), 
    $29     ("29"   , "柯尔克孜族"), 
    $30     ("30"   , "土族"), 
    $31     ("31"   , "达斡尔族"), 
    $32     ("32"   , "仫佬族"), 
    $33     ("33"   , "羌族"), 
    $34     ("34"   , "布朗族"), 
    $35     ("35"   , "撒拉族"), 
    $36     ("36"   , "毛难族"), 
    $37     ("37"   , "仡佬族"), 
    $38     ("38"   , "锡伯族"), 
    $39     ("39"   , "阿昌族"), 
    $40     ("40"   , "普米族"), 
    $41     ("41"   , "塔吉克族"), 
    $42     ("42"   , "怒族"), 
    $43     ("43"   , "乌孜别克族"), 
    $44     ("44"   , "俄罗斯族"), 
    $45     ("45"   , "鄂温克族"), 
    $46     ("46"   , "崩龙族"), 
    $47     ("47"   , "保安族"), 
    $48     ("48"   , "裕固族"), 
    $49     ("49"   , "京族"), 
    $50     ("50"   , "塔塔尔族"), 
    $51     ("51"   , "独龙族"), 
    $52     ("52"   , "鄂伦春族"), 
    $53     ("53"   , "赫哲族"), 
    $54     ("54"   , "门巴族"), 
    $55     ("55"   , "珞巴族"), 
    $56     ("56"   , "基诺族"), 
    $97     ("97"   , "其他"), 
    $98     ("98"   , "外国血统");

    private String item;
    private String desc;

    private EPNation(String item, String desc) {
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
        return "P_NATION";
    }
}
