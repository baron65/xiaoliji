package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EIsMandatory </p>
 * <p> Description: 是否必须 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EIsMandatory {
    $Y      ("Y"    , "必须"), 
    $N      ("N"    , "非必须"), 
    $C      ("C"    , "有条件必须");

    private String item;
    private String desc;

    private EIsMandatory(String item, String desc) {
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
        return "IS_MANDATORY";
    }
}
