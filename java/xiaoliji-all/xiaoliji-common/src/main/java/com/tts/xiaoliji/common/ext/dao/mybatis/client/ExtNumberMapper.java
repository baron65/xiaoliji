package com.tts.xiaoliji.common.ext.dao.mybatis.client;

import org.apache.ibatis.annotations.Param;

import cn.openlo.dataobject.DAO;

public interface ExtNumberMapper extends DAO {
    /**
     * 获取流水号
     *
     * @param name
     * @param para
     * @return
     */
    Integer getNextNumber(@Param("name") String name, @Param("para") String para);
}