package com.xkcoding.async.task;

import com.xkcoding.async.SpringBootDemoAsyncApplicationTests;
import com.xkcoding.async.thread.DemoThread;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * <p>
 * 测试任务
 * </p>
 *
 * @package: com.xkcoding.async.task
 * @description: 测试任务
 * @author: yangkai.shen
 * @date: Created in 2018-12-29 10:49
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class TaskFactoryTest extends SpringBootDemoAsyncApplicationTests {
    @Autowired
    private TaskFactory task;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * 测试异步任务
     */
    @Test
    public void asyncTaskTest() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        Future<Boolean> asyncTask1 = task.asyncTask1();
        Future<Boolean> asyncTask2 = task.asyncTask2();
        Future<Boolean> asyncTask3 = task.asyncTask3();

        // 调用 get() 阻塞主线程
        asyncTask1.get();
        asyncTask2.get();
        asyncTask3.get();
        long end = System.currentTimeMillis();

        log.info("异步任务全部执行结束，总耗时：{} 毫秒", (end - start));
    }

    /**
     * 测试异步任务 非注解实现
     * 写了之后发现还是直接一个@Async方便 哈哈
     */
    @Test
    public void noAutoAsyncTaskTest() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        DemoThread demoThread1 = new DemoThread(task, 1);
        DemoThread demoThread2 = new DemoThread(task, 2);
        DemoThread demoThread3 = new DemoThread(task, 3);

        /** 一般用execute方法异步调用，使用submit方法获得返回值，线程应该实现callable接口 这里用submit方法是为了阻塞主线程测试执行时间 **/
//        threadPoolTaskExecutor.execute(demoThread1);
//        threadPoolTaskExecutor.execute(demoThread2);
//        threadPoolTaskExecutor.execute(demoThread3);

        Future<?> future1 = threadPoolTaskExecutor.submit(demoThread1);
        Future<?> future2 = threadPoolTaskExecutor.submit(demoThread2);
        Future<?> future3 = threadPoolTaskExecutor.submit(demoThread3);

        // 调用 get() 阻塞主线程
        future1.get();
        future2.get();
        future3.get();
        long end = System.currentTimeMillis();

        log.info("异步任务全部执行结束，总耗时：{} 毫秒", (end - start));
    }

    /**
     * 测试同步任务
     */
    @Test
    public void taskTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        task.task1();
        task.task2();
        task.task3();
        long end = System.currentTimeMillis();

        log.info("同步任务全部执行结束，总耗时：{} 毫秒", (end - start));
    }
}
