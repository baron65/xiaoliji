package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPOccupation </p>
 * <p> Description: 个人：职业 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPOccupation {
    $0      ("0"    , "国家机关、党群组织、企业、事业单位负责人"), 
    $1      ("1"    , "专业技术人员"), 
    $3      ("3"    , "办事人员和有关人员"), 
    $4      ("4"    , "商业、服务业人员"), 
    $5      ("5"    , "农、林、牧、渔、水利业生产人员"), 
    $6      ("6"    , "生产、运输设备操作人员及有关人员"), 
    $X      ("X"    , "军人"), 
    $Y      ("Y"    , "不便分类的其他从业人员"), 
    $Z      ("Z"    , "未知");

    private String item;
    private String desc;

    private EPOccupation(String item, String desc) {
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
        return "P_OCCUPATION";
    }
}
