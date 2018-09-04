package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EOrgCharacter </p>
 * <p> Description: 机构：单位性质 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EOrgCharacter {
    $10     ("10"   , "机关"), 
    $20     ("20"   , "科研设计单位"), 
    $21     ("21"   , "高等学校"), 
    $22     ("22"   , "其他教学单位"), 
    $23     ("23"   , "医疗卫生单位"), 
    $25     ("25"   , "艰苦事业单位"), 
    $27     ("27"   , "科研助理"), 
    $29     ("29"   , "其他事业单位"), 
    $31     ("31"   , "国有企业"), 
    $32     ("32"   , "三资企业"), 
    $35     ("35"   , "艰苦行业企业"), 
    $39     ("39"   , "其他企业"), 
    $40     ("40"   , "部队"), 
    $46     ("46"   , "预征入伍"), 
    $50     ("50"   , "国家基层项目"), 
    $51     ("51"   , "地方基层项目"), 
    $55     ("55"   , "农村建制村"), 
    $56     ("56"   , "城镇社区"), 
    $70     ("70"   , "待就业"), 
    $71     ("71"   , "不就业拟升学"), 
    $72     ("72"   , "其他暂不就业"), 
    $75     ("75"   , "自主创业"), 
    $76     ("76"   , "自由职业"), 
    $77     ("77"   , "其他灵活就业"), 
    $80     ("80"   , "升学"), 
    $85     ("85"   , "出国、出境"), 
    $99     ("99"   , "其他");

    private String item;
    private String desc;

    private EOrgCharacter(String item, String desc) {
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
        return "ORG_CHARACTER";
    }
}
