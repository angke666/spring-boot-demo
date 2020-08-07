package com.xkcoding.java8.enums;

/**
 * 枚举继承至java.lang.Enum类，所以不能再继承其他类，但是可以实现多个接口
 */
public enum single {
    INSTANCE;

    single() {
    }
    
}
