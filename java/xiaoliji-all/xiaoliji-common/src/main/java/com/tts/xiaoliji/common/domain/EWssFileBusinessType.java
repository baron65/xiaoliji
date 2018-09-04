package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EWssFileBusinessType </p>
 * <p> Description: 财富销售：文件业务类型 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:26
 */
public enum EWssFileBusinessType {
    $SUBSCRIPTION_APPLY("SUBSCRIPTION_APPLY", "认申购意向书"), 
    $PRODUCTTRANSFORM_APPLY("PRODUCTTRANSFORM_APPLY", "产品转换申请书"), 
    $REDEEM_APPLY("REDEEM_APPLY", "赎回申请书"), 
    $CUSTINFOCHANGE_APPLY("CUSTINFOCHANGE_APPLY", "信息变更申请书"), 
    $SUBSCRIPTION_CONFIRM("SUBSCRIPTION_CONFIRM", "认申购确认书"), 
    $PRODUCTTRANSFORM_CONFIRM("PRODUCTTRANSFORM_CONFIRM", "产品转换确认书"), 
    $REDEEM_CONFIRM("REDEEM_CONFIRM", "赎回确认书"), 
    $CUSTINFOCHANGE_CONFIRM("CUSTINFOCHANGE_CONFIRM", "信息变更确认书");

    private String item;
    private String desc;

    private EWssFileBusinessType(String item, String desc) {
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
        return "WSS_FILE_BUSINESS_TYPE";
    }
}
