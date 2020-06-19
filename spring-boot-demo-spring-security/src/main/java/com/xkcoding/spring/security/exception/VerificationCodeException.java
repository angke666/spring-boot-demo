package com.xkcoding.spring.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义验证码校验失败异常
 * @ClassName VerificationCodeException
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/19 15:14
 * @Version 1.0
 **/
public class VerificationCodeException extends AuthenticationException {

    public VerificationCodeException() {
        super("图形验证码校验失败");
    }

}
