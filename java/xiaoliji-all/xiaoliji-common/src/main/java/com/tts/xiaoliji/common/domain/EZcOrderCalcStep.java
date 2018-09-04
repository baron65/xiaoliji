package com.tts.xiaoliji.common.domain;

/**
 * <p> Title: EZcOrderCalcStep </p>
 * <p> Description: 租车：订单计算阶段 </p>
 * <p> Copyright: jushenghua Copyright (c) 2016 </p>
 * <p> Company: www.jushenghua.com </p>
 *
 * @author auto-generator
 * @since 2018-01-25 15:48:25
 */
public enum EZcOrderCalcStep {
    $SIMULA ("SIMULA", "订单试算"), 
    $CREATE ("CREATE", "创建"), 
    $RELET  ("RELET", "续租"), 
    $SETTLE ("SETTLE", "结算"), 
    $CHANGECAR("CHANGECAR", "换车");

    private String item;
    private String desc;

    private EZcOrderCalcStep(String item, String desc) {
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
        return "ZC_ORDER_CALC_STEP";
    }
}
