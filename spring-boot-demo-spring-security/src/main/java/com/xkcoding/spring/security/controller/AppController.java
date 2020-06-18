package com.xkcoding.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName AppController
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/18 17:31
 * @Version 1.0
 **/
@RestController
@RequestMapping("/app/api")
public class AppController {

    @GetMapping("/hello")
    public String hello() {
        return "hello, app";
    }

}
