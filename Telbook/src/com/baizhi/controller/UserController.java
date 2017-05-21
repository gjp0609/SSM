package com.baizhi.controller;

import com.baizhi.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by gjp06 on 17.5.21.
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private UserService service;

    @RequestMapping("login")
    public String login() {
         
        return "";
    }

}
