package com.xkcoding.java8;

import com.xkcoding.java8.stream.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
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
        System.out.println(java8Result + " ");

        // 遍历
        for (Dish dish : menu) {
            System.out.print(dish.getName() + " ");
        }
        System.out.println();
        System.out.println("******java8遍历******");
        menu.forEach(dish -> System.out.print(dish.getName() + " "));
        System.out.println();

        List<String> words = Arrays.asList("Hello", "World");

        // 排成字符表,去除重复的字符(这样找出的List<String[]>,我们需要得到List<String>)
        List<String[]> collect = words.stream()
            .map(word -> word.split(""))
            .distinct()
            .collect(toList());
        collect.forEach(strings -> {
            for (int i = 0; i < strings.length; i++) {
                System.out.print(strings[i] + " ");
            }
        });
        System.out.println();
        // 解决上面的问题
        List<String> collect1 = words.stream()
            .map(word -> word.split(""))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(toList());
        collect1.forEach(System.out::print);
        System.out.println();

        // 查询和匹配类API,返回的boolean值
        // 至少有一个素菜
        boolean anyMatch = menu.stream().anyMatch(Dish::isVegetarian);
        // 全是素菜
        boolean allMatch = menu.stream().allMatch(Dish::isVegetarian);
        // 没有素菜
        boolean noneMatch = menu.stream().noneMatch(Dish::isVegetarian);
        System.out.println("anyMatch:" + anyMatch);
        System.out.println("allMatch:" + allMatch);
        System.out.println("noneMatch:" + noneMatch);

        // 随便查一个满足条件的菜
        Optional<Dish> dishOptional = menu.stream()
            .filter(Dish::isVegetarian)
            .findAny();
        // 是否存在
        boolean present = dishOptional.isPresent();
        // 返回存在的值,没存在就抛NoSuchElement异常
        Dish dish = dishOptional.get();
        // 存在就返回值,否则返回默认值
        Dish dish1 = dishOptional.orElse(new Dish("招牌菜", false, 500, Dish.Type.MEAT));
        System.out.println("是否存在:" + present);
        System.out.println(dish);
        System.out.println(dish1);

        // 归约(求和,最大值最小值)
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 普通方法
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
        // java8(第一个参数是初始值,后面就是算法,可以相加,相乘等)
//        sum = numbers.stream().reduce(0, (x, y) -> x + y);
        sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());
        max = numbers.stream().reduce(Integer::max);
        System.out.println(max.get());

        int sum1 = menu.stream()
            .mapToInt(Dish::getCalories)
            .sum();
        System.out.println(sum1);

        Map<Dish.Type, List<Dish>> map = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(map);
    }

}
