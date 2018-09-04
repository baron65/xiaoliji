package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssTagScene </p>
 * <p> Description: 财富销售：标签使用场景 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssTagScene {
    $PRD_SHELF("PRD_SHELF", "产品上架");

    private String item;
    private String desc;

    private EWssTagScene(String item, String desc) {
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
        return "WSS_TAG_SCENE";
    }
}
