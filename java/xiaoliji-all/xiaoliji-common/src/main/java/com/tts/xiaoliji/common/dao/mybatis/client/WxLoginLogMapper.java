package com.tts.xiaoliji.common.dao.mybatis.client;

import cn.openlo.dataobject.DAO;
import com.tts.xiaoliji.common.dao.mybatis.dto.WxLoginLog;
import com.tts.xiaoliji.common.dao.mybatis.dto.WxLoginLogCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WxLoginLogMapper extends DAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_login_log
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int countByExample(WxLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_login_log
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int deleteByExample(WxLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_login_log
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int deleteByPrimaryKey(String recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_login_log
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int insert(WxLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_login_log
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int insertSelective(WxLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_login_log
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    List<WxLoginLog> selectByExample(WxLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_login_log
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    WxLoginLog selectByPrimaryKey(String recordId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_login_log
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int updateByExampleSelective(@Param("record") WxLoginLog record, @Param("example") WxLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_login_log
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int updateByExample(@Param("record") WxLoginLog record, @Param("example") WxLoginLogCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_login_log
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int updateByPrimaryKeySelective(WxLoginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wx_login_log
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int updateByPrimaryKey(WxLoginLog record);
}