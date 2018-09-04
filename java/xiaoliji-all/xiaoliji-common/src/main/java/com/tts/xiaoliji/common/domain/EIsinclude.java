package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EIsinclude </p>
 * <p> Description: 是否包含当天 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EIsinclude {
    $I      ("I"    , "包含"), 
    $E      ("E"    , "不包含");

    private String item;
    private String desc;

    private EIsinclude(String item, String desc) {
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
        return "ISINCLUDE";
    }
}
