package com.xkcoding.java8;

import com.xkcoding.java8.stream.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName Java8StreamTest
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/29 10:38
 * @Version 1.0
 **/
public class Java8StreamTest {

    public static List<Dish> menu = Arrays.asList(
        new Dish("猪肉", false, 800, Dish.Type.MEAT),
        new Dish("牛肉", false, 700, Dish.Type.MEAT),
        new Dish("鸡肉", false, 400, Dish.Type.MEAT),
        new Dish("薯条", true, 530, Dish.Type.OTHER),
        new Dish("米饭", true, 350, Dish.Type.OTHER),
        new Dish("时令水果", true, 120, Dish.Type.OTHER),
        new Dish("披萨", true, 550, Dish.Type.OTHER),
        new Dish("虾", false, 300, Dish.Type.FISH),
        new Dish("三文鱼", false, 450, Dish.Type.FISH)
    );

    public static void main(String[] args) {
        // 筛选出卡路里大于300的前3个菜名(普通写法)
        List<String> java7Result = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() > 300) {
                java7Result.add(dish.getName());
                if (java7Result.size() == 3) {
                    break;
                }
            }
        }
        System.out.println(java7Result.toString());

        // stream写法
        List<String> java8Result = menu.stream()
            .filter(dish -> dish.getCalories() > 300)
            .map(Dish::getName)
            .limit(3)
            .collect(toList());
        System.out.println(java8Result);

        // 遍历
        for (Dish dish : menu) {
            System.out.println(dish.getName());
        }
        System.out.println("******java8遍历******");
        menu.forEach(dish -> System.out.println(dish.getName()));

    }

}
