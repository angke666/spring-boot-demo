package com.xkcoding.java8.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author 钱进
 * @Date 2020/7/6 16:36
 * @Version 1.0
 **/
@Getter
@Setter
public class Employee {

    private Integer id;

    public Employee(Integer id) {
        this.id = id;
    }
}
