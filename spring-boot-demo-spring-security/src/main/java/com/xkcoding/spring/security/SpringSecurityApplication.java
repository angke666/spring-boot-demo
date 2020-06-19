package com.xkcoding.spring.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName SpringSecurityApplication
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/18 10:28
 * @Version 1.0
 **/
@MapperScan("com.xkcoding.spring.security.mapper")
@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

}
