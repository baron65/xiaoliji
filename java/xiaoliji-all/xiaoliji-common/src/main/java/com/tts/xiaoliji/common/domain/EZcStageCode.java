package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EZcStageCode </p>
 * <p> Description: 租车：场景编号 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EZcStageCode {
    $DEFAULT("DEFAULT", "默认场景"), 
    $PORTAL ("PORTAL", "门户网站试算"), 
    $APP    ("APP"  , "手机app试算"), 
    $WX     ("WX"   , "微信端试算"), 
    $XIECHENG("XIECHENG", "携程端试算");

    private String item;
    private String desc;

    private EZcStageCode(String item, String desc) {
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
        return "ZC_STAGE_CODE";
    }
}
