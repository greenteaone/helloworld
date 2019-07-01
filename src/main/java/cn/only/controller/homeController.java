package cn.only.controller;

import cn.only.entity.User;
import cn.only.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class homeController {
    @Resource
    private UserService userService;
    @RequestMapping(value="/home")
    public String home(HttpSession session, Model model){
        User u = (User) session.getAttribute("user");
        if(u != null){
            model.addAttribute("user", u);
        }

        return "home";
    }

}
