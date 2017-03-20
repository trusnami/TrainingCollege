package base.controller;

import base.model.Institution;
import base.model.Score;
import base.model.TcourseKey;
import base.service.CourseService;
import base.service.InstitutionService;
import base.service.ScoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by yugi on 2017/3/20.
 */
@Controller
@RequestMapping("/score")
public class ScoreController {

    @Resource
    CourseService courseService;
    @Resource
    InstitutionService institutionService;
    @Resource
    ScoreService scoreService;

    @RequestMapping("/register")
    public String register(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.println("/score/register");
        int courseid = Integer.parseInt(request.getParameter("classid"));
        int institutionid = Integer.parseInt(request.getParameter("institutionid"));
        List<TcourseKey> tcourseKeyList = courseService.getTraineeByCourseid(courseid);
        String username = (String) session.getAttribute("username");
        Institution institution = institutionService.getInstitutionByUsername(username);
        model.addAttribute("courseid",courseid);
        model.addAttribute(institution);
        model.addAttribute("list",tcourseKeyList);
        return "/institution/Score_register";
    }


    @RequestMapping("/registered")
    public String registered(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.println("/score/registered");
        String username = (String) session.getAttribute("username");
        Institution institution = institutionService.getInstitutionByUsername(username);
//        System.out.println("courseid:"+request.getParameter("courseid"));
//        System.out.println("1000001:"+request.getParameter("1000001"));
//        System.out.println("1000002:"+request.getParameter("1000002"));
//        System.out.println("1000003:"+request.getParameter("1000003"));
//        System.out.println("1000004:"+request.getParameter("1000004"));
//        System.out.println("1000005:"+request.getParameter("1000005"));
        int courseid = Integer.parseInt(request.getParameter("courseid"));
        List<TcourseKey> tcourseKeyList = courseService.getTraineeByCourseid(courseid);
        ListIterator listIterator = tcourseKeyList.listIterator();
        while (listIterator.hasNext()){
            TcourseKey tcourseKey = (TcourseKey) listIterator.next();
            int traineeid =tcourseKey.getTraineeid();
            Score score = new Score();
            score.setCourseid(courseid);
            score.setTraineeid(traineeid);
            score.setScore(Integer.parseInt(request.getParameter(traineeid+"")));
            boolean result = scoreService.addScore(score);
        }
        boolean result1 = courseService.setCourseScoreFinished(courseid);
        return "redirect:/institution/Score_Registrate";
    }

    @RequestMapping("/check")
    public String check(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.println("/score/check");
        int courseid = Integer.parseInt(request.getParameter("classid"));
        int institutionid = Integer.parseInt(request.getParameter("institutionid"));
        List<TcourseKey> tcourseKeyList = courseService.getTraineeByCourseid(courseid);
        String username = (String) session.getAttribute("username");
        Institution institution = institutionService.getInstitutionByUsername(username);
        List<Score> scoreList = scoreService.getScoreByCourseid(courseid);

        model.addAttribute("courseid",courseid);
        model.addAttribute(institution);
        model.addAttribute("list",scoreList);
        return "/institution/Score_check";
    }

}
