package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: ETestSubobjectType </p>
 * <p> Description: 考试：试卷关联对象的类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum ETestSubobjectType {
    $G      ("G"    , "试题组"), 
    $Q      ("Q"    , "试题");

    private String item;
    private String desc;

    private ETestSubobjectType(String item, String desc) {
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
        return "TEST_SUBOBJECT_TYPE";
    }
}
