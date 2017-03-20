package base.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andClassidIsNull() {
            addCriterion("classid is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("classid is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(Integer value) {
            addCriterion("classid =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(Integer value) {
            addCriterion("classid <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(Integer value) {
            addCriterion("classid >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("classid >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(Integer value) {
            addCriterion("classid <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(Integer value) {
            addCriterion("classid <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<Integer> values) {
            addCriterion("classid in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<Integer> values) {
            addCriterion("classid not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(Integer value1, Integer value2) {
            addCriterion("classid between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(Integer value1, Integer value2) {
            addCriterion("classid not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNull() {
            addCriterion("classname is null");
            return (Criteria) this;
        }

        public Criteria andClassnameIsNotNull() {
            addCriterion("classname is not null");
            return (Criteria) this;
        }

        public Criteria andClassnameEqualTo(String value) {
            addCriterion("classname =", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotEqualTo(String value) {
            addCriterion("classname <>", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThan(String value) {
            addCriterion("classname >", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameGreaterThanOrEqualTo(String value) {
            addCriterion("classname >=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThan(String value) {
            addCriterion("classname <", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLessThanOrEqualTo(String value) {
            addCriterion("classname <=", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameLike(String value) {
            addCriterion("classname like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotLike(String value) {
            addCriterion("classname not like", value, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameIn(List<String> values) {
            addCriterion("classname in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotIn(List<String> values) {
            addCriterion("classname not in", values, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameBetween(String value1, String value2) {
            addCriterion("classname between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andClassnameNotBetween(String value1, String value2) {
            addCriterion("classname not between", value1, value2, "classname");
            return (Criteria) this;
        }

        public Criteria andInstitutionidIsNull() {
            addCriterion("institutionid is null");
            return (Criteria) this;
        }

        public Criteria andInstitutionidIsNotNull() {
            addCriterion("institutionid is not null");
            return (Criteria) this;
        }

        public Criteria andInstitutionidEqualTo(Integer value) {
            addCriterion("institutionid =", value, "institutionid");
            return (Criteria) this;
        }

        public Criteria andInstitutionidNotEqualTo(Integer value) {
            addCriterion("institutionid <>", value, "institutionid");
            return (Criteria) this;
        }

        public Criteria andInstitutionidGreaterThan(Integer value) {
            addCriterion("institutionid >", value, "institutionid");
            return (Criteria) this;
        }

        public Criteria andInstitutionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("institutionid >=", value, "institutionid");
            return (Criteria) this;
        }

        public Criteria andInstitutionidLessThan(Integer value) {
            addCriterion("institutionid <", value, "institutionid");
            return (Criteria) this;
        }

        public Criteria andInstitutionidLessThanOrEqualTo(Integer value) {
            addCriterion("institutionid <=", value, "institutionid");
            return (Criteria) this;
        }

        public Criteria andInstitutionidIn(List<Integer> values) {
            addCriterion("institutionid in", values, "institutionid");
            return (Criteria) this;
        }

        public Criteria andInstitutionidNotIn(List<Integer> values) {
            addCriterion("institutionid not in", values, "institutionid");
            return (Criteria) this;
        }

        public Criteria andInstitutionidBetween(Integer value1, Integer value2) {
            addCriterion("institutionid between", value1, value2, "institutionid");
            return (Criteria) this;
        }

        public Criteria andInstitutionidNotBetween(Integer value1, Integer value2) {
            addCriterion("institutionid not between", value1, value2, "institutionid");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameIsNull() {
            addCriterion("institutionname is null");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameIsNotNull() {
            addCriterion("institutionname is not null");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameEqualTo(String value) {
            addCriterion("institutionname =", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameNotEqualTo(String value) {
            addCriterion("institutionname <>", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameGreaterThan(String value) {
            addCriterion("institutionname >", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameGreaterThanOrEqualTo(String value) {
            addCriterion("institutionname >=", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameLessThan(String value) {
            addCriterion("institutionname <", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameLessThanOrEqualTo(String value) {
            addCriterion("institutionname <=", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameLike(String value) {
            addCriterion("institutionname like", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameNotLike(String value) {
            addCriterion("institutionname not like", value, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameIn(List<String> values) {
            addCriterion("institutionname in", values, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameNotIn(List<String> values) {
            addCriterion("institutionname not in", values, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameBetween(String value1, String value2) {
            addCriterion("institutionname between", value1, value2, "institutionname");
            return (Criteria) this;
        }

        public Criteria andInstitutionnameNotBetween(String value1, String value2) {
            addCriterion("institutionname not between", value1, value2, "institutionname");
            return (Criteria) this;
        }

        public Criteria andTraineenumberIsNull() {
            addCriterion("traineenumber is null");
            return (Criteria) this;
        }

        public Criteria andTraineenumberIsNotNull() {
            addCriterion("traineenumber is not null");
            return (Criteria) this;
        }

        public Criteria andTraineenumberEqualTo(Integer value) {
            addCriterion("traineenumber =", value, "traineenumber");
            return (Criteria) this;
        }

        public Criteria andTraineenumberNotEqualTo(Integer value) {
            addCriterion("traineenumber <>", value, "traineenumber");
            return (Criteria) this;
        }

        public Criteria andTraineenumberGreaterThan(Integer value) {
            addCriterion("traineenumber >", value, "traineenumber");
            return (Criteria) this;
        }

        public Criteria andTraineenumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("traineenumber >=", value, "traineenumber");
            return (Criteria) this;
        }

        public Criteria andTraineenumberLessThan(Integer value) {
            addCriterion("traineenumber <", value, "traineenumber");
            return (Criteria) this;
        }

        public Criteria andTraineenumberLessThanOrEqualTo(Integer value) {
            addCriterion("traineenumber <=", value, "traineenumber");
            return (Criteria) this;
        }

        public Criteria andTraineenumberIn(List<Integer> values) {
            addCriterion("traineenumber in", values, "traineenumber");
            return (Criteria) this;
        }

        public Criteria andTraineenumberNotIn(List<Integer> values) {
            addCriterion("traineenumber not in", values, "traineenumber");
            return (Criteria) this;
        }

        public Criteria andTraineenumberBetween(Integer value1, Integer value2) {
            addCriterion("traineenumber between", value1, value2, "traineenumber");
            return (Criteria) this;
        }

        public Criteria andTraineenumberNotBetween(Integer value1, Integer value2) {
            addCriterion("traineenumber not between", value1, value2, "traineenumber");
            return (Criteria) this;
        }

        public Criteria andMaxnumberIsNull() {
            addCriterion("maxnumber is null");
            return (Criteria) this;
        }

        public Criteria andMaxnumberIsNotNull() {
            addCriterion("maxnumber is not null");
            return (Criteria) this;
        }

        public Criteria andMaxnumberEqualTo(Integer value) {
            addCriterion("maxnumber =", value, "maxnumber");
            return (Criteria) this;
        }

        public Criteria andMaxnumberNotEqualTo(Integer value) {
            addCriterion("maxnumber <>", value, "maxnumber");
            return (Criteria) this;
        }

        public Criteria andMaxnumberGreaterThan(Integer value) {
            addCriterion("maxnumber >", value, "maxnumber");
            return (Criteria) this;
        }

        public Criteria andMaxnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxnumber >=", value, "maxnumber");
            return (Criteria) this;
        }

        public Criteria andMaxnumberLessThan(Integer value) {
            addCriterion("maxnumber <", value, "maxnumber");
            return (Criteria) this;
        }

        public Criteria andMaxnumberLessThanOrEqualTo(Integer value) {
            addCriterion("maxnumber <=", value, "maxnumber");
            return (Criteria) this;
        }

        public Criteria andMaxnumberIn(List<Integer> values) {
            addCriterion("maxnumber in", values, "maxnumber");
            return (Criteria) this;
        }

        public Criteria andMaxnumberNotIn(List<Integer> values) {
            addCriterion("maxnumber not in", values, "maxnumber");
            return (Criteria) this;
        }

        public Criteria andMaxnumberBetween(Integer value1, Integer value2) {
            addCriterion("maxnumber between", value1, value2, "maxnumber");
            return (Criteria) this;
        }

        public Criteria andMaxnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("maxnumber not between", value1, value2, "maxnumber");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNull() {
            addCriterion("begindate is null");
            return (Criteria) this;
        }

        public Criteria andBegindateIsNotNull() {
            addCriterion("begindate is not null");
            return (Criteria) this;
        }

        public Criteria andBegindateEqualTo(Date value) {
            addCriterionForJDBCDate("begindate =", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotEqualTo(Date value) {
            addCriterionForJDBCDate("begindate <>", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThan(Date value) {
            addCriterionForJDBCDate("begindate >", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begindate >=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThan(Date value) {
            addCriterionForJDBCDate("begindate <", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("begindate <=", value, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateIn(List<Date> values) {
            addCriterionForJDBCDate("begindate in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotIn(List<Date> values) {
            addCriterionForJDBCDate("begindate not in", values, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begindate between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andBegindateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("begindate not between", value1, value2, "begindate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("enddate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("enddate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterionForJDBCDate("enddate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("enddate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterionForJDBCDate("enddate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enddate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterionForJDBCDate("enddate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("enddate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterionForJDBCDate("enddate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("enddate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enddate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("enddate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andScorestateIsNull() {
            addCriterion("scorestate is null");
            return (Criteria) this;
        }

        public Criteria andScorestateIsNotNull() {
            addCriterion("scorestate is not null");
            return (Criteria) this;
        }

        public Criteria andScorestateEqualTo(Integer value) {
            addCriterion("scorestate =", value, "scorestate");
            return (Criteria) this;
        }

        public Criteria andScorestateNotEqualTo(Integer value) {
            addCriterion("scorestate <>", value, "scorestate");
            return (Criteria) this;
        }

        public Criteria andScorestateGreaterThan(Integer value) {
            addCriterion("scorestate >", value, "scorestate");
            return (Criteria) this;
        }

        public Criteria andScorestateGreaterThanOrEqualTo(Integer value) {
            addCriterion("scorestate >=", value, "scorestate");
            return (Criteria) this;
        }

        public Criteria andScorestateLessThan(Integer value) {
            addCriterion("scorestate <", value, "scorestate");
            return (Criteria) this;
        }

        public Criteria andScorestateLessThanOrEqualTo(Integer value) {
            addCriterion("scorestate <=", value, "scorestate");
            return (Criteria) this;
        }

        public Criteria andScorestateIn(List<Integer> values) {
            addCriterion("scorestate in", values, "scorestate");
            return (Criteria) this;
        }

        public Criteria andScorestateNotIn(List<Integer> values) {
            addCriterion("scorestate not in", values, "scorestate");
            return (Criteria) this;
        }

        public Criteria andScorestateBetween(Integer value1, Integer value2) {
            addCriterion("scorestate between", value1, value2, "scorestate");
            return (Criteria) this;
        }

        public Criteria andScorestateNotBetween(Integer value1, Integer value2) {
            addCriterion("scorestate not between", value1, value2, "scorestate");
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