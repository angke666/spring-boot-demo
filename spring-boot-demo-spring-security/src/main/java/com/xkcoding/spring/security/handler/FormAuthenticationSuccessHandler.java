package com.xkcoding.spring.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 表单登录成功处理
 * @ClassName AuthenticationSuccessHandler
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/19 15:33
 * @Version 1.0
 **/
public class FormAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("{\"code\":\"200\", \"message\":\"欢迎登录系统\"}");
    }
}
