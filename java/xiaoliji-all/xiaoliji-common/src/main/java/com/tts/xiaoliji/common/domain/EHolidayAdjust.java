package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EHolidayAdjust </p>
 * <p> Description: 节假日顺延方式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EHolidayAdjust {
    $H0     ("H0"   , "不顺延"), 
    $H1     ("H1"   , "向后顺延到下一个工作日"), 
    $H2     ("H2"   , "向前顺延到上一个工作日");

    private String item;
    private String desc;

    private EHolidayAdjust(String item, String desc) {
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
        return "HOLIDAY_ADJUST";
    }
}
