package com.xkcoding.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/18 17:31
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user/api")
public class UserController {

    @GetMapping("/hello")
    public String hello() {
        return "hello, user";
    }

}
