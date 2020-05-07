package com.phd.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SchoolAttendanceDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchoolAttendanceDetailsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andSadidIsNull() {
            addCriterion("sadid is null");
            return (Criteria) this;
        }

        public Criteria andSadidIsNotNull() {
            addCriterion("sadid is not null");
            return (Criteria) this;
        }

        public Criteria andSadidEqualTo(Integer value) {
            addCriterion("sadid =", value, "sadid");
            return (Criteria) this;
        }

        public Criteria andSadidNotEqualTo(Integer value) {
            addCriterion("sadid <>", value, "sadid");
            return (Criteria) this;
        }

        public Criteria andSadidGreaterThan(Integer value) {
            addCriterion("sadid >", value, "sadid");
            return (Criteria) this;
        }

        public Criteria andSadidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sadid >=", value, "sadid");
            return (Criteria) this;
        }

        public Criteria andSadidLessThan(Integer value) {
            addCriterion("sadid <", value, "sadid");
            return (Criteria) this;
        }

        public Criteria andSadidLessThanOrEqualTo(Integer value) {
            addCriterion("sadid <=", value, "sadid");
            return (Criteria) this;
        }

        public Criteria andSadidIn(List<Integer> values) {
            addCriterion("sadid in", values, "sadid");
            return (Criteria) this;
        }

        public Criteria andSadidNotIn(List<Integer> values) {
            addCriterion("sadid not in", values, "sadid");
            return (Criteria) this;
        }

        public Criteria andSadidBetween(Integer value1, Integer value2) {
            addCriterion("sadid between", value1, value2, "sadid");
            return (Criteria) this;
        }

        public Criteria andSadidNotBetween(Integer value1, Integer value2) {
            addCriterion("sadid not between", value1, value2, "sadid");
            return (Criteria) this;
        }

        public Criteria andSaidIsNull() {
            addCriterion("said is null");
            return (Criteria) this;
        }

        public Criteria andSaidIsNotNull() {
            addCriterion("said is not null");
            return (Criteria) this;
        }

        public Criteria andSaidEqualTo(Long value) {
            addCriterion("said =", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotEqualTo(Integer value) {
            addCriterion("said <>", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidGreaterThan(Integer value) {
            addCriterion("said >", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("said >=", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidLessThan(Integer value) {
            addCriterion("said <", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidLessThanOrEqualTo(Integer value) {
            addCriterion("said <=", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidIn(List<Integer> values) {
            addCriterion("said in", values, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotIn(List<Integer> values) {
            addCriterion("said not in", values, "said");
            return (Criteria) this;
        }

        public Criteria andSaidBetween(Integer value1, Integer value2) {
            addCriterion("said between", value1, value2, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotBetween(Integer value1, Integer value2) {
            addCriterion("said not between", value1, value2, "said");
            return (Criteria) this;
        }

        public Criteria andCouidIsNull() {
            addCriterion("couid is null");
            return (Criteria) this;
        }

        public Criteria andCouidIsNotNull() {
            addCriterion("couid is not null");
            return (Criteria) this;
        }

        public Criteria andCouidEqualTo(Integer value) {
            addCriterion("couid =", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidNotEqualTo(Integer value) {
            addCriterion("couid <>", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidGreaterThan(Integer value) {
            addCriterion("couid >", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidGreaterThanOrEqualTo(Integer value) {
            addCriterion("couid >=", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidLessThan(Integer value) {
            addCriterion("couid <", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidLessThanOrEqualTo(Integer value) {
            addCriterion("couid <=", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidIn(List<Integer> values) {
            addCriterion("couid in", values, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidNotIn(List<Integer> values) {
            addCriterion("couid not in", values, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidBetween(Integer value1, Integer value2) {
            addCriterion("couid between", value1, value2, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidNotBetween(Integer value1, Integer value2) {
            addCriterion("couid not between", value1, value2, "couid");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSadstatusIsNull() {
            addCriterion("sadstatus is null");
            return (Criteria) this;
        }

        public Criteria andSadstatusIsNotNull() {
            addCriterion("sadstatus is not null");
            return (Criteria) this;
        }

        public Criteria andSadstatusEqualTo(Integer value) {
            addCriterion("sadstatus =", value, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadstatusNotEqualTo(String value) {
            addCriterion("sadstatus <>", value, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadstatusGreaterThan(String value) {
            addCriterion("sadstatus >", value, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadstatusGreaterThanOrEqualTo(String value) {
            addCriterion("sadstatus >=", value, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadstatusLessThan(String value) {
            addCriterion("sadstatus <", value, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadstatusLessThanOrEqualTo(String value) {
            addCriterion("sadstatus <=", value, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadstatusLike(String value) {
            addCriterion("sadstatus like", value, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadstatusNotLike(String value) {
            addCriterion("sadstatus not like", value, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadstatusIn(List<String> values) {
            addCriterion("sadstatus in", values, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadstatusNotIn(List<String> values) {
            addCriterion("sadstatus not in", values, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadstatusBetween(String value1, String value2) {
            addCriterion("sadstatus between", value1, value2, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadstatusNotBetween(String value1, String value2) {
            addCriterion("sadstatus not between", value1, value2, "sadstatus");
            return (Criteria) this;
        }

        public Criteria andSadtimeIsNull() {
            addCriterion("sadtime is null");
            return (Criteria) this;
        }

        public Criteria andSadtimeIsNotNull() {
            addCriterion("sadtime is not null");
            return (Criteria) this;
        }

        public Criteria andSadtimeEqualTo(Date value) {
            addCriterionForJDBCDate("sadtime =", value, "sadtime");
            return (Criteria) this;
        }

        public Criteria andSadtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("sadtime <>", value, "sadtime");
            return (Criteria) this;
        }

        public Criteria andSadtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("sadtime >", value, "sadtime");
            return (Criteria) this;
        }

        public Criteria andSadtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sadtime >=", value, "sadtime");
            return (Criteria) this;
        }

        public Criteria andSadtimeLessThan(Date value) {
            addCriterionForJDBCDate("sadtime <", value, "sadtime");
            return (Criteria) this;
        }

        public Criteria andSadtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("sadtime <=", value, "sadtime");
            return (Criteria) this;
        }

        public Criteria andSadtimeIn(List<Date> values) {
            addCriterionForJDBCDate("sadtime in", values, "sadtime");
            return (Criteria) this;
        }

        public Criteria andSadtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("sadtime not in", values, "sadtime");
            return (Criteria) this;
        }

        public Criteria andSadtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sadtime between", value1, value2, "sadtime");
            return (Criteria) this;
        }

        public Criteria andSadtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("sadtime not between", value1, value2, "sadtime");
            return (Criteria) this;
        }

        public Criteria andSadaddressIsNull() {
            addCriterion("sadaddress is null");
            return (Criteria) this;
        }

        public Criteria andSadaddressIsNotNull() {
            addCriterion("sadaddress is not null");
            return (Criteria) this;
        }

        public Criteria andSadaddressEqualTo(String value) {
            addCriterion("sadaddress =", value, "sadaddress");
            return (Criteria) this;
        }

        public Criteria andSadaddressNotEqualTo(String value) {
            addCriterion("sadaddress <>", value, "sadaddress");
            return (Criteria) this;
        }

        public Criteria andSadaddressGreaterThan(String value) {
            addCriterion("sadaddress >", value, "sadaddress");
            return (Criteria) this;
        }

        public Criteria andSadaddressGreaterThanOrEqualTo(String value) {
            addCriterion("sadaddress >=", value, "sadaddress");
            return (Criteria) this;
        }

        public Criteria andSadaddressLessThan(String value) {
            addCriterion("sadaddress <", value, "sadaddress");
            return (Criteria) this;
        }

        public Criteria andSadaddressLessThanOrEqualTo(String value) {
            addCriterion("sadaddress <=", value, "sadaddress");
            return (Criteria) this;
        }

        public Criteria andSadaddressLike(String value) {
            addCriterion("sadaddress like", value, "sadaddress");
            return (Criteria) this;
        }

        public Criteria andSadaddressNotLike(String value) {
            addCriterion("sadaddress not like", value, "sadaddress");
            return (Criteria) this;
        }

        public Criteria andSadaddressIn(List<String> values) {
            addCriterion("sadaddress in", values, "sadaddress");
            return (Criteria) this;
        }

        public Criteria andSadaddressNotIn(List<String> values) {
            addCriterion("sadaddress not in", values, "sadaddress");
            return (Criteria) this;
        }

        public Criteria andSadaddressBetween(String value1, String value2) {
            addCriterion("sadaddress between", value1, value2, "sadaddress");
            return (Criteria) this;
        }

        public Criteria andSadaddressNotBetween(String value1, String value2) {
            addCriterion("sadaddress not between", value1, value2, "sadaddress");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
}