package com.xkcoding.java8.test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName Java8DateTest
 * @Description TODO
 * @Author 钱进
 * @Date 2020/6/29 17:05
 * @Version 1.0
 **/
public class Java8DateTest {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2020, 6, 29);
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int day = localDate.getDayOfMonth();
        DayOfWeek week = localDate.getDayOfWeek();
        int lengthOfMonth = localDate.lengthOfMonth();
        boolean leapYear = localDate.isLeapYear();

        System.out.println(year + "-" + month.getValue() + "-" + day + "-" + week.getValue() + "-" + lengthOfMonth + "-" + leapYear);

        LocalDate today = LocalDate.now();

        System.out.println(localDate.toString());
        System.out.println(today);

        LocalTime localTime = LocalTime.of(17, 17, 46);
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 2, 13, 21, 11);
        localDateTime = LocalDateTime.parse("2020-06-21 13:22:11", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(localDateTime);
        LocalDate localDate1 = localDateTime.toLocalDate();
        LocalTime localTime1 = localDateTime.toLocalTime();
    }

}
