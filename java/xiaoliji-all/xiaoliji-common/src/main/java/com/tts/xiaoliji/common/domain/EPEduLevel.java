package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPEduLevel </p>
 * <p> Description: 个人：学历 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPEduLevel {
    $10     ("10"   , "研究生"), 
    $20     ("20"   , "大学本科"), 
    $30     ("30"   , "大学专科和专科学校"), 
    $40     ("40"   , "中等专业学校或中等技术学校"), 
    $50     ("50"   , "技术学校"), 
    $60     ("60"   , "高中"), 
    $70     ("70"   , "初中"), 
    $80     ("80"   , "小学"), 
    $90     ("90"   , "文盲或半文盲"), 
    $99     ("99"   , "未知");

    private String item;
    private String desc;

    private EPEduLevel(String item, String desc) {
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
        return "P_EDU_LEVEL";
    }
}
