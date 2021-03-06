package base.controller;

import base.helper.MCourse;
import base.model.*;
import base.service.*;
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
 * Created by yugi on 2017/3/20.
 */
@Controller
@RequestMapping("/Manager")
public class ManagerController {

    @Resource
    ManagerService managerService;
    @Resource
    InstitutionService institutionService;
    @Resource
    TraineeService traineeService;
    @Resource
    CourseService courseService;
    @Resource
    LogService logService;

    @RequestMapping("/Home")
    public String toHome (HttpServletRequest request, RedirectAttributes attributes,
                          HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Home");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);

        model.addAttribute(manager);

        return "/manager/home";
    }

    @RequestMapping("/Approve_Launch")
    public String approveLaunch (HttpServletRequest request, RedirectAttributes attributes,
                                 HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Approve_Launch");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);
        List<Rawcourse> rawcourseList = managerService.getRawCourse();

        model.addAttribute(manager);
        model.addAttribute("list",rawcourseList);

        return "/manager/Approve_launch";
    }

    @RequestMapping("/Approve_Modify")
    public String approveModify (HttpServletRequest request, RedirectAttributes attributes,
                                 HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Approve_Modify");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);
        List<Approveold> approveoldList = managerService.getModifyCourse();

        model.addAttribute(manager);
        model.addAttribute("list",approveoldList);

        return "/manager/Approve_modify";
    }

    @RequestMapping("/Settle")
    public String settle (HttpServletRequest request, RedirectAttributes attributes,
                          HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Settle");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);
        List<Course> courseList = managerService.getScoredCourse();
        List<MCourse> mCourseList = new ArrayList<>();
        ListIterator listIterator = courseList.listIterator();
        double discount = 0.8;
        while (listIterator.hasNext()){
            Course course = (Course) listIterator.next();
            MCourse mCourse = new MCourse(course,discount);
            mCourseList.add(mCourse);
        }

//        System.out.println("/Manager/Settle size:"+mCourseList.size());
        model.addAttribute(manager);
        model.addAttribute("list",mCourseList);

        return "/manager/settle";
    }

    @RequestMapping("/Institution_Info")
    public String institutionInfo (HttpServletRequest request, RedirectAttributes attributes,
                                   HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Institution_Info");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);
        List<Institution> institutionList = institutionService.getAllInstitution();
        System.out.println("institutionList size:"+institutionList.size());
        model.addAttribute(manager);
        model.addAttribute("list",institutionList);

        return "/manager/Institution_info";
    }

    @RequestMapping("/Trainee_Info")
    public String trianeenInfo (HttpServletRequest request, RedirectAttributes attributes,
                                HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Trainee_Info");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);
        List<Trainee> traineeList = traineeService.getAlltrainee();
        System.out.println("traineeList size:"+traineeList.size());
        model.addAttribute(manager);
        model.addAttribute("list",traineeList);

        return "/manager/Trainee_info";
    }

    @RequestMapping("/Finance_Info")
    public String financeInfo (HttpServletRequest request, RedirectAttributes attributes,
                               HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Finance_Info");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);
        List<Settlelog> settlelogList = managerService.getAllSettlelog();
        List<Rechargelog> rechargelogList = logService.getAllRechargelog();
        System.out.println("settlelogList size:"+settlelogList.size());
        model.addAttribute(manager);
        model.addAttribute("list",settlelogList);
        model.addAttribute("list1",rechargelogList);
        return "/manager/Finance_info";
    }

    @RequestMapping("/Institution_Course")
    public String institutionCourse(HttpServletRequest request, RedirectAttributes attributes,
                                    HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Institution_Course");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);
        int institutionid = Integer.parseInt(request.getParameter("institutionid"));
        List<Course> courseList = courseService.getCourseByInstitutionId(institutionid);
        model.addAttribute(manager);
        model.addAttribute("list",courseList);
        return "/manager/Institution_course";
    }

    @RequestMapping("/Trainee_Course")
    public String traineeCourse(HttpServletRequest request, RedirectAttributes attributes,
                                    HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Trainee_Course");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);
        int traineeid = Integer.parseInt(request.getParameter("traineeid"));
        List<Course> courseList = courseService.getCourseByTraineeid(traineeid);
        model.addAttribute(manager);
        model.addAttribute("list",courseList);
        return "/manager/Trainee_course";
    }

}
