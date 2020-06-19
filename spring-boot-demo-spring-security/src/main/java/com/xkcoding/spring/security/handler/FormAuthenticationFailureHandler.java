package com.xkcoding.spring.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 表单登录失败处理
 * @ClassName FormAuthenticationFailureHandler
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/19 15:36
 * @Version 1.0
 **/
public class FormAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authenticationException) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter out = httpServletResponse.getWriter();
        out.write("{\"code\":\"500\", \"name\":\"" + authenticationException.getClass() + "\", " +
            "\"message\":\"" + authenticationException.getMessage() + "\"}");
    }
}
