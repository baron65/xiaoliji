package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EFormulaCode </p>
 * <p> Description: 公式编号 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EFormulaCode {
    $F001   ("F001" , "V1 + V2"), 
    $F002   ("F002" , "(V1 + V2) * (1 + V3)"), 
    $F003   ("F003" , "V1 * (1 + V2 )"), 
    $F004   ("F004" , "V1 * (1 + V2 ) * (1 + V3)");

    private String item;
    private String desc;

    private EFormulaCode(String item, String desc) {
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
        return "FORMULA_CODE";
    }
}
