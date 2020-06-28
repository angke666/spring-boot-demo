package com.xkcoding.java8.lambda;

import com.xkcoding.java8.entity.Apple;

import java.util.ArrayList;
import java.util.List;

/**
 * Java8之前实现普通方法类
 * @ClassName AppleUtils
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/24 15:18
 * @Version 1.0
 **/
public class AppleUtils {

    /**
     * 普通的根据颜色筛选苹果的方法
     * @param list
     * @return
     */
    public static List<Apple> filterColorApples(List<Apple> list, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : result) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 普通的根据重量筛选苹果的方法
     * @param list
     * @return
     */
    public static List<Apple> filterWeightApples(List<Apple> list, Integer weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : result) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 普通的根据其他条件筛选苹果的方法
     * @param list
     * @return
     */
    public static List<Apple> filterApples(List<Apple> list, String color, Integer weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (flag) {
                if (apple.getColor().equals(color)) {
                    result.add(apple);
                }
            } else {
                if (apple.getWeight() > weight) {
                    result.add(apple);
                }
            }
        }
        return result;
    }

    /**
     * 改造之后的方法，参数行为化
     * @param list
     * @param predicate
     * @return
     */
    public static List<Apple> filterApples(List<Apple> list, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 继续改造，支持更多类
     * @param list
     * @param predicate
     * @param <T>
     * @return
     */
    public static <T> List<T> filterApples(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

}
