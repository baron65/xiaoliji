package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EPChineseZodiac </p>
 * <p> Description: 个人：生肖 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EPChineseZodiac {
    $RAT    ("RAT"  , "鼠"), 
    $OX     ("OX"   , "牛"), 
    $TIGER  ("TIGER", "虎"), 
    $RABBIT ("RABBIT", "兔"), 
    $DRAGON ("DRAGON", "龙"), 
    $SNAKE  ("SNAKE", "蛇"), 
    $HORSE  ("HORSE", "马"), 
    $GOAT   ("GOAT" , "羊"), 
    $MONEY  ("MONEY", "猴"), 
    $ROOSTER("ROOSTER", "鸡"), 
    $DOG    ("DOG"  , "狗"), 
    $BOAR   ("BOAR" , "猪");

    private String item;
    private String desc;

    private EPChineseZodiac(String item, String desc) {
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
        return "P_CHINESE_ZODIAC";
    }
}
