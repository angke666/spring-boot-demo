package com.xkcoding.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/18 16:13
 * @Version 1.0
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping()
    public String login() {
        return "login";
    }

    @PostMapping("/handler")
    public String success() {
        return "index";
    }

}
