package base.controller;

import base.mapper.CardMapper;
import base.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yugi on 2017/3/13.
 */
@Controller
@RequestMapping("/card")
public class CardController {

    @Resource
    CardService cardService;

    @RequestMapping("/newcard")
    public String addNewCard(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws Exception {
        System.out.print("/card/newcard\n");

        String phonenumber = request.getParameter("phoneNumber");
        String cardnumber = request.getParameter("cardNumber");
        int traineeid = (Integer) session.getAttribute("id");

        System.out.print(phonenumber + "\n");
        System.out.print(cardnumber + "\n");
        System.out.print(traineeid + "\n");

        boolean result = cardService.addNewCard(traineeid, phonenumber, cardnumber);

        System.out.print(result + "\n");

        return "redirect:/trainee/M_Binding_Unbinding";
    }

    @RequestMapping("unbind")
    public String unbind(HttpServletRequest request, RedirectAttributes attributes, HttpSession session, Model model) throws Exception {
        System.out.print("/card/unbind\n");

        String cardnumber = request.getParameter("cardnumber");

        System.out.print("to delete :"+cardnumber+"\n");

        boolean result = cardService.unbind(cardnumber);

        return "redirect:/trainee/M_Binding_Unbinding";
    }
}