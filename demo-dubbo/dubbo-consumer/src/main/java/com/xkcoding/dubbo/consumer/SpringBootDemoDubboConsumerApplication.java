package com.xkcoding.dubbo.consumer;

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
public class SpringBootDemoDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoDubboConsumerApplication.class, args);
    }
}
