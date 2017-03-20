package base.model;

import java.util.Date;

public class Course {
    private Integer classid;

    private String classname;

    private Integer institutionid;

    private String institutionname;

    private Integer traineenumber;

    private Integer maxnumber;

    private String description;

    private Integer price;

    private Date begindate;

    private Date enddate;

    private Integer scorestate;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Integer getInstitutionid() {
        return institutionid;
    }

    public void setInstitutionid(Integer institutionid) {
        this.institutionid = institutionid;
    }

    public String getInstitutionname() {
        return institutionname;
    }

    public void setInstitutionname(String institutionname) {
        this.institutionname = institutionname == null ? null : institutionname.trim();
    }

    public Integer getTraineenumber() {
        return traineenumber;
    }

    public void setTraineenumber(Integer traineenumber) {
        this.traineenumber = traineenumber;
    }

    public Integer getMaxnumber() {
        return maxnumber;
    }

    public void setMaxnumber(Integer maxnumber) {
        this.maxnumber = maxnumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getScorestate() {
        return scorestate;
    }

    public void setScorestate(Integer scorestate) {
        this.scorestate = scorestate;
    }
}