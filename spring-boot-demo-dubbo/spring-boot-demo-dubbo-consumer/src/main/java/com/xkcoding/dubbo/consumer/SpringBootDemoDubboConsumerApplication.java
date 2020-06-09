package com.xkcoding.dubbo.consumer;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @package: com.xkcoding.dubbo.consumer
 * @description: 启动器
 * @author: yangkai.shen
 * @date: Created in 2018-12-25 16:49
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@SpringBootApplication
@DubboComponentScan
public class SpringBootDemoDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoDubboConsumerApplication.class, args);
    }
}
