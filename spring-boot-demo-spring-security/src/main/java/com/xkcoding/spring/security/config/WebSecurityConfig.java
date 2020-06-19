package com.xkcoding.spring.security.config;

import com.xkcoding.spring.security.componet.UserDetailServiceImpl;
import com.xkcoding.spring.security.filter.VerificationCodeFilter;
import com.xkcoding.spring.security.handler.FormAuthenticationFailureHandler;
import com.xkcoding.spring.security.handler.FormAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            // 登录
            .formLogin()
                // 登录地址
                .loginPage("/login")
                // 登录成功处理
                .loginProcessingUrl("/login/handler")
                // 登录成功处理 随便用哪个loginProcessingUrl或者successHandler
//                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .and()
            // 注销
            .logout()
                // 注销地址
                .logoutUrl("/logout")
                // 注销成功处理
                .logoutSuccessUrl("/logout.html")
                // 或者用这种，和登录一样
//                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {})
                // 让session失效
                .invalidateHttpSession(true)
                // 删除指定cookie
//                .deleteCookies("cookie1", "cookie2", "cookien")
                .and()
            // 认证请求
            .authorizeRequests()
                // 配置的请求需要角色
                .antMatchers("/admin/api/**").hasRole("ADMIN")
                .antMatchers("/user/api/**").hasRole("USER")
                // 配置的请求不需要登录
                .antMatchers(
                    "/login/**",
                    "/app/api/**",
                    "/captcha.jpg",
                    "/logout.html").permitAll()
                // 其余没有配置的所有请求都需要认证
                .anyRequest().authenticated()
                .and()
            .csrf().disable()
            // 校验验证码过滤器 下面的过滤器顺序不能换顺序不能
            .addFilterBefore(new VerificationCodeFilter()
                , UsernamePasswordAuthenticationFilter.class)
            .rememberMe().userDetailsService(userDetailService);
    }

    /**
     * 告诉框架是用的哪种加密方式，也可以在UserDetailServiceImpl里面得到的user对象的密码格式改成 {加密方式}+user.getPassword()
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new FormAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new FormAuthenticationFailureHandler();
    }

}
