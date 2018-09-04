package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EUiFieldType </p>
 * <p> Description: 页面字段类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EUiFieldType {
    $STRING ("STRING", "字符串"), 
    $DATE   ("DATE" , "日期"), 
    $TIME   ("TIME" , "时间"), 
    $DATETIME("DATETIME", "日期时间"), 
    $INT    ("INT"  , "整数"), 
    $NUMERIC("NUMERIC", "数值"), 
    $DROPLIST("DROPLIST", "下拉列表"), 
    $RADIO  ("RADIO", "单选框"), 
    $CHECKBOX("CHECKBOX", "复选框"), 
    $TEXTAREA("TEXTAREA", "文本框");

    private String item;
    private String desc;

    private EUiFieldType(String item, String desc) {
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
        return "UI_FIELD_TYPE";
    }
}
