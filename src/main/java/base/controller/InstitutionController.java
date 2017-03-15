package base.controller;

import base.model.Institution;
import base.service.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yugi on 2017/3/15.
 */
@Controller
@RequestMapping("/institution")
public class InstitutionController {

    @Resource
    InstitutionService institutionService;

    @RequestMapping("/Home")
    public String toHome(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws  Exception {
        System.out.println("/institution/Home");
        String username = (String) session.getAttribute("username");
        Institution institution = institutionService.getInstitutionByUsername(username);
        model.addAttribute(institution);
        return "/institution/home";
    }

}
