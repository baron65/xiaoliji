package com.tts.xiaoliji.common.dao.mybatis.dto;

import cn.openlo.gear.dataobject.PersistentDTOSupport;
import java.io.Serializable;

public class CustCProject extends PersistentDTOSupport implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cust_c_project.PROJECT_ID
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String projectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cust_c_project.CUST_NO
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String custNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cust_c_project.PROJECT_NAME
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String projectName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cust_c_project.DATE_FROM
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String dateFrom;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cust_c_project.DATE_TO
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String dateTo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cust_c_project.REMARK
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cust_c_project.PROJECT_ID
     *
     * @return the value of cust_c_project.PROJECT_ID
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cust_c_project.PROJECT_ID
     *
     * @param projectId the value for cust_c_project.PROJECT_ID
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cust_c_project.CUST_NO
     *
     * @return the value of cust_c_project.CUST_NO
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getCustNo() {
        return custNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cust_c_project.CUST_NO
     *
     * @param custNo the value for cust_c_project.CUST_NO
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cust_c_project.PROJECT_NAME
     *
     * @return the value of cust_c_project.PROJECT_NAME
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cust_c_project.PROJECT_NAME
     *
     * @param projectName the value for cust_c_project.PROJECT_NAME
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cust_c_project.DATE_FROM
     *
     * @return the value of cust_c_project.DATE_FROM
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getDateFrom() {
        return dateFrom;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cust_c_project.DATE_FROM
     *
     * @param dateFrom the value for cust_c_project.DATE_FROM
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom == null ? null : dateFrom.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cust_c_project.DATE_TO
     *
     * @return the value of cust_c_project.DATE_TO
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getDateTo() {
        return dateTo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cust_c_project.DATE_TO
     *
     * @param dateTo the value for cust_c_project.DATE_TO
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setDateTo(String dateTo) {
        this.dateTo = dateTo == null ? null : dateTo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cust_c_project.REMARK
     *
     * @return the value of cust_c_project.REMARK
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cust_c_project.REMARK
     *
     * @param remark the value for cust_c_project.REMARK
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_project
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectId=").append(projectId);
        sb.append(", custNo=").append(custNo);
        sb.append(", projectName=").append(projectName);
        sb.append(", dateFrom=").append(dateFrom);
        sb.append(", dateTo=").append(dateTo);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}