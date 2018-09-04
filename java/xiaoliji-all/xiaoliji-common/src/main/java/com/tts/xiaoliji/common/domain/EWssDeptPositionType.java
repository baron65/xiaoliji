package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssDeptPositionType </p>
 * <p> Description: 财富销售：部门岗位类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssDeptPositionType {
    $LEADER ("LEADER", "负责人"), 
    $DOC_MANAGER("DOC_MANAGER", "纸质产品合同管理人");

    private String item;
    private String desc;

    private EWssDeptPositionType(String item, String desc) {
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
        return "WSS_DEPT_POSITION_TYPE";
    }
}
