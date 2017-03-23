package base.helper;

import base.model.Course;

import java.util.Date;

/**
 * Created by yugi on 2017/3/23.
 */
public class ScoreCourse {

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

    private int score;

    public ScoreCourse(Course course, int score){
        this.classid = course.getClassid();
        this.classname = course.getClassname();
        this.institutionid = course.getInstitutionid();
        this.institutionname = course.getInstitutionname();
        this.traineenumber = course.getTraineenumber();
        this.maxnumber = course.getMaxnumber();
        this.description = course.getDescription();
        this.price = course.getPrice();
        this.begindate = course.getBegindate();
        this.enddate = course.getEnddate();
        this.score = score;
    }

    public Integer getClassid() {
        return classid;
    }

    public String getClassname() {
        return classname;
    }

    public Integer getInstitutionid() {
        return institutionid;
    }

    public String getInstitutionname() {
        return institutionname;
    }

    public Integer getTraineenumber() {
        return traineenumber;
    }

    public Integer getMaxnumber() {
        return maxnumber;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public Date getBegindate() {
        return begindate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public int getScore() {
        return score;
    }
}
