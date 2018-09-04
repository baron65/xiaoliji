package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EFileType </p>
 * <p> Description: 文件类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EFileType {
    $TXT    ("TXT"  , "TXT"), 
    $PDF    ("PDF"  , "PDF"), 
    $JPEG   ("JPEG" , "JPEG"), 
    $JPG    ("JPG"  , "JPG"), 
    $PNG    ("PNG"  , "PNG"), 
    $DOC    ("DOC"  , "DOC"), 
    $DOCX   ("DOCX" , "DOCX"), 
    $XLS    ("XLS"  , "XLS"), 
    $XLSX   ("XLSX" , "XLSX");

    private String item;
    private String desc;

    private EFileType(String item, String desc) {
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
        return "FILE_TYPE";
    }
}
