package com.phd.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CheckTempExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckTempExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTnoIsNull() {
            addCriterion("tno is null");
            return (Criteria) this;
        }

        public Criteria andTnoIsNotNull() {
            addCriterion("tno is not null");
            return (Criteria) this;
        }

        public Criteria andTnoEqualTo(Integer value) {
            addCriterion("tno =", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotEqualTo(Integer value) {
            addCriterion("tno <>", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThan(Integer value) {
            addCriterion("tno >", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("tno >=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThan(Integer value) {
            addCriterion("tno <", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoLessThanOrEqualTo(Integer value) {
            addCriterion("tno <=", value, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoIn(List<Integer> values) {
            addCriterion("tno in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotIn(List<Integer> values) {
            addCriterion("tno not in", values, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoBetween(Integer value1, Integer value2) {
            addCriterion("tno between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTnoNotBetween(Integer value1, Integer value2) {
            addCriterion("tno not between", value1, value2, "tno");
            return (Criteria) this;
        }

        public Criteria andTnameIsNull() {
            addCriterion("tname is null");
            return (Criteria) this;
        }

        public Criteria andTnameIsNotNull() {
            addCriterion("tname is not null");
            return (Criteria) this;
        }

        public Criteria andTnameEqualTo(String value) {
            addCriterion("tname =", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotEqualTo(String value) {
            addCriterion("tname <>", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThan(String value) {
            addCriterion("tname >", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameGreaterThanOrEqualTo(String value) {
            addCriterion("tname >=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThan(String value) {
            addCriterion("tname <", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLessThanOrEqualTo(String value) {
            addCriterion("tname <=", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameLike(String value) {
            addCriterion("tname like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotLike(String value) {
            addCriterion("tname not like", value, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameIn(List<String> values) {
            addCriterion("tname in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotIn(List<String> values) {
            addCriterion("tname not in", values, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameBetween(String value1, String value2) {
            addCriterion("tname between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTnameNotBetween(String value1, String value2) {
            addCriterion("tname not between", value1, value2, "tname");
            return (Criteria) this;
        }

        public Criteria andTpwdIsNull() {
            addCriterion("tpwd is null");
            return (Criteria) this;
        }

        public Criteria andTpwdIsNotNull() {
            addCriterion("tpwd is not null");
            return (Criteria) this;
        }

        public Criteria andTpwdEqualTo(String value) {
            addCriterion("tpwd =", value, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTpwdNotEqualTo(String value) {
            addCriterion("tpwd <>", value, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTpwdGreaterThan(String value) {
            addCriterion("tpwd >", value, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTpwdGreaterThanOrEqualTo(String value) {
            addCriterion("tpwd >=", value, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTpwdLessThan(String value) {
            addCriterion("tpwd <", value, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTpwdLessThanOrEqualTo(String value) {
            addCriterion("tpwd <=", value, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTpwdLike(String value) {
            addCriterion("tpwd like", value, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTpwdNotLike(String value) {
            addCriterion("tpwd not like", value, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTpwdIn(List<String> values) {
            addCriterion("tpwd in", values, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTpwdNotIn(List<String> values) {
            addCriterion("tpwd not in", values, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTpwdBetween(String value1, String value2) {
            addCriterion("tpwd between", value1, value2, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTpwdNotBetween(String value1, String value2) {
            addCriterion("tpwd not between", value1, value2, "tpwd");
            return (Criteria) this;
        }

        public Criteria andTtelIsNull() {
            addCriterion("ttel is null");
            return (Criteria) this;
        }

        public Criteria andTtelIsNotNull() {
            addCriterion("ttel is not null");
            return (Criteria) this;
        }

        public Criteria andTtelEqualTo(String value) {
            addCriterion("ttel =", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelNotEqualTo(String value) {
            addCriterion("ttel <>", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelGreaterThan(String value) {
            addCriterion("ttel >", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelGreaterThanOrEqualTo(String value) {
            addCriterion("ttel >=", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelLessThan(String value) {
            addCriterion("ttel <", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelLessThanOrEqualTo(String value) {
            addCriterion("ttel <=", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelLike(String value) {
            addCriterion("ttel like", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelNotLike(String value) {
            addCriterion("ttel not like", value, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelIn(List<String> values) {
            addCriterion("ttel in", values, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelNotIn(List<String> values) {
            addCriterion("ttel not in", values, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelBetween(String value1, String value2) {
            addCriterion("ttel between", value1, value2, "ttel");
            return (Criteria) this;
        }

        public Criteria andTtelNotBetween(String value1, String value2) {
            addCriterion("ttel not between", value1, value2, "ttel");
            return (Criteria) this;
        }

        public Criteria andConameIsNull() {
            addCriterion("coname is null");
            return (Criteria) this;
        }

        public Criteria andConameIsNotNull() {
            addCriterion("coname is not null");
            return (Criteria) this;
        }

        public Criteria andConameEqualTo(String value) {
            addCriterion("coname =", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotEqualTo(String value) {
            addCriterion("coname <>", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameGreaterThan(String value) {
            addCriterion("coname >", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameGreaterThanOrEqualTo(String value) {
            addCriterion("coname >=", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameLessThan(String value) {
            addCriterion("coname <", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameLessThanOrEqualTo(String value) {
            addCriterion("coname <=", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameLike(String value) {
            addCriterion("coname like", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotLike(String value) {
            addCriterion("coname not like", value, "coname");
            return (Criteria) this;
        }

        public Criteria andConameIn(List<String> values) {
            addCriterion("coname in", values, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotIn(List<String> values) {
            addCriterion("coname not in", values, "coname");
            return (Criteria) this;
        }

        public Criteria andConameBetween(String value1, String value2) {
            addCriterion("coname between", value1, value2, "coname");
            return (Criteria) this;
        }

        public Criteria andConameNotBetween(String value1, String value2) {
            addCriterion("coname not between", value1, value2, "coname");
            return (Criteria) this;
        }

        public Criteria andSpare1IsNull() {
            addCriterion("spare1 is null");
            return (Criteria) this;
        }

        public Criteria andSpare1IsNotNull() {
            addCriterion("spare1 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare1EqualTo(Integer value) {
            addCriterion("spare1 =", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotEqualTo(Integer value) {
            addCriterion("spare1 <>", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1GreaterThan(Integer value) {
            addCriterion("spare1 >", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1GreaterThanOrEqualTo(Integer value) {
            addCriterion("spare1 >=", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1LessThan(Integer value) {
            addCriterion("spare1 <", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1LessThanOrEqualTo(Integer value) {
            addCriterion("spare1 <=", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1In(List<Integer> values) {
            addCriterion("spare1 in", values, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotIn(List<Integer> values) {
            addCriterion("spare1 not in", values, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1Between(Integer value1, Integer value2) {
            addCriterion("spare1 between", value1, value2, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotBetween(Integer value1, Integer value2) {
            addCriterion("spare1 not between", value1, value2, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare2IsNull() {
            addCriterion("spare2 is null");
            return (Criteria) this;
        }

        public Criteria andSpare2IsNotNull() {
            addCriterion("spare2 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare2EqualTo(Integer value) {
            addCriterion("spare2 =", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotEqualTo(Integer value) {
            addCriterion("spare2 <>", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2GreaterThan(Integer value) {
            addCriterion("spare2 >", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2GreaterThanOrEqualTo(Integer value) {
            addCriterion("spare2 >=", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2LessThan(Integer value) {
            addCriterion("spare2 <", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2LessThanOrEqualTo(Integer value) {
            addCriterion("spare2 <=", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2In(List<Integer> values) {
            addCriterion("spare2 in", values, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotIn(List<Integer> values) {
            addCriterion("spare2 not in", values, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2Between(Integer value1, Integer value2) {
            addCriterion("spare2 between", value1, value2, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotBetween(Integer value1, Integer value2) {
            addCriterion("spare2 not between", value1, value2, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare3IsNull() {
            addCriterion("spare3 is null");
            return (Criteria) this;
        }

        public Criteria andSpare3IsNotNull() {
            addCriterion("spare3 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare3EqualTo(String value) {
            addCriterion("spare3 =", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotEqualTo(String value) {
            addCriterion("spare3 <>", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3GreaterThan(String value) {
            addCriterion("spare3 >", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3GreaterThanOrEqualTo(String value) {
            addCriterion("spare3 >=", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3LessThan(String value) {
            addCriterion("spare3 <", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3LessThanOrEqualTo(String value) {
            addCriterion("spare3 <=", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3Like(String value) {
            addCriterion("spare3 like", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotLike(String value) {
            addCriterion("spare3 not like", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3In(List<String> values) {
            addCriterion("spare3 in", values, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotIn(List<String> values) {
            addCriterion("spare3 not in", values, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3Between(String value1, String value2) {
            addCriterion("spare3 between", value1, value2, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotBetween(String value1, String value2) {
            addCriterion("spare3 not between", value1, value2, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare4IsNull() {
            addCriterion("spare4 is null");
            return (Criteria) this;
        }

        public Criteria andSpare4IsNotNull() {
            addCriterion("spare4 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare4EqualTo(String value) {
            addCriterion("spare4 =", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotEqualTo(String value) {
            addCriterion("spare4 <>", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4GreaterThan(String value) {
            addCriterion("spare4 >", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4GreaterThanOrEqualTo(String value) {
            addCriterion("spare4 >=", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4LessThan(String value) {
            addCriterion("spare4 <", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4LessThanOrEqualTo(String value) {
            addCriterion("spare4 <=", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4Like(String value) {
            addCriterion("spare4 like", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotLike(String value) {
            addCriterion("spare4 not like", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4In(List<String> values) {
            addCriterion("spare4 in", values, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotIn(List<String> values) {
            addCriterion("spare4 not in", values, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4Between(String value1, String value2) {
            addCriterion("spare4 between", value1, value2, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotBetween(String value1, String value2) {
            addCriterion("spare4 not between", value1, value2, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare5IsNull() {
            addCriterion("spare5 is null");
            return (Criteria) this;
        }

        public Criteria andSpare5IsNotNull() {
            addCriterion("spare5 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare5EqualTo(String value) {
            addCriterion("spare5 =", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5NotEqualTo(String value) {
            addCriterion("spare5 <>", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5GreaterThan(String value) {
            addCriterion("spare5 >", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5GreaterThanOrEqualTo(String value) {
            addCriterion("spare5 >=", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5LessThan(String value) {
            addCriterion("spare5 <", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5LessThanOrEqualTo(String value) {
            addCriterion("spare5 <=", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5Like(String value) {
            addCriterion("spare5 like", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5NotLike(String value) {
            addCriterion("spare5 not like", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5In(List<String> values) {
            addCriterion("spare5 in", values, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5NotIn(List<String> values) {
            addCriterion("spare5 not in", values, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5Between(String value1, String value2) {
            addCriterion("spare5 between", value1, value2, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5NotBetween(String value1, String value2) {
            addCriterion("spare5 not between", value1, value2, "spare5");
            return (Criteria) this;
        }

        public Criteria andRecordidIsNull() {
            addCriterion("recordid is null");
            return (Criteria) this;
        }

        public Criteria andRecordidIsNotNull() {
            addCriterion("recordid is not null");
            return (Criteria) this;
        }

        public Criteria andRecordidEqualTo(String value) {
            addCriterion("recordid =", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotEqualTo(String value) {
            addCriterion("recordid <>", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThan(String value) {
            addCriterion("recordid >", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidGreaterThanOrEqualTo(String value) {
            addCriterion("recordid >=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThan(String value) {
            addCriterion("recordid <", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLessThanOrEqualTo(String value) {
            addCriterion("recordid <=", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidLike(String value) {
            addCriterion("recordid like", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotLike(String value) {
            addCriterion("recordid not like", value, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidIn(List<String> values) {
            addCriterion("recordid in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotIn(List<String> values) {
            addCriterion("recordid not in", values, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidBetween(String value1, String value2) {
            addCriterion("recordid between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andRecordidNotBetween(String value1, String value2) {
            addCriterion("recordid not between", value1, value2, "recordid");
            return (Criteria) this;
        }

        public Criteria andCheccodeIsNull() {
            addCriterion("checcode is null");
            return (Criteria) this;
        }

        public Criteria andCheccodeIsNotNull() {
            addCriterion("checcode is not null");
            return (Criteria) this;
        }

        public Criteria andCheccodeEqualTo(Integer value) {
            addCriterion("checcode =", value, "checcode");
            return (Criteria) this;
        }

        public Criteria andCheccodeNotEqualTo(Integer value) {
            addCriterion("checcode <>", value, "checcode");
            return (Criteria) this;
        }

        public Criteria andCheccodeGreaterThan(Integer value) {
            addCriterion("checcode >", value, "checcode");
            return (Criteria) this;
        }

        public Criteria andCheccodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("checcode >=", value, "checcode");
            return (Criteria) this;
        }

        public Criteria andCheccodeLessThan(Integer value) {
            addCriterion("checcode <", value, "checcode");
            return (Criteria) this;
        }

        public Criteria andCheccodeLessThanOrEqualTo(Integer value) {
            addCriterion("checcode <=", value, "checcode");
            return (Criteria) this;
        }

        public Criteria andCheccodeIn(List<Integer> values) {
            addCriterion("checcode in", values, "checcode");
            return (Criteria) this;
        }

        public Criteria andCheccodeNotIn(List<Integer> values) {
            addCriterion("checcode not in", values, "checcode");
            return (Criteria) this;
        }

        public Criteria andCheccodeBetween(Integer value1, Integer value2) {
            addCriterion("checcode between", value1, value2, "checcode");
            return (Criteria) this;
        }

        public Criteria andCheccodeNotBetween(Integer value1, Integer value2) {
            addCriterion("checcode not between", value1, value2, "checcode");
            return (Criteria) this;
        }

        public Criteria andCheckinfoIsNull() {
            addCriterion("checkinfo is null");
            return (Criteria) this;
        }

        public Criteria andCheckinfoIsNotNull() {
            addCriterion("checkinfo is not null");
            return (Criteria) this;
        }

        public Criteria andCheckinfoEqualTo(String value) {
            addCriterion("checkinfo =", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoNotEqualTo(String value) {
            addCriterion("checkinfo <>", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoGreaterThan(String value) {
            addCriterion("checkinfo >", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoGreaterThanOrEqualTo(String value) {
            addCriterion("checkinfo >=", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoLessThan(String value) {
            addCriterion("checkinfo <", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoLessThanOrEqualTo(String value) {
            addCriterion("checkinfo <=", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoLike(String value) {
            addCriterion("checkinfo like", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoNotLike(String value) {
            addCriterion("checkinfo not like", value, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoIn(List<String> values) {
            addCriterion("checkinfo in", values, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoNotIn(List<String> values) {
            addCriterion("checkinfo not in", values, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoBetween(String value1, String value2) {
            addCriterion("checkinfo between", value1, value2, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andCheckinfoNotBetween(String value1, String value2) {
            addCriterion("checkinfo not between", value1, value2, "checkinfo");
            return (Criteria) this;
        }

        public Criteria andTmpidIsNull() {
            addCriterion("tmpid is null");
            return (Criteria) this;
        }

        public Criteria andTmpidIsNotNull() {
            addCriterion("tmpid is not null");
            return (Criteria) this;
        }

        public Criteria andTmpidEqualTo(BigDecimal value) {
            addCriterion("tmpid =", value, "tmpid");
            return (Criteria) this;
        }

        public Criteria andTmpidNotEqualTo(BigDecimal value) {
            addCriterion("tmpid <>", value, "tmpid");
            return (Criteria) this;
        }

        public Criteria andTmpidGreaterThan(BigDecimal value) {
            addCriterion("tmpid >", value, "tmpid");
            return (Criteria) this;
        }

        public Criteria andTmpidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tmpid >=", value, "tmpid");
            return (Criteria) this;
        }

        public Criteria andTmpidLessThan(BigDecimal value) {
            addCriterion("tmpid <", value, "tmpid");
            return (Criteria) this;
        }

        public Criteria andTmpidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tmpid <=", value, "tmpid");
            return (Criteria) this;
        }

        public Criteria andTmpidIn(List<BigDecimal> values) {
            addCriterion("tmpid in", values, "tmpid");
            return (Criteria) this;
        }

        public Criteria andTmpidNotIn(List<BigDecimal> values) {
            addCriterion("tmpid not in", values, "tmpid");
            return (Criteria) this;
        }

        public Criteria andTmpidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tmpid between", value1, value2, "tmpid");
            return (Criteria) this;
        }

        public Criteria andTmpidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tmpid not between", value1, value2, "tmpid");
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