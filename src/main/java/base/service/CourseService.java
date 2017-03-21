package base.service;

import base.helper.RawCourse;
import base.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yugi on 2017/3/14.
 */
@Service
public interface CourseService {

    ArrayList<Course> getUnsubscribedClass(int traineeid) throws Exception;

    boolean subscribe (String traineeid,String classid) throws Exception;

    List<Integer> getChosenCourseid(int traineeid) throws Exception;

    Course getCourseByid(int classid) throws  Exception;

    List<Course> getCourseByid(List<Integer> courseidList) throws Exception;

    boolean unsubcribe (String traineeid,String classid) throws Exception;

    boolean dropCourse (String traineeid,String classid) throws Exception;

    boolean launchCourse (RawCourse rawCourse) throws Exception;

    List<Rawcourse> getRawCourseByInstitutionName (String institutionName) throws Exception;

    List<Course> getCourseByInstitutionName (String institutionName) throws Exception;

    boolean applyModifyCourse (String courseid,String courseName,String beginDate,
                               String description,String maxNumber,String endDate,
                               String price) throws Exception;

    List<TcourseKey> getTraineeByCourseid(int courseid) throws Exception;

    List<Course> getFinishedCourse(int institutionid) throws Exception;

    boolean setCourseScoreFinished(int courseid) throws Exception;

    boolean approveCourse(int courseid) throws Exception;

    boolean approveModifyCourse(int logid) throws Exception;

    boolean setCourseSettleFinished(int courseid) throws Exception;
}
