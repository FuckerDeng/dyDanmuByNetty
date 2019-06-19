package df.bean.giftbean;

import java.util.ArrayList;
import java.util.List;

public class GiftrecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GiftrecordExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("rid is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("rid is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("rid =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("rid <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("rid >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rid >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("rid <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("rid <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("rid in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("rid not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("rid between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("rid not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andGfidIsNull() {
            addCriterion("gfid is null");
            return (Criteria) this;
        }

        public Criteria andGfidIsNotNull() {
            addCriterion("gfid is not null");
            return (Criteria) this;
        }

        public Criteria andGfidEqualTo(Integer value) {
            addCriterion("gfid =", value, "gfid");
            return (Criteria) this;
        }

        public Criteria andGfidNotEqualTo(Integer value) {
            addCriterion("gfid <>", value, "gfid");
            return (Criteria) this;
        }

        public Criteria andGfidGreaterThan(Integer value) {
            addCriterion("gfid >", value, "gfid");
            return (Criteria) this;
        }

        public Criteria andGfidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gfid >=", value, "gfid");
            return (Criteria) this;
        }

        public Criteria andGfidLessThan(Integer value) {
            addCriterion("gfid <", value, "gfid");
            return (Criteria) this;
        }

        public Criteria andGfidLessThanOrEqualTo(Integer value) {
            addCriterion("gfid <=", value, "gfid");
            return (Criteria) this;
        }

        public Criteria andGfidIn(List<Integer> values) {
            addCriterion("gfid in", values, "gfid");
            return (Criteria) this;
        }

        public Criteria andGfidNotIn(List<Integer> values) {
            addCriterion("gfid not in", values, "gfid");
            return (Criteria) this;
        }

        public Criteria andGfidBetween(Integer value1, Integer value2) {
            addCriterion("gfid between", value1, value2, "gfid");
            return (Criteria) this;
        }

        public Criteria andGfidNotBetween(Integer value1, Integer value2) {
            addCriterion("gfid not between", value1, value2, "gfid");
            return (Criteria) this;
        }

        public Criteria andIsfreeIsNull() {
            addCriterion("isfree is null");
            return (Criteria) this;
        }

        public Criteria andIsfreeIsNotNull() {
            addCriterion("isfree is not null");
            return (Criteria) this;
        }

        public Criteria andIsfreeEqualTo(Integer value) {
            addCriterion("isfree =", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotEqualTo(Integer value) {
            addCriterion("isfree <>", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeGreaterThan(Integer value) {
            addCriterion("isfree >", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("isfree >=", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeLessThan(Integer value) {
            addCriterion("isfree <", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeLessThanOrEqualTo(Integer value) {
            addCriterion("isfree <=", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeIn(List<Integer> values) {
            addCriterion("isfree in", values, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotIn(List<Integer> values) {
            addCriterion("isfree not in", values, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeBetween(Integer value1, Integer value2) {
            addCriterion("isfree between", value1, value2, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotBetween(Integer value1, Integer value2) {
            addCriterion("isfree not between", value1, value2, "isfree");
            return (Criteria) this;
        }

        public Criteria andGfnameIsNull() {
            addCriterion("gfname is null");
            return (Criteria) this;
        }

        public Criteria andGfnameIsNotNull() {
            addCriterion("gfname is not null");
            return (Criteria) this;
        }

        public Criteria andGfnameEqualTo(String value) {
            addCriterion("gfname =", value, "gfname");
            return (Criteria) this;
        }

        public Criteria andGfnameNotEqualTo(String value) {
            addCriterion("gfname <>", value, "gfname");
            return (Criteria) this;
        }

        public Criteria andGfnameGreaterThan(String value) {
            addCriterion("gfname >", value, "gfname");
            return (Criteria) this;
        }

        public Criteria andGfnameGreaterThanOrEqualTo(String value) {
            addCriterion("gfname >=", value, "gfname");
            return (Criteria) this;
        }

        public Criteria andGfnameLessThan(String value) {
            addCriterion("gfname <", value, "gfname");
            return (Criteria) this;
        }

        public Criteria andGfnameLessThanOrEqualTo(String value) {
            addCriterion("gfname <=", value, "gfname");
            return (Criteria) this;
        }

        public Criteria andGfnameLike(String value) {
            addCriterion("gfname like", value, "gfname");
            return (Criteria) this;
        }

        public Criteria andGfnameNotLike(String value) {
            addCriterion("gfname not like", value, "gfname");
            return (Criteria) this;
        }

        public Criteria andGfnameIn(List<String> values) {
            addCriterion("gfname in", values, "gfname");
            return (Criteria) this;
        }

        public Criteria andGfnameNotIn(List<String> values) {
            addCriterion("gfname not in", values, "gfname");
            return (Criteria) this;
        }

        public Criteria andGfnameBetween(String value1, String value2) {
            addCriterion("gfname between", value1, value2, "gfname");
            return (Criteria) this;
        }

        public Criteria andGfnameNotBetween(String value1, String value2) {
            addCriterion("gfname not between", value1, value2, "gfname");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andNnIsNull() {
            addCriterion("nn is null");
            return (Criteria) this;
        }

        public Criteria andNnIsNotNull() {
            addCriterion("nn is not null");
            return (Criteria) this;
        }

        public Criteria andNnEqualTo(String value) {
            addCriterion("nn =", value, "nn");
            return (Criteria) this;
        }

        public Criteria andNnNotEqualTo(String value) {
            addCriterion("nn <>", value, "nn");
            return (Criteria) this;
        }

        public Criteria andNnGreaterThan(String value) {
            addCriterion("nn >", value, "nn");
            return (Criteria) this;
        }

        public Criteria andNnGreaterThanOrEqualTo(String value) {
            addCriterion("nn >=", value, "nn");
            return (Criteria) this;
        }

        public Criteria andNnLessThan(String value) {
            addCriterion("nn <", value, "nn");
            return (Criteria) this;
        }

        public Criteria andNnLessThanOrEqualTo(String value) {
            addCriterion("nn <=", value, "nn");
            return (Criteria) this;
        }

        public Criteria andNnLike(String value) {
            addCriterion("nn like", value, "nn");
            return (Criteria) this;
        }

        public Criteria andNnNotLike(String value) {
            addCriterion("nn not like", value, "nn");
            return (Criteria) this;
        }

        public Criteria andNnIn(List<String> values) {
            addCriterion("nn in", values, "nn");
            return (Criteria) this;
        }

        public Criteria andNnNotIn(List<String> values) {
            addCriterion("nn not in", values, "nn");
            return (Criteria) this;
        }

        public Criteria andNnBetween(String value1, String value2) {
            addCriterion("nn between", value1, value2, "nn");
            return (Criteria) this;
        }

        public Criteria andNnNotBetween(String value1, String value2) {
            addCriterion("nn not between", value1, value2, "nn");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(Integer value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(Integer value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(Integer value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(Integer value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(Integer value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<Integer> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<Integer> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(Integer value1, Integer value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andGfcntIsNull() {
            addCriterion("gfcnt is null");
            return (Criteria) this;
        }

        public Criteria andGfcntIsNotNull() {
            addCriterion("gfcnt is not null");
            return (Criteria) this;
        }

        public Criteria andGfcntEqualTo(Integer value) {
            addCriterion("gfcnt =", value, "gfcnt");
            return (Criteria) this;
        }

        public Criteria andGfcntNotEqualTo(Integer value) {
            addCriterion("gfcnt <>", value, "gfcnt");
            return (Criteria) this;
        }

        public Criteria andGfcntGreaterThan(Integer value) {
            addCriterion("gfcnt >", value, "gfcnt");
            return (Criteria) this;
        }

        public Criteria andGfcntGreaterThanOrEqualTo(Integer value) {
            addCriterion("gfcnt >=", value, "gfcnt");
            return (Criteria) this;
        }

        public Criteria andGfcntLessThan(Integer value) {
            addCriterion("gfcnt <", value, "gfcnt");
            return (Criteria) this;
        }

        public Criteria andGfcntLessThanOrEqualTo(Integer value) {
            addCriterion("gfcnt <=", value, "gfcnt");
            return (Criteria) this;
        }

        public Criteria andGfcntIn(List<Integer> values) {
            addCriterion("gfcnt in", values, "gfcnt");
            return (Criteria) this;
        }

        public Criteria andGfcntNotIn(List<Integer> values) {
            addCriterion("gfcnt not in", values, "gfcnt");
            return (Criteria) this;
        }

        public Criteria andGfcntBetween(Integer value1, Integer value2) {
            addCriterion("gfcnt between", value1, value2, "gfcnt");
            return (Criteria) this;
        }

        public Criteria andGfcntNotBetween(Integer value1, Integer value2) {
            addCriterion("gfcnt not between", value1, value2, "gfcnt");
            return (Criteria) this;
        }

        public Criteria andJiageIsNull() {
            addCriterion("jiage is null");
            return (Criteria) this;
        }

        public Criteria andJiageIsNotNull() {
            addCriterion("jiage is not null");
            return (Criteria) this;
        }

        public Criteria andJiageEqualTo(Double value) {
            addCriterion("jiage =", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageNotEqualTo(Double value) {
            addCriterion("jiage <>", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageGreaterThan(Double value) {
            addCriterion("jiage >", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageGreaterThanOrEqualTo(Double value) {
            addCriterion("jiage >=", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageLessThan(Double value) {
            addCriterion("jiage <", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageLessThanOrEqualTo(Double value) {
            addCriterion("jiage <=", value, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageIn(List<Double> values) {
            addCriterion("jiage in", values, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageNotIn(List<Double> values) {
            addCriterion("jiage not in", values, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageBetween(Double value1, Double value2) {
            addCriterion("jiage between", value1, value2, "jiage");
            return (Criteria) this;
        }

        public Criteria andJiageNotBetween(Double value1, Double value2) {
            addCriterion("jiage not between", value1, value2, "jiage");
            return (Criteria) this;
        }

        public Criteria andGifttimeIsNull() {
            addCriterion("gifttime is null");
            return (Criteria) this;
        }

        public Criteria andGifttimeIsNotNull() {
            addCriterion("gifttime is not null");
            return (Criteria) this;
        }

        public Criteria andGifttimeEqualTo(Long value) {
            addCriterion("gifttime =", value, "gifttime");
            return (Criteria) this;
        }

        public Criteria andGifttimeNotEqualTo(Long value) {
            addCriterion("gifttime <>", value, "gifttime");
            return (Criteria) this;
        }

        public Criteria andGifttimeGreaterThan(Long value) {
            addCriterion("gifttime >", value, "gifttime");
            return (Criteria) this;
        }

        public Criteria andGifttimeGreaterThanOrEqualTo(Long value) {
            addCriterion("gifttime >=", value, "gifttime");
            return (Criteria) this;
        }

        public Criteria andGifttimeLessThan(Long value) {
            addCriterion("gifttime <", value, "gifttime");
            return (Criteria) this;
        }

        public Criteria andGifttimeLessThanOrEqualTo(Long value) {
            addCriterion("gifttime <=", value, "gifttime");
            return (Criteria) this;
        }

        public Criteria andGifttimeIn(List<Long> values) {
            addCriterion("gifttime in", values, "gifttime");
            return (Criteria) this;
        }

        public Criteria andGifttimeNotIn(List<Long> values) {
            addCriterion("gifttime not in", values, "gifttime");
            return (Criteria) this;
        }

        public Criteria andGifttimeBetween(Long value1, Long value2) {
            addCriterion("gifttime between", value1, value2, "gifttime");
            return (Criteria) this;
        }

        public Criteria andGifttimeNotBetween(Long value1, Long value2) {
            addCriterion("gifttime not between", value1, value2, "gifttime");
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