package com.tts.xiaoliji.common.service;

import java.util.List;

import com.tts.xiaoliji.common.bean.DomainValue;

public interface DomainService {

    String getText(String code, String value, String language) throws Exception;

    List<DomainValue> getValues(String code, String language) throws Exception;
}
