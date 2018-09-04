package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPMaritalState </p>
 * <p> Description: 个人：婚姻状况 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EPMaritalState {
    $10     ("10"   , "未婚"), 
    $20     ("20"   , "已婚"), 
    $21     ("21"   , "初婚"), 
    $22     ("22"   , "再婚"), 
    $23     ("23"   , "复婚"), 
    $30     ("30"   , "丧偶"), 
    $40     ("40"   , "离婚"), 
    $90     ("90"   , "未说明的婚姻状况");

    private String item;
    private String desc;

    private EPMaritalState(String item, String desc) {
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
        return "P_MARITAL_STATE";
    }
}
