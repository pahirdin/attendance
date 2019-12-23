package com.phd.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LeaveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LeaveExample() {
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

        public Criteria andLidIsNull() {
            addCriterion("lid is null");
            return (Criteria) this;
        }

        public Criteria andLidIsNotNull() {
            addCriterion("lid is not null");
            return (Criteria) this;
        }

        public Criteria andLidEqualTo(Integer value) {
            addCriterion("lid =", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotEqualTo(Integer value) {
            addCriterion("lid <>", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThan(Integer value) {
            addCriterion("lid >", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lid >=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThan(Integer value) {
            addCriterion("lid <", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThanOrEqualTo(Integer value) {
            addCriterion("lid <=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidIn(List<Integer> values) {
            addCriterion("lid in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotIn(List<Integer> values) {
            addCriterion("lid not in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidBetween(Integer value1, Integer value2) {
            addCriterion("lid between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotBetween(Integer value1, Integer value2) {
            addCriterion("lid not between", value1, value2, "lid");
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

        public Criteria andLstimeIsNull() {
            addCriterion("lstime is null");
            return (Criteria) this;
        }

        public Criteria andLstimeIsNotNull() {
            addCriterion("lstime is not null");
            return (Criteria) this;
        }

        public Criteria andLstimeEqualTo(Date value) {
            addCriterionForJDBCDate("lstime =", value, "lstime");
            return (Criteria) this;
        }

        public Criteria andLstimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("lstime <>", value, "lstime");
            return (Criteria) this;
        }

        public Criteria andLstimeGreaterThan(Date value) {
            addCriterionForJDBCDate("lstime >", value, "lstime");
            return (Criteria) this;
        }

        public Criteria andLstimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lstime >=", value, "lstime");
            return (Criteria) this;
        }

        public Criteria andLstimeLessThan(Date value) {
            addCriterionForJDBCDate("lstime <", value, "lstime");
            return (Criteria) this;
        }

        public Criteria andLstimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("lstime <=", value, "lstime");
            return (Criteria) this;
        }

        public Criteria andLstimeIn(List<Date> values) {
            addCriterionForJDBCDate("lstime in", values, "lstime");
            return (Criteria) this;
        }

        public Criteria andLstimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("lstime not in", values, "lstime");
            return (Criteria) this;
        }

        public Criteria andLstimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lstime between", value1, value2, "lstime");
            return (Criteria) this;
        }

        public Criteria andLstimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("lstime not between", value1, value2, "lstime");
            return (Criteria) this;
        }

        public Criteria andLetimeIsNull() {
            addCriterion("letime is null");
            return (Criteria) this;
        }

        public Criteria andLetimeIsNotNull() {
            addCriterion("letime is not null");
            return (Criteria) this;
        }

        public Criteria andLetimeEqualTo(Date value) {
            addCriterionForJDBCDate("letime =", value, "letime");
            return (Criteria) this;
        }

        public Criteria andLetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("letime <>", value, "letime");
            return (Criteria) this;
        }

        public Criteria andLetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("letime >", value, "letime");
            return (Criteria) this;
        }

        public Criteria andLetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("letime >=", value, "letime");
            return (Criteria) this;
        }

        public Criteria andLetimeLessThan(Date value) {
            addCriterionForJDBCDate("letime <", value, "letime");
            return (Criteria) this;
        }

        public Criteria andLetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("letime <=", value, "letime");
            return (Criteria) this;
        }

        public Criteria andLetimeIn(List<Date> values) {
            addCriterionForJDBCDate("letime in", values, "letime");
            return (Criteria) this;
        }

        public Criteria andLetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("letime not in", values, "letime");
            return (Criteria) this;
        }

        public Criteria andLetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("letime between", value1, value2, "letime");
            return (Criteria) this;
        }

        public Criteria andLetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("letime not between", value1, value2, "letime");
            return (Criteria) this;
        }

        public Criteria andLtypeIsNull() {
            addCriterion("ltype is null");
            return (Criteria) this;
        }

        public Criteria andLtypeIsNotNull() {
            addCriterion("ltype is not null");
            return (Criteria) this;
        }

        public Criteria andLtypeEqualTo(String value) {
            addCriterion("ltype =", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotEqualTo(String value) {
            addCriterion("ltype <>", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeGreaterThan(String value) {
            addCriterion("ltype >", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeGreaterThanOrEqualTo(String value) {
            addCriterion("ltype >=", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLessThan(String value) {
            addCriterion("ltype <", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLessThanOrEqualTo(String value) {
            addCriterion("ltype <=", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeLike(String value) {
            addCriterion("ltype like", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotLike(String value) {
            addCriterion("ltype not like", value, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeIn(List<String> values) {
            addCriterion("ltype in", values, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotIn(List<String> values) {
            addCriterion("ltype not in", values, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeBetween(String value1, String value2) {
            addCriterion("ltype between", value1, value2, "ltype");
            return (Criteria) this;
        }

        public Criteria andLtypeNotBetween(String value1, String value2) {
            addCriterion("ltype not between", value1, value2, "ltype");
            return (Criteria) this;
        }

        public Criteria andLcontentIsNull() {
            addCriterion("lcontent is null");
            return (Criteria) this;
        }

        public Criteria andLcontentIsNotNull() {
            addCriterion("lcontent is not null");
            return (Criteria) this;
        }

        public Criteria andLcontentEqualTo(String value) {
            addCriterion("lcontent =", value, "lcontent");
            return (Criteria) this;
        }

        public Criteria andLcontentNotEqualTo(String value) {
            addCriterion("lcontent <>", value, "lcontent");
            return (Criteria) this;
        }

        public Criteria andLcontentGreaterThan(String value) {
            addCriterion("lcontent >", value, "lcontent");
            return (Criteria) this;
        }

        public Criteria andLcontentGreaterThanOrEqualTo(String value) {
            addCriterion("lcontent >=", value, "lcontent");
            return (Criteria) this;
        }

        public Criteria andLcontentLessThan(String value) {
            addCriterion("lcontent <", value, "lcontent");
            return (Criteria) this;
        }

        public Criteria andLcontentLessThanOrEqualTo(String value) {
            addCriterion("lcontent <=", value, "lcontent");
            return (Criteria) this;
        }

        public Criteria andLcontentLike(String value) {
            addCriterion("lcontent like", value, "lcontent");
            return (Criteria) this;
        }

        public Criteria andLcontentNotLike(String value) {
            addCriterion("lcontent not like", value, "lcontent");
            return (Criteria) this;
        }

        public Criteria andLcontentIn(List<String> values) {
            addCriterion("lcontent in", values, "lcontent");
            return (Criteria) this;
        }

        public Criteria andLcontentNotIn(List<String> values) {
            addCriterion("lcontent not in", values, "lcontent");
            return (Criteria) this;
        }

        public Criteria andLcontentBetween(String value1, String value2) {
            addCriterion("lcontent between", value1, value2, "lcontent");
            return (Criteria) this;
        }

        public Criteria andLcontentNotBetween(String value1, String value2) {
            addCriterion("lcontent not between", value1, value2, "lcontent");
            return (Criteria) this;
        }

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(Integer value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(Integer value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(Integer value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(Integer value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(Integer value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(Integer value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<Integer> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<Integer> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(Integer value1, Integer value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(Integer value1, Integer value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andLstatusIsNull() {
            addCriterion("lstatus is null");
            return (Criteria) this;
        }

        public Criteria andLstatusIsNotNull() {
            addCriterion("lstatus is not null");
            return (Criteria) this;
        }

        public Criteria andLstatusEqualTo(String value) {
            addCriterion("lstatus =", value, "lstatus");
            return (Criteria) this;
        }

        public Criteria andLstatusNotEqualTo(String value) {
            addCriterion("lstatus <>", value, "lstatus");
            return (Criteria) this;
        }

        public Criteria andLstatusGreaterThan(String value) {
            addCriterion("lstatus >", value, "lstatus");
            return (Criteria) this;
        }

        public Criteria andLstatusGreaterThanOrEqualTo(String value) {
            addCriterion("lstatus >=", value, "lstatus");
            return (Criteria) this;
        }

        public Criteria andLstatusLessThan(String value) {
            addCriterion("lstatus <", value, "lstatus");
            return (Criteria) this;
        }

        public Criteria andLstatusLessThanOrEqualTo(String value) {
            addCriterion("lstatus <=", value, "lstatus");
            return (Criteria) this;
        }

        public Criteria andLstatusLike(String value) {
            addCriterion("lstatus like", value, "lstatus");
            return (Criteria) this;
        }

        public Criteria andLstatusNotLike(String value) {
            addCriterion("lstatus not like", value, "lstatus");
            return (Criteria) this;
        }

        public Criteria andLstatusIn(List<String> values) {
            addCriterion("lstatus in", values, "lstatus");
            return (Criteria) this;
        }

        public Criteria andLstatusNotIn(List<String> values) {
            addCriterion("lstatus not in", values, "lstatus");
            return (Criteria) this;
        }

        public Criteria andLstatusBetween(String value1, String value2) {
            addCriterion("lstatus between", value1, value2, "lstatus");
            return (Criteria) this;
        }

        public Criteria andLstatusNotBetween(String value1, String value2) {
            addCriterion("lstatus not between", value1, value2, "lstatus");
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