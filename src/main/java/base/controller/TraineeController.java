package base.controller;

import base.model.Card;
import base.model.Course;
import base.model.Trainee;
import base.service.CardService;
import base.service.CourseService;
import base.service.TraineeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

        for (int i = 0;i<cardList.size();i++){
            System.out.print(cardList.get(i).getCardnumber()+"\n");
        }

        model.addAttribute(cardList);

        return "/trainee/M_Binding_Unbinding";
    }

    @RequestMapping("/M_Activated_frozen")
    public String toAF(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {

        System.out.print("/M_Activated_frozen\n");
        String username = (String) session.getAttribute("username");
        //String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        int id = trainee.getId();

        List<Card> cardList = cardService.getCardByTraineeId(id);

        model.addAttribute(trainee);

        if (cardList == null){
            return "/trainee/TraineeHome";
        }

        for (int i = 0;i<cardList.size();i++){
            System.out.print(cardList.get(i).getCardnumber()+"\n");
        }

        model.addAttribute(cardList);

        return "/trainee/M_Activated_Frozen";
    }

    @RequestMapping("/recharge")
    public String recharge(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.print("/recharge\n");
        String number = request.getParameter("rechargeAmount");
        String username = (String) session.getAttribute("username");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        double balance = trainee.getBalance();
        balance+=Double.parseDouble(number);
        trainee.setBalance(balance);

        boolean result = traineeService.addBalance(trainee);

        System.out.print(number+"\n");

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
        System.out.println("/C_Subscribe");
        String username = (String) session.getAttribute("username");
        //String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        int traineeid = trainee.getId();
        List<Course> courseArrayList = courseService.getUnsubscribedClass(traineeid);

        if (courseArrayList!=null){
            for (int i=0;i<courseArrayList.size();i++){
                System.out.println(courseArrayList.get(i).getClassid());
            }
        }

        System.out.println("size:"+courseArrayList.size());

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
        String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        model.addAttribute(trainee);

        return "/trainee/C_Unsubscribe";
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

        model.addAttribute(trainee);

        return "/trainee/I_Member";
    }

    @RequestMapping("/I_Expense")
    public String toE(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {

        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        Trainee trainee = traineeService.getTraineeByUsername(username);

        model.addAttribute(trainee);

        return "/trainee/I_Expense";
    }



}
