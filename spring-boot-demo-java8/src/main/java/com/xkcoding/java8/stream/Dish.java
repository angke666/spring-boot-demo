package com.xkcoding.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Dish
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/29 10:34
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type {
        MEAT,
        FISH,
        OTHER;
    }

}
