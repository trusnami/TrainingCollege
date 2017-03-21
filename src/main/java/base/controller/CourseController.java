package base.controller;

import base.model.Course;
import base.model.Institution;
import base.service.CourseService;
import base.service.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yugi on 2017/3/14.
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Resource
    CourseService courseService;
    @Resource
    InstitutionService institutionService;

    @RequestMapping("/subscribe")
    public String unbind(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws Exception {
        System.out.print("/course/subscribe\n");

        String traineeid = request.getParameter("traineeid");
        String classid = request.getParameter("classid");

        boolean result = courseService.subscribe(traineeid,classid);

        return "redirect:/trainee//C_Subscribe";
    }

    @RequestMapping("/unsubscribe")
    public String unsubscribe(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws Exception {
        System.out.print("/course/unsubscribe\n");

        String traineeid = request.getParameter("traineeid");
        String classid = request.getParameter("classid");

        boolean result = courseService.unsubcribe(traineeid,classid);

        return "redirect:/trainee/C_Unsubscribe";
    }

    @RequestMapping("/drop")
    public String dropCourse(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws Exception {
        System.out.print("/course/unsubscribe\n");

        String traineeid = request.getParameter("traineeid");
        String classid = request.getParameter("classid");

        boolean result = courseService.dropCourse(traineeid,classid);

        return "redirect:/trainee/C_Unsubscribe";
    }

    @RequestMapping("/modifyCourse0")
    public String modifyCourse0(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws Exception {
        System.out.print("/course/modifyCourse0\n");
        String courseid = request.getParameter("classid");
        String institutionid = request.getParameter("institutionid");
        Institution institution = institutionService.getInstitutionByid(institutionid);
        Course course = courseService.getCourseByid(Integer.parseInt(courseid));
        model.addAttribute(course);
        model.addAttribute(institution);
        return "/institution/Modify_course0";
    }

    @RequestMapping("/modifyCourse1")
    public String modifyCourse1(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws Exception {
        System.out.print("/course/modifyCourse1\n");
        String courseid = request.getParameter("classid");
        String institutionid = request.getParameter("institutionid");
        Institution institution = institutionService.getInstitutionByid(institutionid);
        Course course = courseService.getCourseByid(Integer.parseInt(courseid));
        model.addAttribute(course);
        model.addAttribute(institution);
        return "/institution/Modify_course1";
    }

    @RequestMapping("/getTraineeByCourseid")
    public String getTraineeByCourseid(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws Exception {
        System.out.print("/course/getTraineeByCourseid\n");


        return "redirect:/trainee/C_Unsubscribe";
    }

    @RequestMapping("/applyUpdateCourse")
    public String applyUpdateCourse(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws Exception {
        System.out.print("/course/applyUpdateCourse\n");
        String courseid = request.getParameter("courseid");
        String courseName = request.getParameter("courseName");
        String beginDate = request.getParameter("beginDate");
        String description = request.getParameter("description");
        String maxNumber = request.getParameter("maxNumber");
        String endDate = request.getParameter("endDate");
        String price = request.getParameter("price");
        System.out.print("courseid:"+courseid+"\n");

        boolean result = courseService.applyModifyCourse(courseid,courseName,beginDate,description,
                maxNumber,endDate,price);

        return "redirect:/institution/Modify_Course";
    }


    @RequestMapping("/approve")
    public String approve(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws Exception {
        System.out.print("/course/approve\n");
        int courseid = Integer.parseInt(request.getParameter("courseid"));
        boolean result = courseService.approveCourse(courseid);

        return "redirect:/Manager/Approve_Launch";
    }

    @RequestMapping("/approveModify")
    public String approveModify(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws Exception {
        System.out.print("/course/approve\n");
        int logid = Integer.parseInt(request.getParameter("logid"));
        System.out.print("logid:"+logid+"\n");
        boolean result = courseService.approveModifyCourse(logid);

        return "redirect:/Manager/Approve_Modify";
    }

}