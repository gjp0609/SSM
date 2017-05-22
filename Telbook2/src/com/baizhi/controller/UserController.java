package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by gjp06 on 17.5.21.
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private UserService service;

    @RequestMapping("login")
    public String login(User user, HttpSession session) {
        if (user == null) throw new RuntimeException("user null");
        User login = service.login(user);
        session.setAttribute("user", user);
        return "redirect:/person/queryAll.do";
    }


}
