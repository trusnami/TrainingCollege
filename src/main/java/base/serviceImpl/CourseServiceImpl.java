package base.serviceImpl;

import base.helper.CourseState;
import base.helper.RawCourse;
import base.mapper.*;
import base.model.*;
import base.service.CourseService;
import base.utils.MyTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Resource
    SubscribelogMapper subscribelogMapper;
    @Resource
    UnsubscribelogMapper unsubscribelogMapper;
    @Resource
    DroplogMapper droplogMapper;
    @Resource
    RawcourseMapper rawcourseMapper;
    @Resource
    ApproveoldMapper approveoldMapper;

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
                    CourseState state = MyTool.courseStateCheck(course.getBegindate(),course.getEnddate());
                    if (state == CourseState.PRE) {
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
                CourseState state = MyTool.courseStateCheck(course.getBegindate(),course.getEnddate());
                if (state == CourseState.PRE) {
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

        Subscribelog subscribelog = new Subscribelog();
        subscribelog.setTime(new Date());
        subscribelog.setTraineeid(Integer.parseInt(traineeid));
        subscribelog.setCourseid(Integer.parseInt(classid));
        subscribelog.setDeduction(price);

        int result0 = subscribelogMapper.insert(subscribelog);
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

    @Override
    public List<Course> getCourseByTraineeid(int traineeid) throws Exception {
        List<Integer> courseidList = getChosenCourseid(traineeid);
        List<Course> courseList = getCourseByid(courseidList);
        return courseList;
    }

    @Override
    public boolean unsubcribe(String traineeid, String classid) throws Exception {
        TcourseKey tcourseKey = new TcourseKey();
        tcourseKey.setTraineeid(Integer.parseInt(traineeid));
        tcourseKey.setClassid(Integer.parseInt(classid));

        int result = tcourseMapper.deleteByPrimaryKey(tcourseKey);

        Course course = courseMapper.selectByPrimaryKey(Integer.parseInt(classid));
        TraineeExample traineeExample = new TraineeExample();
        TraineeExample.Criteria criteria = traineeExample.createCriteria();
        criteria.andIdEqualTo(Integer.parseInt(traineeid));
        List<Trainee> traineeList = traineeMapper.selectByExample(traineeExample);
        Trainee trainee = traineeList.get(0);

        int traineenumber = course.getTraineenumber();
        traineenumber--;
        course.setTraineenumber(traineenumber);

        int price = course.getPrice();
        double balance = trainee.getBalance();
        balance = balance + price;
        trainee.setBalance(balance);

        Unsubscribelog unsubscribelog = new Unsubscribelog();
        unsubscribelog.setCourseid(Integer.parseInt(classid));
        unsubscribelog.setTime(new Date());
        unsubscribelog.setTraineeid(Integer.parseInt(traineeid));
        unsubscribelog.setRefund(price);

        int result0 = unsubscribelogMapper.insert(unsubscribelog);
        int result1 = courseMapper.updateByPrimaryKeySelective(course);
        int result2 = traineeMapper.updateByPrimaryKey(trainee);

        return false;
    }

    @Override
    public boolean dropCourse(String traineeid, String classid) throws Exception {
        TcourseKey tcourseKey = new TcourseKey();
        tcourseKey.setTraineeid(Integer.parseInt(traineeid));
        tcourseKey.setClassid(Integer.parseInt(classid));

        int result = tcourseMapper.deleteByPrimaryKey(tcourseKey);

        Course course = courseMapper.selectByPrimaryKey(Integer.parseInt(classid));
        TraineeExample traineeExample = new TraineeExample();
        TraineeExample.Criteria criteria = traineeExample.createCriteria();
        criteria.andIdEqualTo(Integer.parseInt(traineeid));
        List<Trainee> traineeList = traineeMapper.selectByExample(traineeExample);
        Trainee trainee = traineeList.get(0);

        int traineenumber = course.getTraineenumber();
        traineenumber--;
        course.setTraineenumber(traineenumber);

        int price = course.getPrice();
        double balance = trainee.getBalance();
        balance = balance + price/2;
        trainee.setBalance(balance);

        Droplog droplog = new Droplog();
        droplog.setRefund(price/2);
        droplog.setCourseid(Integer.parseInt(classid));
        droplog.setTraineeid(Integer.parseInt(traineeid));
        droplog.setTime(new Date());

        int result0 = droplogMapper.insert(droplog);
        int result1 = courseMapper.updateByPrimaryKeySelective(course);
        int result2 = traineeMapper.updateByPrimaryKey(trainee);

        return false;
    }

    @Override
    public boolean launchCourse(RawCourse rawCourse) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date beginDate = dateFormat.parse(rawCourse.getBeginDate());
        Date endDate = dateFormat.parse(rawCourse.getEndDate());

        Rawcourse rawcourse = new Rawcourse();
        rawcourse.setDescription(rawCourse.getDescription());
        rawcourse.setBegindate(beginDate);
        rawcourse.setCoursename(rawCourse.getCourseName());
        rawcourse.setEnddate(endDate);
        rawcourse.setInstitutionid(rawCourse.getInstitutionid());
        rawcourse.setInstitutionname(rawCourse.getInstitutionName());
        rawcourse.setMaxnumber(rawCourse.getMaxNumber());
        rawcourse.setPrice(rawCourse.getPrice());

        int result = rawcourseMapper.insertSelective(rawcourse);

        return false;
    }

    @Override
    public List<Rawcourse> getRawCourseByInstitutionName(String institutionName) throws Exception {
        RawcourseExample rawcourseExample = new RawcourseExample();
        RawcourseExample.Criteria criteria = rawcourseExample.createCriteria();
        criteria.andInstitutionnameEqualTo(institutionName);
        criteria.andStateEqualTo(0);
        List<Rawcourse> rawcourseList = rawcourseMapper.selectByExample(rawcourseExample);
        return rawcourseList;
    }

    @Override
    public List<Course> getCourseByInstitutionName(String institutionName) throws Exception {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andInstitutionnameEqualTo(institutionName);
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        return courseList;
    }

    @Override
    public List<Course> getCourseByInstitutionId(int institutionid) throws Exception {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andInstitutionidEqualTo(institutionid);
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        return courseList;
    }

    @Override
    public boolean applyModifyCourse(String courseid,String courseName, String beginDate,
                                     String description, String maxNumber, String endDate,
                                     String price) throws Exception {
        Approveold approveold = new Approveold();
        approveold.setClassid(Integer.parseInt(courseid));
        approveold.setClassname(courseName);

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

        approveold.setBegindate(dateFormat.parse(beginDate));
        approveold.setEnddate(dateFormat.parse(endDate));
        approveold.setDescription(description);
        approveold.setMaxnumber(Integer.parseInt(maxNumber));
        approveold.setPrice(Integer.parseInt(price));

        int result = approveoldMapper.insertSelective(approveold);

        return false;
    }

    @Override
    public List<TcourseKey> getTraineeByCourseid(int courseid) throws Exception {
        TcourseExample tcourseExample = new TcourseExample();
        TcourseExample.Criteria criteria = tcourseExample.createCriteria();
        criteria.andClassidEqualTo(courseid);
        List<TcourseKey> traineeList = tcourseMapper.selectByExample(tcourseExample);
        return traineeList;
    }

    @Override
    public List<Course> getFinishedCourse(int institutionid) throws Exception {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andInstitutionidEqualTo(institutionid);
        List<Course> courseList = courseMapper.selectByExample(courseExample);
        List<Course> resultList = new ArrayList<>();
        ListIterator listIterator = courseList.listIterator();
        while (listIterator.hasNext()){
            Course course = (Course) listIterator.next();
            if (MyTool.courseStateCheck(course.getBegindate(), course.getEnddate())==CourseState.POST){
                resultList.add(course);
            }
        }
        return resultList;
    }

    @Override
    public boolean setCourseScoreFinished(int courseid) throws Exception {
        Course course = new Course();
        course.setClassid(courseid);
        course.setScorestate(1);
        int result = courseMapper.updateByPrimaryKeySelective(course);
        return false;
    }

    @Override
    public boolean approveCourse(int courseid) throws Exception {
        Rawcourse rawcourse = rawcourseMapper.selectByPrimaryKey(courseid);
        rawcourse.setState(1);
        int result = rawcourseMapper.updateByPrimaryKey(rawcourse);
        Course course = new Course();
        course.setScorestate(0);
        course.setClassid(courseid);
        course.setBegindate(rawcourse.getBegindate());
        course.setPrice(rawcourse.getPrice());
        course.setClassname(rawcourse.getCoursename());
        course.setDescription(rawcourse.getDescription());
        course.setEnddate(rawcourse.getEnddate());
        course.setInstitutionid(rawcourse.getInstitutionid());
        course.setMaxnumber(rawcourse.getMaxnumber());
        course.setInstitutionname(rawcourse.getInstitutionname());
        course.setTraineenumber(0);
        int result1 = courseMapper.insert(course);

        return false;
    }

    @Override
    public boolean approveModifyCourse(int logid) throws Exception {
        Approveold approveold = approveoldMapper.selectByPrimaryKey(logid);
        approveold.setState(1);
        int result = approveoldMapper.updateByPrimaryKey(approveold);
        Course course = new Course();
        course.setBegindate(approveold.getBegindate());
        course.setMaxnumber(approveold.getMaxnumber());
        course.setEnddate(approveold.getEnddate());
        course.setPrice(approveold.getPrice());
        course.setDescription(approveold.getDescription());
        course.setClassname(approveold.getClassname());
        int result1 = courseMapper.updateByPrimaryKeySelective(course);

        return false;
    }

    @Override
    public boolean setCourseSettleFinished(int courseid) throws Exception {
        Course course = courseMapper.selectByPrimaryKey(courseid);
        course.setScorestate(2);
        int result = courseMapper.updateByPrimaryKey(course);

        return false;
    }


}
