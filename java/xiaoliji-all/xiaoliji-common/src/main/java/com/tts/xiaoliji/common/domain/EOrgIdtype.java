package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EOrgIdtype </p>
 * <p> Description: 机构：证件类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EOrgIdtype {
    $A      ("A"    , "组织机构代码证"), 
    $B      ("B"    , "营业执照"), 
    $C      ("C"    , "行政机关"), 
    $D      ("D"    , "社会团体"), 
    $E      ("E"    , "军队"), 
    $F      ("F"    , "武警"), 
    $G      ("G"    , "下属机构（具有主管单位批文号）"), 
    $H      ("H"    , "基金会"), 
    $I      ("I"    , "其它"), 
    $K      ("K"    , "其它-内部产品");

    private String item;
    private String desc;

    private EOrgIdtype(String item, String desc) {
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
        return "ORG_IDTYPE";
    }
}
