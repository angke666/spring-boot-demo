package com.xkcoding.spring.security.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName CapthcaController
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/19 15:06
 * @Version 1.0
 **/
@Controller
public class CapthcaController {

    @Autowired
    private Producer captchaProducer;

    @GetMapping("/captcha.jpg")
    public void getCapthca(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置内容类型
        response.setContentType("image/jpeg");
        // 创建验证码文本
        String capText = captchaProducer.createText();
        // 将验证码文本放进session
        request.getSession().setAttribute("captcha", capText);
        // 创建验证码图片
        BufferedImage image = captchaProducer.createImage(capText);
        // 获取响应输出流
        ServletOutputStream out = response.getOutputStream();
        // 将图片验证码数据写到响应输出流
        ImageIO.write(image, "jpg", out);
        // 推送并关闭响应输出流
        try {
            out.flush();
        } finally {
            out.close();
        }
    }

}
