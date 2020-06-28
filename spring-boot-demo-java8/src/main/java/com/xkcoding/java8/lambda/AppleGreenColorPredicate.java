package com.xkcoding.java8.lambda;

import com.xkcoding.java8.entity.Apple;

/**
 * @ClassName AppleGreenColorPredicate
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/28 16:20
 * @Version 1.0
 **/
public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("green");
    }
}
