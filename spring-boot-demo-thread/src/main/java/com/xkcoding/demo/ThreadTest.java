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
public class ThreadTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREAD_COUNT = 20;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                for (int k = 0; k < 10000; k++) {
                    increase();
                }
            });
            threads[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(race);
    }

}
