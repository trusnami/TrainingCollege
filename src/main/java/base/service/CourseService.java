package base.service;

import base.model.Course;
import base.model.TcourseKey;
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

}
