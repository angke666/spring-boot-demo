package com.xkcoding.spring.security.filter;

import cn.hutool.core.util.StrUtil;
import com.xkcoding.spring.security.exception.VerificationCodeException;
import com.xkcoding.spring.security.handler.FormAuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 校验验证码的过滤器
 * @ClassName VerificationCodeFilter
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/19 15:17
 * @Version 1.0
 **/
public class VerificationCodeFilter extends OncePerRequestFilter {

    private AuthenticationFailureHandler authenticationFailureHandler = new FormAuthenticationFailureHandler();

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 只有登录的请求才校验验证码
        if (!"/login/handler".equals(httpServletRequest.getRequestURI())) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        try {
            verificationCode(httpServletRequest);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (VerificationCodeException e) {
            authenticationFailureHandler.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
        }
    }

    /**
     * 校验验证码
     * @param request
     */
    public void verificationCode(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String requestCode = request.getParameter("captcha");
        String savedCode = (String) session.getAttribute("captcha");

        // 随手清除验证码，客户端应该在登录时刷新验证码
        if (StrUtil.isNotEmpty(savedCode)) {
            session.removeAttribute("captcha");
        }
        // 校验不通过抛出异常
        if (StrUtil.isEmpty(requestCode) || StrUtil.isEmpty(savedCode) || !requestCode.equals(savedCode)) {
            throw new VerificationCodeException();
        }
    }
}
