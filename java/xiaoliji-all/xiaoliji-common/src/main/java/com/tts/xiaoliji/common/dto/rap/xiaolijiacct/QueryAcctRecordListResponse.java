package com.tts.xiaoliji.common.dto.rap.xiaolijiacct;

import java.util.List;

import com.tts.xiaoliji.common.dto.rap.common.AcctRecordDTO;

/**
 * <p> Title: QueryAcctRecordListResponse </p>
 * <p> Description: 查询往来记录 xiaoliji-acct.queryAcctRecordList </p>
 * <p> Copyright: openlo.cn Copyright (C) 2016 </p>
 *
 * @author auto-generator
 * @since 2018-01-26 17:54:04
 */
public class QueryAcctRecordListResponse extends com.tts.xiaoliji.common.dto.rap.ResponseBaseDTO {

    // 往来记录#acctRecord#+
    private List<AcctRecordDTO> acctRecordList;

    // 收礼总金额
    private String              totalAmountIn;

    // 送礼总金额
    private String              totalAmountOut;

    // 结果总数
    private String              totalCount;

    public List<AcctRecordDTO> getAcctRecordList() {
        return acctRecordList;
    }

    public void setAcctRecordList(List<AcctRecordDTO> acctRecordList) {
        this.acctRecordList = acctRecordList;
    }

    public String getTotalAmountIn() {
        return totalAmountIn;
    }

    public void setTotalAmountIn(String totalAmountIn) {
        this.totalAmountIn = totalAmountIn;
    }

    public String getTotalAmountOut() {
        return totalAmountOut;
    }

    public void setTotalAmountOut(String totalAmountOut) {
        this.totalAmountOut = totalAmountOut;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

}
