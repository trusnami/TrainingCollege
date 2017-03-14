package base.service;

import base.model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by yugi on 2017/3/14.
 */
@Service
public interface CourseService {

    ArrayList<Course> getUnsubscribedClass(int traineeid) throws Exception;

    boolean subscribe (String traineeid,String classid) throws Exception;

}
