package com.xkcoding.java8.entity;

import lombok.Getter;
import lombok.Setter;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Manager
 * @Description TODO
 * @Author 钱进
 * @Date 2020/7/6 16:37
 * @Version 1.0
 **/
@Getter
@Setter
public class Manager extends Employee {

    private String name;

    public Manager(Integer id) {
        super(id);
    }

    public Manager(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public static void main(String[] args) {
        Manager boss = new Manager(1, "boss");
        Employee[] staff = new Employee[3];

        staff[0] = boss;

        Employee employee = new Employee(1);
        boolean b2 = boss == employee;
        System.out.println(b2);

        String a = "1";
        String b = "1";
        boolean flag = a == b;
        System.out.println(flag);

        Integer x = 333;
        Integer y = 333;
        boolean b1 = x.equals(y);
        System.out.println(b1);

        Map<String, String> map = new HashMap<>();
        map.put("x", "xxx");
        map.put("y", "yyy");
        map.put("z", "zzz");

        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });

        try {
            InetAddress ip = InetAddress.getByName("www.baidu.com");
            System.out.println(ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
