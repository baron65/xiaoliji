package com.tts.xiaoliji.common.dao.mybatis.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustCTagFriendCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    protected List<Criteria> oredCriteria;

    protected Integer limit;

    protected Integer offset;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public CustCTagFriendCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public BoundBuilder boundBuilder() {
        return new BoundBuilder();
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andTagIdIsNull() {
            addCriterion("TAG_ID is null");
            return (Criteria) this;
        }

        public Criteria andTagIdIsNotNull() {
            addCriterion("TAG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTagIdEqualTo(String value) {
            addCriterion("TAG_ID =", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotEqualTo(String value) {
            addCriterion("TAG_ID <>", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThan(String value) {
            addCriterion("TAG_ID >", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdGreaterThanOrEqualTo(String value) {
            addCriterion("TAG_ID >=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThan(String value) {
            addCriterion("TAG_ID <", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLessThanOrEqualTo(String value) {
            addCriterion("TAG_ID <=", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdLike(String value) {
            addCriterion("TAG_ID like", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotLike(String value) {
            addCriterion("TAG_ID not like", value, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdIn(List<String> values) {
            addCriterion("TAG_ID in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotIn(List<String> values) {
            addCriterion("TAG_ID not in", values, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdBetween(String value1, String value2) {
            addCriterion("TAG_ID between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagIdNotBetween(String value1, String value2) {
            addCriterion("TAG_ID not between", value1, value2, "tagId");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNull() {
            addCriterion("TAG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNotNull() {
            addCriterion("TAG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTagNameEqualTo(String value) {
            addCriterion("TAG_NAME =", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotEqualTo(String value) {
            addCriterion("TAG_NAME <>", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThan(String value) {
            addCriterion("TAG_NAME >", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("TAG_NAME >=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThan(String value) {
            addCriterion("TAG_NAME <", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThanOrEqualTo(String value) {
            addCriterion("TAG_NAME <=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLike(String value) {
            addCriterion("TAG_NAME like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotLike(String value) {
            addCriterion("TAG_NAME not like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameIn(List<String> values) {
            addCriterion("TAG_NAME in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotIn(List<String> values) {
            addCriterion("TAG_NAME not in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameBetween(String value1, String value2) {
            addCriterion("TAG_NAME between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotBetween(String value1, String value2) {
            addCriterion("TAG_NAME not between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andCustNoIsNull() {
            addCriterion("CUST_NO is null");
            return (Criteria) this;
        }

        public Criteria andCustNoIsNotNull() {
            addCriterion("CUST_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCustNoEqualTo(String value) {
            addCriterion("CUST_NO =", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotEqualTo(String value) {
            addCriterion("CUST_NO <>", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoGreaterThan(String value) {
            addCriterion("CUST_NO >", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoGreaterThanOrEqualTo(String value) {
            addCriterion("CUST_NO >=", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLessThan(String value) {
            addCriterion("CUST_NO <", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLessThanOrEqualTo(String value) {
            addCriterion("CUST_NO <=", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoLike(String value) {
            addCriterion("CUST_NO like", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotLike(String value) {
            addCriterion("CUST_NO not like", value, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoIn(List<String> values) {
            addCriterion("CUST_NO in", values, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotIn(List<String> values) {
            addCriterion("CUST_NO not in", values, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoBetween(String value1, String value2) {
            addCriterion("CUST_NO between", value1, value2, "custNo");
            return (Criteria) this;
        }

        public Criteria andCustNoNotBetween(String value1, String value2) {
            addCriterion("CUST_NO not between", value1, value2, "custNo");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIsNull() {
            addCriterion("DATE_CREATED is null");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIsNotNull() {
            addCriterion("DATE_CREATED is not null");
            return (Criteria) this;
        }

        public Criteria andDateCreatedEqualTo(Date value) {
            addCriterion("DATE_CREATED =", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotEqualTo(Date value) {
            addCriterion("DATE_CREATED <>", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedGreaterThan(Date value) {
            addCriterion("DATE_CREATED >", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("DATE_CREATED >=", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedLessThan(Date value) {
            addCriterion("DATE_CREATED <", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedLessThanOrEqualTo(Date value) {
            addCriterion("DATE_CREATED <=", value, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedIn(List<Date> values) {
            addCriterion("DATE_CREATED in", values, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotIn(List<Date> values) {
            addCriterion("DATE_CREATED not in", values, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedBetween(Date value1, Date value2) {
            addCriterion("DATE_CREATED between", value1, value2, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateCreatedNotBetween(Date value1, Date value2) {
            addCriterion("DATE_CREATED not between", value1, value2, "dateCreated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedIsNull() {
            addCriterion("DATE_UPDATED is null");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedIsNotNull() {
            addCriterion("DATE_UPDATED is not null");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedEqualTo(Date value) {
            addCriterion("DATE_UPDATED =", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedNotEqualTo(Date value) {
            addCriterion("DATE_UPDATED <>", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedGreaterThan(Date value) {
            addCriterion("DATE_UPDATED >", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("DATE_UPDATED >=", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedLessThan(Date value) {
            addCriterion("DATE_UPDATED <", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("DATE_UPDATED <=", value, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedIn(List<Date> values) {
            addCriterion("DATE_UPDATED in", values, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedNotIn(List<Date> values) {
            addCriterion("DATE_UPDATED not in", values, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedBetween(Date value1, Date value2) {
            addCriterion("DATE_UPDATED between", value1, value2, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andDateUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("DATE_UPDATED not between", value1, value2, "dateUpdated");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("CREATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("CREATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("CREATED_BY =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("CREATED_BY <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("CREATED_BY >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_BY >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("CREATED_BY <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("CREATED_BY <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("CREATED_BY like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("CREATED_BY not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("CREATED_BY in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("CREATED_BY not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("CREATED_BY between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("CREATED_BY not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("UPDATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("UPDATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(String value) {
            addCriterion("UPDATED_BY =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(String value) {
            addCriterion("UPDATED_BY <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(String value) {
            addCriterion("UPDATED_BY >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATED_BY >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(String value) {
            addCriterion("UPDATED_BY <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("UPDATED_BY <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLike(String value) {
            addCriterion("UPDATED_BY like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotLike(String value) {
            addCriterion("UPDATED_BY not like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<String> values) {
            addCriterion("UPDATED_BY in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<String> values) {
            addCriterion("UPDATED_BY not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(String value1, String value2) {
            addCriterion("UPDATED_BY between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(String value1, String value2) {
            addCriterion("UPDATED_BY not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated do_not_delete_during_merge Fri Jan 26 17:54:01 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table cust_c_tag_friend
     *
     * @mbggenerated Fri Jan 26 17:54:01 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }

    public class BoundBuilder {
        protected Integer limit;

        protected Integer offset;

        public Integer limit() {
            return this.limit;
        }

        public BoundBuilder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Integer offset() {
            return this.offset;
        }

        public BoundBuilder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public CustCTagFriendCriteria build() {
            CustCTagFriendCriteria.this.limit = limit;
            CustCTagFriendCriteria.this.offset = offset;
            return CustCTagFriendCriteria.this;
        }
    }
}