package base.controller;

import base.helper.CourseState;
import base.helper.RawCourse;
import base.model.*;
import base.service.CourseService;
import base.service.InstitutionService;
import base.service.LogService;
import base.utils.MyTool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by yugi on 2017/3/15.
 */
@Controller
@RequestMapping("/institution")
public class InstitutionController {

    @Resource
    InstitutionService institutionService;
    @Resource
    CourseService courseService;
    @Resource
    LogService logService;

    @RequestMapping("/Home")
    public String toHome(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.println("/institution/Home");
        String username = (String) session.getAttribute("username");
        Institution institution = institutionService.getInstitutionByUsername(username);
        model.addAttribute(institution);
        return "/institution/home";
    }

    @RequestMapping("/Launch_Course")
    public String launchCourse(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.println("/institution//Launch_Course");
        String username = (String) session.getAttribute("username");
        Institution institution = institutionService.getInstitutionByUsername(username);
        List<Rawcourse> rawcourseList = courseService.getRawCourseByInstitutionName(username);
        model.addAttribute(institution);
        model.addAttribute("list",rawcourseList);
        return "/institution/Launch_course";
    }
    @RequestMapping("/Launch")
    public String launch(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.println("/institution/Launch");
        String username = (String) session.getAttribute("username");
        Institution institution = institutionService.getInstitutionByUsername(username);
        String courseName = request.getParameter("courseName");
        String beginDate = request.getParameter("beginDate");
        String description = request.getParameter("description");
        String maxNumber = request.getParameter("maxNumber");
        String endDate = request.getParameter("endDate");
        String price = request.getParameter("price");

//        System.out.println(courseName);
        System.out.println(beginDate);
//        System.out.println(description);
//        System.out.println(maxNumber);
//        System.out.println(endDate);
//        System.out.println(price);
        RawCourse rawCourse = new RawCourse();
        rawCourse.setBeginDate(beginDate);
        rawCourse.setCourseName(courseName);
        rawCourse.setEndDate(endDate);
        rawCourse.setInstitutionid(institution.getId());
        rawCourse.setInstitutionName(username);
        rawCourse.setMaxNumber(Integer.parseInt(maxNumber));
        rawCourse.setPrice(Integer.parseInt(price));
        rawCourse.setDescription(description);

        boolean result = courseService.launchCourse(rawCourse);

        return "redirect:/institution/Launch_Course";
    }

    @RequestMapping("/Modify_Course")
    public String modifyCourse(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.println("/institution/Modify_Course");
        String username = (String) session.getAttribute("username");
        Institution institution = institutionService.getInstitutionByUsername(username);
        List<Course> courseList0 = new ArrayList<>();
        List<Course> courseList1 = new ArrayList<>();
        List<Course> courseList = courseService.getCourseByInstitutionName(username);
        ListIterator listIterator = courseList.listIterator();
        while (listIterator.hasNext()) {
            Course course = (Course) listIterator.next();
            CourseState state = MyTool.courseStateCheck(course.getBegindate(), course.getEnddate());
            switch (state) {
                case PRE:
                    courseList0.add(course);
                    break;
                case IN:
                    courseList1.add(course);
                    break;
            }
        }

        model.addAttribute(institution);
        model.addAttribute("prelist",courseList0);
        model.addAttribute("inlist",courseList1);
        return "/institution/Modify_course";
    }

    @RequestMapping("/Subscribe_Log")
    public String subscribeLog(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.println("/institution/Subscribe_Log");
        String username = (String) session.getAttribute("username");
        Institution institution = institutionService.getInstitutionByUsername(username);
        int courseid = Integer.parseInt(request.getParameter("classid"));
        String institutionid = request.getParameter("institutionid");
        List<TcourseKey> tcourseKeyList = courseService.getTraineeByCourseid(courseid);
        List<Subscribelog> subscribelogList = logService.getSubscribelogByCourse(courseid);
        List<Unsubscribelog> unsubscribelogList = logService.getUnsubscribelogByCourse(courseid);
        List<Droplog> droplogList = logService.getDroplogByCourse(courseid);

        model.addAttribute(institution);
        model.addAttribute("list1",tcourseKeyList);
        model.addAttribute("list2",subscribelogList);
        model.addAttribute("list3",unsubscribelogList);
        model.addAttribute("list4",droplogList);
        return "/institution/Subscribe_log";
    }

    @RequestMapping("/Score_Registrate")
    public String scoreRegistrate(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.println("/institution/Home");
        String username = (String) session.getAttribute("username");
        Institution institution = institutionService.getInstitutionByUsername(username);
        model.addAttribute(institution);
        return "/institution//Score_registrate";
    }

    @RequestMapping("/Course_Income")
    public String courseIncome(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.println("/institution/Home");
        String username = (String) session.getAttribute("username");
        Institution institution = institutionService.getInstitutionByUsername(username);
        model.addAttribute(institution);
        return "/institution//Course_income";
    }

}
