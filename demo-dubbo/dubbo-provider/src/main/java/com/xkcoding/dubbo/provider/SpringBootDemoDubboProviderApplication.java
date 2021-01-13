package com.xkcoding.dubbo.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-25 16:49
 */
@DubboComponentScan
@SpringBootApplication
public class SpringBootDemoDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoDubboProviderApplication.class, args);
    }
}
