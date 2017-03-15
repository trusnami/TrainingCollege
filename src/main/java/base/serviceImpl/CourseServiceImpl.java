package base.serviceImpl;

import base.mapper.CourseMapper;
import base.mapper.TcourseMapper;
import base.mapper.TraineeMapper;
import base.model.*;
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
    @Resource
    TraineeMapper traineeMapper;

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
                    if (course.getState()==0) {
                        result.add(course);
                    }
                }

            }

        }

        else {

            ListIterator listIterator1 = courseList.listIterator();
            result = new ArrayList<Course>();

            while (listIterator1.hasNext()){
                Course course = (Course) listIterator1.next();
                if (course.getState()==0) {
                    result.add(course);
                }
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
        TraineeExample traineeExample = new TraineeExample();
        TraineeExample.Criteria criteria = traineeExample.createCriteria();
        criteria.andIdEqualTo(Integer.parseInt(traineeid));
        List<Trainee> traineeList = traineeMapper.selectByExample(traineeExample);
        Trainee trainee = traineeList.get(0);

        int traineenumber = course.getTraineenumber();
        traineenumber++;
        course.setTraineenumber(traineenumber);

        int price = course.getPrice();
        double balance = trainee.getBalance();
        balance = balance - price;
        trainee.setBalance(balance);

        int result1 = courseMapper.updateByPrimaryKeySelective(course);
        int result2 = traineeMapper.updateByPrimaryKey(trainee);

        return false;
    }

    @Override
    public List<Integer> getChosenCourseid(int traineeid) throws Exception {
        TcourseExample tcourseExample = new TcourseExample();
        TcourseExample.Criteria criteria = tcourseExample.createCriteria();
        criteria.andTraineeidEqualTo(traineeid);
        List<TcourseKey> tcourseKeyList = tcourseMapper.selectByExample(tcourseExample);
        List<Integer> courseidList = new ArrayList<>();
        ListIterator listIterator = tcourseKeyList.listIterator();
        while (listIterator.hasNext()){
            TcourseKey tcourseKey = (TcourseKey) listIterator.next();
            Integer courseid = tcourseKey.getClassid();
            courseidList.add(courseid);
        }

        return courseidList;
    }

    @Override
    public Course getCourseByid(int classid) throws Exception {
        Course course = courseMapper.selectByPrimaryKey(classid);
        return course;
    }

    @Override
    public List<Course> getCourseByid(List<Integer> courseidList) throws Exception {
        List<Course> courseList = new ArrayList<>();
        ListIterator listIterator = courseidList.listIterator();
        while (listIterator.hasNext()){
            Integer courseid = (Integer) listIterator.next();
            Course course = getCourseByid(courseid);
            courseList.add(course);
        }
        return courseList;
    }


}
