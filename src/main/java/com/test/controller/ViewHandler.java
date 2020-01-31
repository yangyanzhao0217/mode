package com.test.controller;

import com.test.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/view")
@SessionAttributes(value = "user")
public class ViewHandler {
    @RequestMapping("/model")
    public String model(Model model){
        User user =new User();
        user.setId(1L);
        user.setName("张三");
        model.addAttribute("user",user);
        return  "view";
    }
}
