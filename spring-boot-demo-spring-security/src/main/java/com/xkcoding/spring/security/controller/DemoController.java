package com.xkcoding.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/18 10:33
 * @Version 1.0
 **/
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }

}
