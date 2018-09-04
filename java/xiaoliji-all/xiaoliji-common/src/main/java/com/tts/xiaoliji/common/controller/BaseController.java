package com.tts.xiaoliji.common.controller;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import cn.openlo.common.util.DateUtil;
import cn.openlo.exception.DateFormatException;

public class BaseController {

    protected String toUiDate(Date serviceDate) throws DateFormatException {
        if (null == serviceDate) {
            return null;
        }

        return DateUtil.printCompactDate(serviceDate);
    }

    protected String toUiDatetime(Date serviceDate) throws DateFormatException {
        if (null == serviceDate) {
            return null;
        }

        return DateUtil.printCompactDateTime(serviceDate);
    }

    protected String toUiAmount(BigDecimal amount) {
        if (null == amount) {
            return null;
        }

        return amount.toPlainString();

    }

    protected BigDecimal toServiceAmount(String amount) {
        if (StringUtils.isEmpty(amount)) {
            return null;
        }
        return new BigDecimal(amount);
    }

    protected Date toServiceDatetime(Long ui) {
        if (null == ui) {
            return null;
        }
        if (0 == ui) {
            return null;
        }

        Date service = new Date(ui);
        return service;
    }

    protected Date toServiceDatetime(String ui) throws DateFormatException {
        if (StringUtils.isEmpty(ui)) {
            return null;
        }
        Date service = DateUtil.parseCompactDateTime(ui);
        return service;
    }

    protected Date toServiceDate(String ui) throws DateFormatException {
        if (StringUtils.isEmpty(ui)) {
            return null;
        }
        Date service = DateUtil.parseCompactDate(ui);
        return service;
    }
}