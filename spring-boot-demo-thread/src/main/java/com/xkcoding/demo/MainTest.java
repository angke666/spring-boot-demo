package com.xkcoding.demo;

import java.util.HashMap;
import java.util.UUID;

/**
 * main方法测试
 * @ClassName MainTest
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/23 14:37
 * @Version 1.0
 **/
public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<>(2);
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> {
                    map.put(UUID.randomUUID().toString(), "");
                }, "ftf" + i).start();
            }
        }, "ftf");

        thread.start();
        thread.join();
    }

}
