package cn.only.controller;
import cn.only.entity.User;
import cn.only.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {
    @Resource
    private UserService userService;

    @RequestMapping(value="/login")
    public String loginPage(@ModelAttribute User user, Model model){
        return "login";
    }
    @RequestMapping(value="/login",method= RequestMethod.POST)
    public String login(@ModelAttribute User user, Model model, HttpSession session){
        User u=userService.login(user);
        if(u!=null){
            u.setPassword("");

            session.setAttribute("user", u);
            model.addAttribute("status",0);
            model.addAttribute("user",user);
        }else{
            model.addAttribute("status",1);
        }
        return "login";
    }

    @RequestMapping(value="/register")
    public String register(HttpServletRequest request, Model model){
        return "register";
    }

    @RequestMapping(value="/register",method= RequestMethod.POST)
    public String addUser(@ModelAttribute User user, Model model){

        List<User> list=userService.selectUserByName(user);
        if(list.size()==0){
            if(userService.insert(user)==1){
                model.addAttribute("status",0);
            }else{
                model.addAttribute("status",1);
            }
        }else{
            model.addAttribute("status",2);
        }
        return "register";
    }

    @RequestMapping(value="/detail")
    public String detail(HttpSession session, Model model){
        int id=((User)session.getAttribute("user")).getId();
        User u =userService.selectByPrimaryKey(id);
        model.addAttribute("user",u);
        return "detail";
    }

    @RequestMapping(value="/detail",method= RequestMethod.POST)
    public String editUser(@ModelAttribute User user, Model model,HttpSession session){
        User un = (User) session.getAttribute("user");
        User u=(User)userService.selectByPrimaryKey(un.getId());
        if(u!=null){
            user.setId(un.getId());
            user.setName(un.getName());
            if(userService.updateByPrimaryKey(user)==1){
                model.addAttribute("status",0);
            }else{
                model.addAttribute("status",1);
            }
        }else{
            model.addAttribute("status",2);
        }
        return "detail";
    }
    @RequestMapping(value="/logout",method= RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/user/login";
    }
    @ResponseBody
    @RequestMapping(value="/delete",method= RequestMethod.DELETE)
    public Integer delete(HttpSession session, Model model){
        User u = (User) session.getAttribute("user");
       int result=0;
        if(u != null){
            result=   userService.deleteByPrimaryKey(u.getId());
            session.setAttribute("user",null);
            System.out.println("Result:"+result);
        }
        return result;
    }
}
