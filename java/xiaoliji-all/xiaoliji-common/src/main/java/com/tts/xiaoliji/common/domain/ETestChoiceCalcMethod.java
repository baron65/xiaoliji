package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ETestChoiceCalcMethod </p>
 * <p> Description: 考试：选择题计分模式 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum ETestChoiceCalcMethod {
    $RIGHTANSWER("RIGHTANSWER", "正确答案获得试题分"), 
    $CHOICE_ADD("CHOICE_ADD", "选中项的汇总分"), 
    $CHOICE_MAX("CHOICE_MAX", "选中项的最高分"), 
    $CHOICE_MIN("CHOICE_MIN", "选中项的最低分");

    private String item;
    private String desc;

    private ETestChoiceCalcMethod(String item, String desc) {
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
        return "TEST_CHOICE_CALC_METHOD";
    }
}
