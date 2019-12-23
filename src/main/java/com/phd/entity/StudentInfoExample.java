package com.phd.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentInfoExample() {
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

        public Criteria andSnoIsNull() {
            addCriterion("sno is null");
            return (Criteria) this;
        }

        public Criteria andSnoIsNotNull() {
            addCriterion("sno is not null");
            return (Criteria) this;
        }

        public Criteria andSnoEqualTo(String value) {
            addCriterion("sno =", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotEqualTo(String value) {
            addCriterion("sno <>", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThan(String value) {
            addCriterion("sno >", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoGreaterThanOrEqualTo(String value) {
            addCriterion("sno >=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThan(String value) {
            addCriterion("sno <", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLessThanOrEqualTo(String value) {
            addCriterion("sno <=", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoLike(String value) {
            addCriterion("sno like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotLike(String value) {
            addCriterion("sno not like", value, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoIn(List<String> values) {
            addCriterion("sno in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotIn(List<String> values) {
            addCriterion("sno not in", values, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoBetween(String value1, String value2) {
            addCriterion("sno between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnoNotBetween(String value1, String value2) {
            addCriterion("sno not between", value1, value2, "sno");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("sname not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSpwdIsNull() {
            addCriterion("spwd is null");
            return (Criteria) this;
        }

        public Criteria andSpwdIsNotNull() {
            addCriterion("spwd is not null");
            return (Criteria) this;
        }

        public Criteria andSpwdEqualTo(String value) {
            addCriterion("spwd =", value, "spwd");
            return (Criteria) this;
        }

        public Criteria andSpwdNotEqualTo(String value) {
            addCriterion("spwd <>", value, "spwd");
            return (Criteria) this;
        }

        public Criteria andSpwdGreaterThan(String value) {
            addCriterion("spwd >", value, "spwd");
            return (Criteria) this;
        }

        public Criteria andSpwdGreaterThanOrEqualTo(String value) {
            addCriterion("spwd >=", value, "spwd");
            return (Criteria) this;
        }

        public Criteria andSpwdLessThan(String value) {
            addCriterion("spwd <", value, "spwd");
            return (Criteria) this;
        }

        public Criteria andSpwdLessThanOrEqualTo(String value) {
            addCriterion("spwd <=", value, "spwd");
            return (Criteria) this;
        }

        public Criteria andSpwdLike(String value) {
            addCriterion("spwd like", value, "spwd");
            return (Criteria) this;
        }

        public Criteria andSpwdNotLike(String value) {
            addCriterion("spwd not like", value, "spwd");
            return (Criteria) this;
        }

        public Criteria andSpwdIn(List<String> values) {
            addCriterion("spwd in", values, "spwd");
            return (Criteria) this;
        }

        public Criteria andSpwdNotIn(List<String> values) {
            addCriterion("spwd not in", values, "spwd");
            return (Criteria) this;
        }

        public Criteria andSpwdBetween(String value1, String value2) {
            addCriterion("spwd between", value1, value2, "spwd");
            return (Criteria) this;
        }

        public Criteria andSpwdNotBetween(String value1, String value2) {
            addCriterion("spwd not between", value1, value2, "spwd");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andStelIsNull() {
            addCriterion("stel is null");
            return (Criteria) this;
        }

        public Criteria andStelIsNotNull() {
            addCriterion("stel is not null");
            return (Criteria) this;
        }

        public Criteria andStelEqualTo(String value) {
            addCriterion("stel =", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelNotEqualTo(String value) {
            addCriterion("stel <>", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelGreaterThan(String value) {
            addCriterion("stel >", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelGreaterThanOrEqualTo(String value) {
            addCriterion("stel >=", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelLessThan(String value) {
            addCriterion("stel <", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelLessThanOrEqualTo(String value) {
            addCriterion("stel <=", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelLike(String value) {
            addCriterion("stel like", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelNotLike(String value) {
            addCriterion("stel not like", value, "stel");
            return (Criteria) this;
        }

        public Criteria andStelIn(List<String> values) {
            addCriterion("stel in", values, "stel");
            return (Criteria) this;
        }

        public Criteria andStelNotIn(List<String> values) {
            addCriterion("stel not in", values, "stel");
            return (Criteria) this;
        }

        public Criteria andStelBetween(String value1, String value2) {
            addCriterion("stel between", value1, value2, "stel");
            return (Criteria) this;
        }

        public Criteria andStelNotBetween(String value1, String value2) {
            addCriterion("stel not between", value1, value2, "stel");
            return (Criteria) this;
        }

        public Criteria andSdorIsNull() {
            addCriterion("sdor is null");
            return (Criteria) this;
        }

        public Criteria andSdorIsNotNull() {
            addCriterion("sdor is not null");
            return (Criteria) this;
        }

        public Criteria andSdorEqualTo(String value) {
            addCriterion("sdor =", value, "sdor");
            return (Criteria) this;
        }

        public Criteria andSdorNotEqualTo(String value) {
            addCriterion("sdor <>", value, "sdor");
            return (Criteria) this;
        }

        public Criteria andSdorGreaterThan(String value) {
            addCriterion("sdor >", value, "sdor");
            return (Criteria) this;
        }

        public Criteria andSdorGreaterThanOrEqualTo(String value) {
            addCriterion("sdor >=", value, "sdor");
            return (Criteria) this;
        }

        public Criteria andSdorLessThan(String value) {
            addCriterion("sdor <", value, "sdor");
            return (Criteria) this;
        }

        public Criteria andSdorLessThanOrEqualTo(String value) {
            addCriterion("sdor <=", value, "sdor");
            return (Criteria) this;
        }

        public Criteria andSdorLike(String value) {
            addCriterion("sdor like", value, "sdor");
            return (Criteria) this;
        }

        public Criteria andSdorNotLike(String value) {
            addCriterion("sdor not like", value, "sdor");
            return (Criteria) this;
        }

        public Criteria andSdorIn(List<String> values) {
            addCriterion("sdor in", values, "sdor");
            return (Criteria) this;
        }

        public Criteria andSdorNotIn(List<String> values) {
            addCriterion("sdor not in", values, "sdor");
            return (Criteria) this;
        }

        public Criteria andSdorBetween(String value1, String value2) {
            addCriterion("sdor between", value1, value2, "sdor");
            return (Criteria) this;
        }

        public Criteria andSdorNotBetween(String value1, String value2) {
            addCriterion("sdor not between", value1, value2, "sdor");
            return (Criteria) this;
        }

        public Criteria andSptelIsNull() {
            addCriterion("sptel is null");
            return (Criteria) this;
        }

        public Criteria andSptelIsNotNull() {
            addCriterion("sptel is not null");
            return (Criteria) this;
        }

        public Criteria andSptelEqualTo(String value) {
            addCriterion("sptel =", value, "sptel");
            return (Criteria) this;
        }

        public Criteria andSptelNotEqualTo(String value) {
            addCriterion("sptel <>", value, "sptel");
            return (Criteria) this;
        }

        public Criteria andSptelGreaterThan(String value) {
            addCriterion("sptel >", value, "sptel");
            return (Criteria) this;
        }

        public Criteria andSptelGreaterThanOrEqualTo(String value) {
            addCriterion("sptel >=", value, "sptel");
            return (Criteria) this;
        }

        public Criteria andSptelLessThan(String value) {
            addCriterion("sptel <", value, "sptel");
            return (Criteria) this;
        }

        public Criteria andSptelLessThanOrEqualTo(String value) {
            addCriterion("sptel <=", value, "sptel");
            return (Criteria) this;
        }

        public Criteria andSptelLike(String value) {
            addCriterion("sptel like", value, "sptel");
            return (Criteria) this;
        }

        public Criteria andSptelNotLike(String value) {
            addCriterion("sptel not like", value, "sptel");
            return (Criteria) this;
        }

        public Criteria andSptelIn(List<String> values) {
            addCriterion("sptel in", values, "sptel");
            return (Criteria) this;
        }

        public Criteria andSptelNotIn(List<String> values) {
            addCriterion("sptel not in", values, "sptel");
            return (Criteria) this;
        }

        public Criteria andSptelBetween(String value1, String value2) {
            addCriterion("sptel between", value1, value2, "sptel");
            return (Criteria) this;
        }

        public Criteria andSptelNotBetween(String value1, String value2) {
            addCriterion("sptel not between", value1, value2, "sptel");
            return (Criteria) this;
        }

        public Criteria andCoidIsNull() {
            addCriterion("coid is null");
            return (Criteria) this;
        }

        public Criteria andCoidIsNotNull() {
            addCriterion("coid is not null");
            return (Criteria) this;
        }

        public Criteria andCoidEqualTo(Integer value) {
            addCriterion("coid =", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidNotEqualTo(Integer value) {
            addCriterion("coid <>", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidGreaterThan(Integer value) {
            addCriterion("coid >", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("coid >=", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidLessThan(Integer value) {
            addCriterion("coid <", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidLessThanOrEqualTo(Integer value) {
            addCriterion("coid <=", value, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidIn(List<Integer> values) {
            addCriterion("coid in", values, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidNotIn(List<Integer> values) {
            addCriterion("coid not in", values, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidBetween(Integer value1, Integer value2) {
            addCriterion("coid between", value1, value2, "coid");
            return (Criteria) this;
        }

        public Criteria andCoidNotBetween(Integer value1, Integer value2) {
            addCriterion("coid not between", value1, value2, "coid");
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