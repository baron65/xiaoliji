package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EIndustry </p>
 * <p> Description: 行业 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EIndustry {
    $A      ("A"    , "农、林、牧、渔业"), 
    $B      ("B"    , "采掘业"), 
    $C      ("C"    , "制造业"), 
    $D      ("D"    , "电力、燃气及水的生产和供应业"), 
    $E      ("E"    , "建筑业"), 
    $F      ("F"    , "交通运输、仓储和邮政业"), 
    $G      ("G"    , "信息传输、计算机服务和软件业"), 
    $H      ("H"    , "批发和零售业"), 
    $I      ("I"    , "住宿和餐饮业"), 
    $J      ("J"    , "金融业"), 
    $K      ("K"    , "房地产业"), 
    $L      ("L"    , "租赁和商务服务业"), 
    $M      ("M"    , "科学研究、技术服务业和地质勘察业"), 
    $N      ("N"    , "水利、环境和公共设施管理业"), 
    $O      ("O"    , "居民服务和其他服务业"), 
    $P      ("P"    , "教育"), 
    $Q      ("Q"    , "卫生、社会保障和社会福利业"), 
    $R      ("R"    , "文化、体育和娱乐业"), 
    $S      ("S"    , "公共管理和社会组织"), 
    $T      ("T"    , "国际组织"), 
    $Z      ("Z"    , "未知");

    private String item;
    private String desc;

    private EIndustry(String item, String desc) {
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
        return "INDUSTRY";
    }
}
