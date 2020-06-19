package com.xcoding.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName MainTest
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/19 16:34
 * @Version 1.0
 **/
public class MainTest {

    public static void main(String[] args) {
        String encode = new BCryptPasswordEncoder().encode("123456");
        System.out.println(encode);
    }

}
