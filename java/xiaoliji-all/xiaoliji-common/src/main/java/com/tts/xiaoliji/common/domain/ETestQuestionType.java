package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ETestQuestionType </p>
 * <p> Description: 考试：试题类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum ETestQuestionType {
    $CHOICE ("CHOICE", "选择题"), 
    $CHOICE_S("CHOICE_S", "单选题"), 
    $CHOICE_M("CHOICE_M", "多选题"), 
    $TRUE_FALSE("TRUE_FALSE", "判断题"), 
    $ESSAY  ("ESSAY", "问答题"), 
    $GAPFILL("GAPFILL", "填空题");

    private String item;
    private String desc;

    private ETestQuestionType(String item, String desc) {
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
        return "TEST_QUESTION_TYPE";
    }
}
