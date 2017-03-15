package base.controller;

import base.service.CourseService;
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
}