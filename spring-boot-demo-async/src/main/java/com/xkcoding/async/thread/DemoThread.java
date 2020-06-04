package com.xkcoding.async.thread;

import com.xkcoding.async.task.TaskFactory;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName DemoThread
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/4 15:28
 * @Version 1.0
 **/
@Slf4j
@Component
public class DemoThread implements Runnable {
    private TaskFactory taskFactory;
    private int num;

    public DemoThread() {
    }

    public DemoThread(TaskFactory taskFactory, int num) {
        this.taskFactory = taskFactory;
        this.num = num;
    }

    @SneakyThrows
    @Override
    public void run() {
        switch (num) {
            case 1:
                taskFactory.task1();
                break;
            case 2:
                taskFactory.task2();
                break;
            case 3:
                taskFactory.task3();
        }
    }

}
