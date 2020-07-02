package com.xkcoding.java8.test;

import com.xkcoding.java8.entity.Apple;
import com.xkcoding.java8.lambda.*;

import java.util.*;

import static java.util.Comparator.comparing;

/**
 * @ClassName Java8Test
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/24 10:35
 * @Version 1.0
 **/
public class Java8LambdaTest {

    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple("green", 80));
        list.add(new Apple("green", 155));
        list.add(new Apple("red", 120));

        // 重量大于50克的苹果
        List<Apple> result = AppleUtils.filterApples(list, "red", 50, false);

        // 重量大于AppleHeavyWeightPredicate里面的设置值的苹果
        List<Apple> heavyApples = AppleUtils.filterApples(list, new AppleHeavyWeightPredicate());
        // 颜色为AppleGreenColorPredicate里面设置的苹果
        List<Apple> greenApples = AppleUtils.filterApples(list, new AppleGreenColorPredicate());

        // 上面两种方法很麻烦，每次筛选苹果的一个属性就要新建一个类实现ApplePredicate的test方法，直接使用匿名类解决
        List<Apple> redApples = AppleUtils.filterApples(list, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        });

        // lambda表达式
        List<Apple> blueApples = AppleUtils.filterApples(list, (ApplePredicate) apple -> "blue".equals(apple.getColor()));

        // 不只苹果一种物品的属性筛选，扩大更多物品
        List<Apple> yellowBananas = AppleUtils.filterApples(list, (Predicate<Apple>) banana -> "yellow".equals(banana.getColor()));

        // 排序 compareTo() apple1在前就是升序，在后就是降序
        list.sort((apple1, apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));
        // lambda方法以引用（升序）
        list.sort(comparing(Apple::getWeight));
        // 反转（就是降序）
        Collections.reverse(list);
        list.forEach(apple -> System.out.println(apple.getWeight()));
    }

}
