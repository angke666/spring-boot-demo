package com.xkcoding.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Apple
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/24 14:52
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple implements Serializable {
    private static final long serialVersionUID = -8723651367783097415L;

    private String color;
    private Integer weight;

}
