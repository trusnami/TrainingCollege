package base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import base.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yugi on 2017/3/11.
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Resource
    UserService userService;

    @RequestMapping("/index")
    public String index (HttpServletRequest request, RedirectAttributes attributes, HttpSession session) throws  Exception
    {
        System.out.printf("aaa\n");
        return "index";
    }

    @RequestMapping("/login")
    public String login (HttpServletRequest request, RedirectAttributes attributes, HttpSession session,
                         Model model) throws  Exception
    {
        System.out.printf("ooo\n");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        session.setAttribute("username",userName);
        session.setAttribute("password",password);

        int identity = userService.login(userName,password);

        System.out.println(identity);

        switch (identity){
            case 0:
                System.out.println("manager");return "redirect:/Manager/Approve_Launch";
            case 1:
                System.out.println("trainee");return "redirect:/trainee/M_Activated_frozen";
            case 2:
                System.out.println("institution");return "redirect:/institution/Launch_Course";
            case 3:
                System.out.println("wrong password");return "wrong_password";
            case 4:
                System.out.println("nonexistent username");return "nonexistent_username";
            default:
                System.out.println("unknown number");break;
        }

        return "index";
    }

    @RequestMapping("/register")
    public String regiter(HttpServletRequest request, RedirectAttributes attributes, HttpSession session,
                          Model model) throws  Exception
    {
        System.out.println("/user/register");

        return "Register";
    }

    @RequestMapping("/register1")
    public String regiter1(HttpServletRequest request, RedirectAttributes attributes, HttpSession session,
                          Model model) throws  Exception
    {
        System.out.println("/user/register");

        return "Register1";
    }

    @RequestMapping("/registered")
    public String regitered(HttpServletRequest request, RedirectAttributes attributes, HttpSession session,
                          Model model) throws  Exception
    {
        System.out.println("/user/registered");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        int type = Integer.parseInt(request.getParameter("type"));
        int result = userService.addNewUser(userName,password,type);

        return "redirect:/user/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, RedirectAttributes attributes, HttpSession session,
                            Model model) throws  Exception
    {
        System.out.println("/user/logout");
        session.invalidate();

        return "redirect:/user/index";
    }
}
