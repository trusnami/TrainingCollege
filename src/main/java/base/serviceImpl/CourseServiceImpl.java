package base.serviceImpl;

import base.mapper.CourseMapper;
import base.mapper.TcourseMapper;
import base.model.Course;
import base.model.CourseExample;
import base.model.TcourseExample;
import base.model.TcourseKey;
import base.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by yugi on 2017/3/14.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Resource
    CourseMapper courseMapper;
    @Resource
    TcourseMapper tcourseMapper;


    @Override
    public ArrayList<Course> getUnsubscribedClass(int traineeid) throws Exception {

        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTraineenumberLessThan(50);
        List<Course> courseList = courseMapper.selectByExample(courseExample);

        TcourseExample tcourseExample = new TcourseExample();
        TcourseExample.Criteria criteria1 = tcourseExample.createCriteria();
        criteria1.andTraineeidEqualTo(traineeid);
        List<TcourseKey> tcourseKeyList = tcourseMapper.selectByExample(tcourseExample);

        ArrayList<Course> result = null;

        if (!tcourseKeyList.isEmpty()) {
            ListIterator listIterator = tcourseKeyList.listIterator();
            int[] courseidList = new int[tcourseKeyList.size()];
            int i = 0;
            while (listIterator.hasNext()) {
                TcourseKey tcourseKey = (TcourseKey) listIterator.next();
                courseidList[i] = tcourseKey.getClassid();
                i++;
            }

            ListIterator listIterator1 = courseList.listIterator();
            result = new ArrayList<Course>();

            while (listIterator1.hasNext()){
                Course course = (Course) listIterator1.next();
                int courseid = course.getClassid();
                boolean exist = false;
                for (int j = 0;j<courseidList.length;j++){
                    if (courseidList[j]==courseid){
                        exist = true;
                        break;
                    }
                }
                if (!exist){
                    result.add(course);
                }

            }

        }

        else {

            ListIterator listIterator1 = courseList.listIterator();
            result = new ArrayList<Course>();

            while (listIterator1.hasNext()){
                Course course = (Course) listIterator1.next();
                result.add(course);
            }

        }

        return result;
    }

    @Override
    public boolean subscribe(String traineeid, String classid) throws Exception {

        TcourseKey tcourseKey = new TcourseKey();
        tcourseKey.setTraineeid(Integer.parseInt(traineeid));
        tcourseKey.setClassid(Integer.parseInt(classid));

        int result = tcourseMapper.insert(tcourseKey);

        Course course = courseMapper.selectByPrimaryKey(Integer.parseInt(classid));
        int traineenumber = course.getTraineenumber();
        traineenumber++;
        course.setTraineenumber(traineenumber);
        int result1 = courseMapper.updateByPrimaryKeySelective(course);

        return false;
    }
}
