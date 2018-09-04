package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EAuthOwnerType </p>
 * <p> Description: 权限：属主类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EAuthOwnerType {
    $STAFF  ("STAFF", "员工"), 
    $STAFFG ("STAFFG", "员工组"), 
    $DEPT   ("DEPT" , "部门"), 
    $DEPTG  ("DEPTG", "部门组"), 
    $ROLE   ("ROLE" , "角色"), 
    $ROLEG  ("ROLEG", "角色组");

    private String item;
    private String desc;

    private EAuthOwnerType(String item, String desc) {
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
        return "AUTH_OWNER_TYPE";
    }
}
