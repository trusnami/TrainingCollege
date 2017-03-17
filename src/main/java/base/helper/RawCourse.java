package base.helper;

/**
 * Created by yugi on 2017/3/17.
 */
public class RawCourse {
    private int institutionid;
    private String institutionName;
    private String courseName;
    private String beginDate;
    private String endDate;
    private int MaxNumber;
    private int price;
    private String description;


    public void setInstitutionid(int institutionid) {
        this.institutionid = institutionid;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setMaxNumber(int maxNumber) {
        MaxNumber = maxNumber;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInstitutionid() {
        return institutionid;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getMaxNumber() {
        return MaxNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

}
