package com.xkcoding.dubbo.consumer.mock;

import com.xkcoding.dubbo.common.service.HelloService;

/**
 * 服务降级
 * @ClassName MockHelloService
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/9 16:35
 * @Version 1.0
 **/
public class MockHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "服务器暂时无法访问";
    }
}
