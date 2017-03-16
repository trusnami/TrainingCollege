package base.model;

import java.util.Date;

public class UnsubscribelogKey {
    private Integer courseid;

    private Integer traineeid;

    private Date time;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getTraineeid() {
        return traineeid;
    }

    public void setTraineeid(Integer traineeid) {
        this.traineeid = traineeid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}