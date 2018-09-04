package com.tts.xiaoliji.common.dao.mybatis.dto;

import cn.openlo.gear.dataobject.PersistentDTOSupport;
import java.io.Serializable;
import java.math.BigDecimal;

public class AcctRecord extends PersistentDTOSupport implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column acct_record.ACCT_RECORD_ID
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String acctRecordId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column acct_record.CUST_NO
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String custNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column acct_record.FRIEND_ID
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String friendId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column acct_record.DATE
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column acct_record.AMOUNT
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private BigDecimal amount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column acct_record.FLAG_DELETED
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String flagDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column acct_record.REMARK
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column acct_record.DIRECTION
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private byte[] direction;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table acct_record
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column acct_record.ACCT_RECORD_ID
     *
     * @return the value of acct_record.ACCT_RECORD_ID
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getAcctRecordId() {
        return acctRecordId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column acct_record.ACCT_RECORD_ID
     *
     * @param acctRecordId the value for acct_record.ACCT_RECORD_ID
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setAcctRecordId(String acctRecordId) {
        this.acctRecordId = acctRecordId == null ? null : acctRecordId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column acct_record.CUST_NO
     *
     * @return the value of acct_record.CUST_NO
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getCustNo() {
        return custNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column acct_record.CUST_NO
     *
     * @param custNo the value for acct_record.CUST_NO
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setCustNo(String custNo) {
        this.custNo = custNo == null ? null : custNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column acct_record.FRIEND_ID
     *
     * @return the value of acct_record.FRIEND_ID
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getFriendId() {
        return friendId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column acct_record.FRIEND_ID
     *
     * @param friendId the value for acct_record.FRIEND_ID
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setFriendId(String friendId) {
        this.friendId = friendId == null ? null : friendId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column acct_record.DATE
     *
     * @return the value of acct_record.DATE
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column acct_record.DATE
     *
     * @param date the value for acct_record.DATE
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column acct_record.AMOUNT
     *
     * @return the value of acct_record.AMOUNT
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column acct_record.AMOUNT
     *
     * @param amount the value for acct_record.AMOUNT
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column acct_record.FLAG_DELETED
     *
     * @return the value of acct_record.FLAG_DELETED
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getFlagDeleted() {
        return flagDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column acct_record.FLAG_DELETED
     *
     * @param flagDeleted the value for acct_record.FLAG_DELETED
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setFlagDeleted(String flagDeleted) {
        this.flagDeleted = flagDeleted == null ? null : flagDeleted.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column acct_record.REMARK
     *
     * @return the value of acct_record.REMARK
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column acct_record.REMARK
     *
     * @param remark the value for acct_record.REMARK
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column acct_record.DIRECTION
     *
     * @return the value of acct_record.DIRECTION
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public byte[] getDirection() {
        return direction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column acct_record.DIRECTION
     *
     * @param direction the value for acct_record.DIRECTION
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setDirection(byte[] direction) {
        this.direction = direction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table acct_record
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", acctRecordId=").append(acctRecordId);
        sb.append(", custNo=").append(custNo);
        sb.append(", friendId=").append(friendId);
        sb.append(", date=").append(date);
        sb.append(", amount=").append(amount);
        sb.append(", flagDeleted=").append(flagDeleted);
        sb.append(", remark=").append(remark);
        sb.append(", direction=").append(direction);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}