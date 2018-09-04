package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EIdType </p>
 * <p> Description: 证件类型（个人和机构） </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EIdType {
    $0      ("0"    , "身份证"), 
    $1      ("1"    , "护照"), 
    $2      ("2"    , "军官证"), 
    $3      ("3"    , "士兵证"), 
    $4      ("4"    , "港澳居民来往内地通行证"), 
    $5      ("5"    , "户口簿"), 
    $6      ("6"    , "外国护照"), 
    $7      ("7"    , "其它"), 
    $8      ("8"    , "文职证"), 
    $9      ("9"    , "警官证"), 
    $J      ("J"    , "台湾同胞来往内地通行证"), 
    $A      ("A"    , "组织机构代码证"), 
    $B      ("B"    , "营业执照"), 
    $C      ("C"    , "行政机关"), 
    $D      ("D"    , "社会团体"), 
    $E      ("E"    , "军队"), 
    $F      ("F"    , "武警"), 
    $G      ("G"    , "下属机构（具有主管单位批文号）"), 
    $H      ("H"    , "基金会"), 
    $I      ("I"    , "其它"), 
    $K      ("K"    , "其它-内部产品"), 
    $L      ("L"    , "驾照");

    private String item;
    private String desc;

    private EIdType(String item, String desc) {
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
        return "ID_TYPE";
    }
}
