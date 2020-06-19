package com.xkcoding.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.PrintWriter;

/**
 * 认证配置
 *
 * @ClassName WebSecurityConfig
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/18 11:09
 * @Version 1.0
 **/
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                // 登录页面
                .loginPage("/login")
                // 登录成功处理
                .loginProcessingUrl("/login/handler")
                // 登录成功处理 随便用哪个loginProcessingUrl或者successHandler
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .and()
            // 认证请求
            .authorizeRequests()
                // 配置的请求需要角色
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                // 配置的请求不需要登录
                .antMatchers("/login", "/app/api/**").permitAll()
                // 其余没有配置的所有请求都需要认证
                .anyRequest().authenticated()
                .and()
            .csrf().disable();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (httpServletRequest, httpServletResponse, authentication) -> {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            PrintWriter out = httpServletResponse.getWriter();
            out.write("{\"code\":\"200\", \"message\":\"欢迎登录系统\"}");
        };
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return (httpServletRequest, httpServletResponse, authenticationException) -> {
            httpServletResponse.setContentType("application/json;charset=UTF-8");
            PrintWriter out = httpServletResponse.getWriter();
            out.write("{\"code\":\"500\", \"name\":\"" + authenticationException.getClass() + "\", " +
                "\"message\":\"" + authenticationException.getMessage() + "\"}");
        };
    }

}
