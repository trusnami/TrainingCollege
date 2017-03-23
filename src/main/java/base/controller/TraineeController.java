package base.controller;

import base.helper.CourseState;
import base.helper.ScoreCourse;
import base.model.*;
import base.service.*;
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
 * Created by yugi on 2017/3/13.
 */
@Controller
@RequestMapping("/trainee")
public class TraineeController {

    @Resource
    TraineeService traineeService;
    @Resource
    CardService cardService;
    @Resource
    CourseService courseService;
    @Resource
    LogService logService;
    @Resource
    ScoreService scoreService;

    @RequestMapping("/Home")
    public String toHome(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {

        String username = (String) session.getAttribute("username");
        //String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        session.setAttribute("id",trainee.getId());

        model.addAttribute(trainee);

        return "/trainee/TraineeHome";
    }

    @RequestMapping("/M_Binding_Unbinding")
    public String toBU(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {

        String username = (String) session.getAttribute("username");
        //String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        int id = trainee.getId();

        List<Card> cardList = cardService.getCardByTraineeId(id);

        model.addAttribute(trainee);

        if (cardList == null){
            return "/trainee/TraineeHome";
        }

//        for (int i = 0;i<cardList.size();i++){
//            System.out.print(cardList.get(i).getCardnumber()+"\n");
//        }

        model.addAttribute(cardList);

        return "/trainee/M_Binding_Unbinding";
    }

    @RequestMapping("/M_Activated_frozen")
    public String toAF(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {

//        System.out.print("/M_Activated_frozen\n");
        String username = (String) session.getAttribute("username");
        //String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        int id = trainee.getId();
        session.setAttribute("id",id);

        List<Card> cardList = cardService.getCardByTraineeId(id);

        model.addAttribute(trainee);

        if (cardList == null){
            return "/trainee/TraineeHome";
        }

//        for (int i = 0;i<cardList.size();i++){
//            System.out.print(cardList.get(i).getCardnumber()+"\n");
//        }

        model.addAttribute(cardList);

        return "/trainee/M_Activated_Frozen";
    }

    @RequestMapping("/recharge")
    public String recharge(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.print("/recharge\n");
        String number = request.getParameter("rechargeAmount");
        String username = (String) session.getAttribute("username");
        System.out.print(number+"\n");
        boolean result = traineeService.addBalance(username,number);



        return "redirect:/trainee/M_Activated_frozen";
    }

    @RequestMapping("exchange")
    public  String exchange(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.print("/exchange\n");

        String money = request.getParameter("money");
        String username = (String) session.getAttribute("username");

        int result = traineeService.exchange(username,Integer.parseInt(money));

        System.out.print("exchange result: "+result+"\n");

        switch (result){
            case 0:
                return "redirect:/trainee/M_Activated_frozen";
            case 1:
                break;
            case 2:
                break;
            default:

        }

        return "redirect:/trainee/M_Activated_frozen";
    }

    @RequestMapping("/M_Level_Point")
    public String toLP(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {

        String username = (String) session.getAttribute("username");
        //String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        model.addAttribute(trainee);

        return "/trainee/M_Level_Point";
    }

    @RequestMapping("/C_Subscribe")
    public String toS(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
//        System.out.println("/C_Subscribe");
        String username = (String) session.getAttribute("username");
        //String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        int traineeid = trainee.getId();
        List<Course> courseArrayList = courseService.getUnsubscribedClass(traineeid);

//        if (courseArrayList!=null){
//            for (int i=0;i<courseArrayList.size();i++){
//                System.out.println(courseArrayList.get(i).getClassid());
//            }
//        }

//        System.out.println("size:"+courseArrayList.size());

//        List<String> stringList = new ArrayList<>();
//        stringList.add("a");
//        stringList.add("b");

        model.addAttribute(trainee);
        model.addAttribute("list",courseArrayList);

        return "/trainee/C_subscribe";
    }

    @RequestMapping("/C_Unsubscribe")
    public String toU(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {

        String username = (String) session.getAttribute("username");
        //String password = (String) session.getAttribute("password");

        List<Course> courseList0 = new ArrayList<>();
        List<Course> courseList1 = new ArrayList<>();
        List<Course> courseList2 = new ArrayList<>();
        List<Course> courseList3 = new ArrayList<>();
        List<ScoreCourse> scoreCourseList = new ArrayList<>();
        Trainee trainee = traineeService.getTraineeByUsername(username);
        List<Integer> courseidList = courseService.getChosenCourseid(trainee.getId());
        List<Course> courseList = courseService.getCourseByid(courseidList);
        ListIterator listIterator = courseList.listIterator();
        while (listIterator.hasNext()){
            Course course = (Course) listIterator.next();
            CourseState state = MyTool.courseStateCheck(course.getBegindate(),course.getEnddate());
            switch (state){
                case PRE:
                    courseList0.add(course);break;
                case IN:
                    courseList1.add(course);break;
                case POST:
                    if (course.getScorestate()==0) {
                        courseList2.add(course);
                        break;
                    } else {
                        courseList3.add(course);
                    }
            }
        }

        if (!courseList3.isEmpty()){
            listIterator = courseList3.listIterator();
            while (listIterator.hasNext()){
                Course course = (Course) listIterator.next();
                Score score = scoreService.getScoreByCourseidAndTraineeid(trainee.getId(),course.getClassid());
                ScoreCourse scoreCourse = new ScoreCourse(course,score.getScore());
                scoreCourseList.add(scoreCourse);
            }
        }

//        System.out.println("id size:"+courseidList.size());
//        System.out.println("course size:"+courseList.size());
//        System.out.println("course0 size:"+courseList0.size());
//        System.out.println("course1 size:"+courseList1.size());
//        System.out.println("course2 size:"+courseList2.size());

        model.addAttribute(trainee);
        model.addAttribute("prelist",courseList0);
        model.addAttribute("inlist",courseList1);
        model.addAttribute("postlist",courseList2);
        model.addAttribute("scorelist",scoreCourseList);

        return "/trainee/C_unsubscribe";
    }

    @RequestMapping("/C_Check_Withdraw")
    public String toCW(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {

        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        model.addAttribute(trainee);

        return "/trainee/C_Check_Withdraw";
    }

    @RequestMapping("/I_Course")
    public String toC(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {

        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        model.addAttribute(trainee);

        return "/trainee/I_Course";
    }

    @RequestMapping("/I_Member")
    public String toM(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {

        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        Integer id = trainee.getId();
        List<Droplog> droplogList = logService.getDroplogByID(id);
        List<Exchangelog> exchangelogList = logService.getExchangelogByID(id);
        List<Rechargelog> rechargelogList = logService.getRechargelogByID(id);
        List<Subscribelog> subscribelogList = logService.getSubscribelogByID(id);
        List<Unsubscribelog> unsubscribelogList = logService.getUnsubscribelogByID(id);

        model.addAttribute(trainee);
        model.addAttribute(droplogList);
        model.addAttribute(exchangelogList);
        model.addAttribute(rechargelogList);
        model.addAttribute(subscribelogList);
        model.addAttribute(unsubscribelogList);

        return "/trainee/I_member";
    }

    @RequestMapping("/I_Expense")
    public String toE(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {

        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        model.addAttribute(trainee);

        return "/trainee/I_Expense";
    }

    @RequestMapping("/changestate")
    public  String changestate(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.print("/changestate\n");

        int traineeid = Integer.parseInt(request.getParameter("traineeid"));
        boolean result = traineeService.changestate(traineeid);

        return "redirect:/trainee/M_Activated_frozen";
    }


}
