package com.xkcoding.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName ThreadPoolConfig
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/4 15:03
 * @Version 1.0
 **/
@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        // 核心线程数量
        threadPoolTaskExecutor.setCorePoolSize(6);
        // 最大线程数量
        threadPoolTaskExecutor.setMaxPoolSize(10);
        // 队列存放线程数量
        threadPoolTaskExecutor.setQueueCapacity(100);
        // 空闲线程存活时间
        threadPoolTaskExecutor.setKeepAliveSeconds(60);
        // 拒绝策略（一般都配置这个策略）
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setThreadNamePrefix("diy-thread-");

        return threadPoolTaskExecutor;
    }

}
