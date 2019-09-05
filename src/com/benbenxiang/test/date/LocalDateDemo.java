package com.benbenxiang.test.date;

import java.time.*;

public class LocalDateDemo {
    public static void main(String[] args) {
        /** 1. 获取当天的日期 **/
        LocalDate today = LocalDate.now();
        System.out.println(today);

        /** 2.获取当前年月日 **/
        System.out.println("yesr:" + today.getYear() + "\tmonth:" + today.getMonthValue() + "\t" + today.getDayOfMonth());

        /** 3. 获取某个指定的日期 **/
        LocalDate date = LocalDate.of(1994, 2, 8);
        System.out.println(date);

        /** 4. 检查两个日期是否相等 **/
        System.out.println(date.equals(today));

        /** 5.在java8 中检查重复时间，比如说生日 **/
        LocalDate dayOfBarth = LocalDate.of(2019, 9, 5);
        MonthDay birthDay = MonthDay.of(dayOfBarth.getMonthValue(), dayOfBarth.getDayOfMonth());
        MonthDay from = MonthDay.from(dayOfBarth);
        if(from.equals(birthDay))
            System.out.println("今天是你生日哦:" + from);

        /** 6. 在java8中获取当前时间 **/
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);//14:24:38.908  in hour, minutes, seconds, nano seconds

        /** 7. 增加时间里面的小时数 **/
        LocalTime addHours = nowTime.plusHours(2);
        System.out.println(addHours);

        /** 8. 获取一周后的日期 **/
        LocalDate addWeek = today.plusWeeks(1);
        System.out.println(addWeek);

        /** 9. 一年前的日期 **/
        LocalDate delYear = today.minusYears(1);
        System.out.println(delYear);

        /** 10. 在java8中使用始终 **/
        Clock clock = Clock.systemUTC();
        System.out.println(clock);
        Clock defaultZone = Clock.systemDefaultZone();
        System.out.println(defaultZone);
        //可以指定日期来和这个时钟进行比较
        System.out.println(today.equals(LocalDate.now(clock)));

        /** 11. 如何判断一个日期在另一个日期前面还是后面 **/
        LocalDate before = LocalDate.now().minusYears(1);
        LocalDate after = LocalDate.now();
        System.out.println(before.isBefore(after));

        /** 12. 在Java 8中处理不同的时区 **/
        LocalDateTime localDate = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, ZoneId.of("Australia/Darwin"));
        System.out.println(zonedDateTime);
    }
}
