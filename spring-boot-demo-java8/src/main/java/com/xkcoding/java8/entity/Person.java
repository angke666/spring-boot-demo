package com.xkcoding.java8.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Person
 * @Description TODO
 * @Author 钱进
 * @Date 2020/7/6 16:57
 * @Version 1.0
 **/
@Getter
@Setter
public abstract class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        List<Double> m6Week1_7     =  Arrays.asList(81.2, 81.1, 80.6, 81.2, 81.1, 79.5, 80.2);// 80.7kg   161.4斤
        List<Double> m6Week8_14    =  Arrays.asList(80.3, 80.0, 80.2, 80.1, 80.6, 79.2, 79.6);// 80.0kg   160斤
        List<Double> m6Week15_21   =  Arrays.asList(80.2, 80.7, 80.6, 80.4, 80.1, 80.0, 79.9);// 80.27kg  160.54斤
        List<Double> m6Week22_28   =  Arrays.asList(79.7, 80.4, 79.5, 80.3);                  // 79.975kg 159.95斤
        List<Double> m6_m7Week29_5 =  Arrays.asList(79.9, 80.2, 80.4, 80.6, 79.8, 79.5);      // 80.07kg  160.13斤
        List<Double> m7Week6_12    =  Arrays.asList(79.7, 80.0, 79.9, 80.1, 79.7, 79.5, 79.1);// 79.71kg  159.42斤

        double avg1 = m6Week1_7.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        double avg2 = m6Week8_14.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        double avg3 = m6Week15_21.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        double avg4 = m6Week22_28.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        double avg5 = m6_m7Week29_5.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        double avg6 = m7Week6_12.stream().mapToDouble(Double::doubleValue).average().getAsDouble();

        System.out.println(avg1 * 2);
        System.out.println(avg2 * 2);
        System.out.println(avg3 * 2);
        System.out.println(avg4 * 2);
        System.out.println(avg5 * 2);
        System.out.println(avg6 * 2);
    }
}
