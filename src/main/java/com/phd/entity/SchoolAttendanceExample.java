package com.phd.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SchoolAttendanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchoolAttendanceExample() {
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

        public Criteria andSaidNotEqualTo(Long value) {
            addCriterion("said <>", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidGreaterThan(Long value) {
            addCriterion("said >", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidGreaterThanOrEqualTo(Long value) {
            addCriterion("said >=", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidLessThan(Long value) {
            addCriterion("said <", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidLessThanOrEqualTo(Long value) {
            addCriterion("said <=", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidIn(List<Long> values) {
            addCriterion("said in", values, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotIn(List<Long> values) {
            addCriterion("said not in", values, "said");
            return (Criteria) this;
        }

        public Criteria andSaidBetween(Long value1, Long value2) {
            addCriterion("said between", value1, value2, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotBetween(Long value1, Long value2) {
            addCriterion("said not between", value1, value2, "said");
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

        public Criteria andSanumIsNull() {
            addCriterion("sanum is null");
            return (Criteria) this;
        }

        public Criteria andSanumIsNotNull() {
            addCriterion("sanum is not null");
            return (Criteria) this;
        }

        public Criteria andSanumEqualTo(Short value) {
            addCriterion("sanum =", value, "sanum");
            return (Criteria) this;
        }

        public Criteria andSanumNotEqualTo(Short value) {
            addCriterion("sanum <>", value, "sanum");
            return (Criteria) this;
        }

        public Criteria andSanumGreaterThan(Short value) {
            addCriterion("sanum >", value, "sanum");
            return (Criteria) this;
        }

        public Criteria andSanumGreaterThanOrEqualTo(Short value) {
            addCriterion("sanum >=", value, "sanum");
            return (Criteria) this;
        }

        public Criteria andSanumLessThan(Short value) {
            addCriterion("sanum <", value, "sanum");
            return (Criteria) this;
        }

        public Criteria andSanumLessThanOrEqualTo(Short value) {
            addCriterion("sanum <=", value, "sanum");
            return (Criteria) this;
        }

        public Criteria andSanumIn(List<Short> values) {
            addCriterion("sanum in", values, "sanum");
            return (Criteria) this;
        }

        public Criteria andSanumNotIn(List<Short> values) {
            addCriterion("sanum not in", values, "sanum");
            return (Criteria) this;
        }

        public Criteria andSanumBetween(Short value1, Short value2) {
            addCriterion("sanum between", value1, value2, "sanum");
            return (Criteria) this;
        }

        public Criteria andSanumNotBetween(Short value1, Short value2) {
            addCriterion("sanum not between", value1, value2, "sanum");
            return (Criteria) this;
        }

        public Criteria andSainumIsNull() {
            addCriterion("sainum is null");
            return (Criteria) this;
        }

        public Criteria andSainumIsNotNull() {
            addCriterion("sainum is not null");
            return (Criteria) this;
        }

        public Criteria andSainumEqualTo(Short value) {
            addCriterion("sainum =", value, "sainum");
            return (Criteria) this;
        }

        public Criteria andSainumNotEqualTo(Short value) {
            addCriterion("sainum <>", value, "sainum");
            return (Criteria) this;
        }

        public Criteria andSainumGreaterThan(Short value) {
            addCriterion("sainum >", value, "sainum");
            return (Criteria) this;
        }

        public Criteria andSainumGreaterThanOrEqualTo(Short value) {
            addCriterion("sainum >=", value, "sainum");
            return (Criteria) this;
        }

        public Criteria andSainumLessThan(Short value) {
            addCriterion("sainum <", value, "sainum");
            return (Criteria) this;
        }

        public Criteria andSainumLessThanOrEqualTo(Short value) {
            addCriterion("sainum <=", value, "sainum");
            return (Criteria) this;
        }

        public Criteria andSainumIn(List<Short> values) {
            addCriterion("sainum in", values, "sainum");
            return (Criteria) this;
        }

        public Criteria andSainumNotIn(List<Short> values) {
            addCriterion("sainum not in", values, "sainum");
            return (Criteria) this;
        }

        public Criteria andSainumBetween(Short value1, Short value2) {
            addCriterion("sainum between", value1, value2, "sainum");
            return (Criteria) this;
        }

        public Criteria andSainumNotBetween(Short value1, Short value2) {
            addCriterion("sainum not between", value1, value2, "sainum");
            return (Criteria) this;
        }

        public Criteria andSarateIsNull() {
            addCriterion("sarate is null");
            return (Criteria) this;
        }

        public Criteria andSarateIsNotNull() {
            addCriterion("sarate is not null");
            return (Criteria) this;
        }

        public Criteria andSarateEqualTo(Integer value) {
            addCriterion("sarate =", value, "sarate");
            return (Criteria) this;
        }

        public Criteria andSarateNotEqualTo(Integer value) {
            addCriterion("sarate <>", value, "sarate");
            return (Criteria) this;
        }

        public Criteria andSarateGreaterThan(Integer value) {
            addCriterion("sarate >", value, "sarate");
            return (Criteria) this;
        }

        public Criteria andSarateGreaterThanOrEqualTo(Integer value) {
            addCriterion("sarate >=", value, "sarate");
            return (Criteria) this;
        }

        public Criteria andSarateLessThan(Integer value) {
            addCriterion("sarate <", value, "sarate");
            return (Criteria) this;
        }

        public Criteria andSarateLessThanOrEqualTo(Integer value) {
            addCriterion("sarate <=", value, "sarate");
            return (Criteria) this;
        }

        public Criteria andSarateIn(List<Integer> values) {
            addCriterion("sarate in", values, "sarate");
            return (Criteria) this;
        }

        public Criteria andSarateNotIn(List<Integer> values) {
            addCriterion("sarate not in", values, "sarate");
            return (Criteria) this;
        }

        public Criteria andSarateBetween(Integer value1, Integer value2) {
            addCriterion("sarate between", value1, value2, "sarate");
            return (Criteria) this;
        }

        public Criteria andSarateNotBetween(Integer value1, Integer value2) {
            addCriterion("sarate not between", value1, value2, "sarate");
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

        public Criteria andSacodeIsNull() {
            addCriterion("sacode is null");
            return (Criteria) this;
        }

        public Criteria andSacodeIsNotNull() {
            addCriterion("sacode is not null");
            return (Criteria) this;
        }

        public Criteria andSacodeEqualTo(Short value) {
            addCriterion("sacode =", value, "sacode");
            return (Criteria) this;
        }

        public Criteria andSacodeNotEqualTo(Short value) {
            addCriterion("sacode <>", value, "sacode");
            return (Criteria) this;
        }

        public Criteria andSacodeGreaterThan(Short value) {
            addCriterion("sacode >", value, "sacode");
            return (Criteria) this;
        }

        public Criteria andSacodeGreaterThanOrEqualTo(Short value) {
            addCriterion("sacode >=", value, "sacode");
            return (Criteria) this;
        }

        public Criteria andSacodeLessThan(Short value) {
            addCriterion("sacode <", value, "sacode");
            return (Criteria) this;
        }

        public Criteria andSacodeLessThanOrEqualTo(Short value) {
            addCriterion("sacode <=", value, "sacode");
            return (Criteria) this;
        }

        public Criteria andSacodeIn(List<Short> values) {
            addCriterion("sacode in", values, "sacode");
            return (Criteria) this;
        }

        public Criteria andSacodeNotIn(List<Short> values) {
            addCriterion("sacode not in", values, "sacode");
            return (Criteria) this;
        }

        public Criteria andSacodeBetween(Short value1, Short value2) {
            addCriterion("sacode between", value1, value2, "sacode");
            return (Criteria) this;
        }

        public Criteria andSacodeNotBetween(Short value1, Short value2) {
            addCriterion("sacode not between", value1, value2, "sacode");
            return (Criteria) this;
        }

        public Criteria andSatimeIsNull() {
            addCriterion("satime is null");
            return (Criteria) this;
        }

        public Criteria andSatimeIsNotNull() {
            addCriterion("satime is not null");
            return (Criteria) this;
        }

        public Criteria andSatimeEqualTo(Date value) {
            addCriterion("satime =", value, "satime");
            return (Criteria) this;
        }

        public Criteria andSatimeNotEqualTo(Date value) {
            addCriterion("satime <>", value, "satime");
            return (Criteria) this;
        }

        public Criteria andSatimeGreaterThan(Date value) {
            addCriterion("satime >", value, "satime");
            return (Criteria) this;
        }

        public Criteria andSatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("satime >=", value, "satime");
            return (Criteria) this;
        }

        public Criteria andSatimeLessThan(Date value) {
            addCriterion("satime <", value, "satime");
            return (Criteria) this;
        }

        public Criteria andSatimeLessThanOrEqualTo(Date value) {
            addCriterion("satime <=", value, "satime");
            return (Criteria) this;
        }

        public Criteria andSatimeIn(List<Date> values) {
            addCriterion("satime in", values, "satime");
            return (Criteria) this;
        }

        public Criteria andSatimeNotIn(List<Date> values) {
            addCriterion("satime not in", values, "satime");
            return (Criteria) this;
        }

        public Criteria andSatimeBetween(Date value1, Date value2) {
            addCriterion("satime between", value1, value2, "satime");
            return (Criteria) this;
        }

        public Criteria andSatimeNotBetween(Date value1, Date value2) {
            addCriterion("satime not between", value1, value2, "satime");
            return (Criteria) this;
        }

        public Criteria andSaaddressIsNull() {
            addCriterion("saaddress is null");
            return (Criteria) this;
        }

        public Criteria andSaaddressIsNotNull() {
            addCriterion("saaddress is not null");
            return (Criteria) this;
        }

        public Criteria andSaaddressEqualTo(String value) {
            addCriterion("saaddress =", value, "saaddress");
            return (Criteria) this;
        }

        public Criteria andSaaddressNotEqualTo(String value) {
            addCriterion("saaddress <>", value, "saaddress");
            return (Criteria) this;
        }

        public Criteria andSaaddressGreaterThan(String value) {
            addCriterion("saaddress >", value, "saaddress");
            return (Criteria) this;
        }

        public Criteria andSaaddressGreaterThanOrEqualTo(String value) {
            addCriterion("saaddress >=", value, "saaddress");
            return (Criteria) this;
        }

        public Criteria andSaaddressLessThan(String value) {
            addCriterion("saaddress <", value, "saaddress");
            return (Criteria) this;
        }

        public Criteria andSaaddressLessThanOrEqualTo(String value) {
            addCriterion("saaddress <=", value, "saaddress");
            return (Criteria) this;
        }

        public Criteria andSaaddressLike(String value) {
            addCriterion("saaddress like", value, "saaddress");
            return (Criteria) this;
        }

        public Criteria andSaaddressNotLike(String value) {
            addCriterion("saaddress not like", value, "saaddress");
            return (Criteria) this;
        }

        public Criteria andSaaddressIn(List<String> values) {
            addCriterion("saaddress in", values, "saaddress");
            return (Criteria) this;
        }

        public Criteria andSaaddressNotIn(List<String> values) {
            addCriterion("saaddress not in", values, "saaddress");
            return (Criteria) this;
        }

        public Criteria andSaaddressBetween(String value1, String value2) {
            addCriterion("saaddress between", value1, value2, "saaddress");
            return (Criteria) this;
        }

        public Criteria andSaaddressNotBetween(String value1, String value2) {
            addCriterion("saaddress not between", value1, value2, "saaddress");
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