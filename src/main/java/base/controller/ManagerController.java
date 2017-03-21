package base.controller;

import base.model.Approveold;
import base.model.Manager;
import base.model.Rawcourse;
import base.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yugi on 2017/3/20.
 */
@Controller
@RequestMapping("/Manager")
public class ManagerController {

    @Resource
    ManagerService managerService;

    @RequestMapping("/Home")
    public String toHome (HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Home");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);

        model.addAttribute(manager);

        return "/manager/home";
    }

    @RequestMapping("/Approve_Launch")
    public String approveLaunch (HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception
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
    public String approveModify (HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception
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
    public String settle (HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Settle");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);

        model.addAttribute(manager);

        return "/manager/settle";
    }

    @RequestMapping("/Institution_Info")
    public String institutionInfo (HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Institution_Info");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);

        model.addAttribute(manager);

        return "/manager/Institution_info";
    }

    @RequestMapping("/Trainee_Info")
    public String trianeenInfo (HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Trainee_Info");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);

        model.addAttribute(manager);

        return "/manager/Trainee_info";
    }

    @RequestMapping("/Finance_Info")
    public String financeInfo (HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception
    {
        System.out.println("/Manager/Finance_Info");
        String username = (String) session.getAttribute("username");
        Manager manager = managerService.getManagerByUsername(username);

        model.addAttribute(manager);

        return "/manager/Finance_info";
    }

}
