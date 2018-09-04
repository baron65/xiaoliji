package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPCultureStandard </p>
 * <p> Description: 个人：文化程度 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPCultureStandard {
    $00     ("00"   , "研究生"), 
    $01     ("01"   , "研究生毕业"), 
    $09     ("09"   , "研究生肄业"), 
    $10     ("10"   , "大学本科（简称大学）"), 
    $11     ("11"   , "大学毕业"), 
    $18     ("18"   , "相当大学毕业"), 
    $19     ("19"   , "大学肄业"), 
    $20     ("20"   , "大学专科和专科学校"), 
    $21     ("21"   , "专科毕业"), 
    $28     ("28"   , "相当专科毕业"), 
    $29     ("29"   , "专科肄业"), 
    $30     ("30"   , "中等专业学校或中等技术学校"), 
    $31     ("31"   , "中专毕业"), 
    $32     ("32"   , "中技毕业"), 
    $38     ("38"   , "相当中专或中技毕业"), 
    $39     ("39"   , "中专或中技肄业"), 
    $40     ("40"   , "技工学校"), 
    $41     ("41"   , "技工学校毕业"), 
    $49     ("49"   , "技工学校肄业"), 
    $50     ("50"   , "高中"), 
    $51     ("51"   , "高中毕业"), 
    $52     ("52"   , "职业高中毕业"), 
    $53     ("53"   , "农业高中毕业"), 
    $58     ("58"   , "相当高中毕业"), 
    $59     ("59"   , "高中肄业"), 
    $60     ("60"   , "初中"), 
    $61     ("61"   , "初中毕业"), 
    $62     ("62"   , "职业初中毕业"), 
    $63     ("63"   , "农业初中毕业"), 
    $68     ("68"   , "相当初中毕业"), 
    $69     ("69"   , "初中肄业"), 
    $70     ("70"   , "小学"), 
    $71     ("71"   , "小学毕业"), 
    $78     ("78"   , "相当小学毕业"), 
    $79     ("79"   , "小学肄业"), 
    $80     ("80"   , "文盲或半文盲");

    private String item;
    private String desc;

    private EPCultureStandard(String item, String desc) {
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
        return "P_CULTURE_STANDARD";
    }
}
