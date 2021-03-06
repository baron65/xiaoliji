package com.tts.xiaoliji.common.dao.mybatis.client;

import cn.openlo.dataobject.DAO;
import com.tts.xiaoliji.common.dao.mybatis.dto.CustCProject;
import com.tts.xiaoliji.common.dao.mybatis.dto.CustCProjectCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustCProjectMapper extends DAO {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int countByExample(CustCProjectCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int deleteByExample(CustCProjectCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int deleteByPrimaryKey(String projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int insert(CustCProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int insertSelective(CustCProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    List<CustCProject> selectByExample(CustCProjectCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    CustCProject selectByPrimaryKey(String projectId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int updateByExampleSelective(@Param("record") CustCProject record, @Param("example") CustCProjectCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int updateByExample(@Param("record") CustCProject record, @Param("example") CustCProjectCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int updateByPrimaryKeySelective(CustCProject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    int updateByPrimaryKey(CustCProject record);
}