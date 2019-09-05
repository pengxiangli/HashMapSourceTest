package com.benbenxiang.test.stream;

import com.benbenxiang.test.stream.entrty.Human;

import java.util.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class LambadaDemoOne {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, ( str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a :");
        filter(languages, ( str) -> str.endsWith("a"));

        System.out.println("Languages which all:");
        filter(languages, ( str) -> true);

        System.out.println("Languages which no all:");
        filter(languages, ( str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, ( str) -> str.length() > 4 );

        //每个订单加上12%的税
        System.out.println();
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((price) -> price = price * 12 / 10).forEach(System.out::println);

        //每个订单加上12%的税,并计算总和
        Integer integer = costBeforeTax.stream().<Integer>map((price) -> price * 12 / 10).reduce((sum, cost) -> sum + cost).get();
        System.out.println(integer);

        List<String> collect = languages.stream().filter((str) -> str.length() > 4).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", languages, collect);

        // 将字符串换成大写并用逗号链接起来
        List<String> g7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");

        String str1 = g7.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        System.out.println(str1);

        // 求出平方后的去重
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> integers = numbers.stream().map((i) -> i * i).distinct().collect(Collectors.toList());
        System.out.println(integers);

        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        //获取数字个数
        long count = primes.stream().count();
        System.out.println("数字个数:" + count);
        //最小值
        Integer min = primes.stream().min(Integer::compareTo).get();
        System.out.println("最小值:" + min);
        //最大值
        Integer max = primes.stream().max(Integer::compareTo).get();
        System.out.println("最大值:" + max);
        //总和
        int sum = primes.stream().mapToInt(Integer::intValue).sum();
        System.out.println("总和:" + sum);
        //平均值
        double asDouble = primes.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println("平均值:" + asDouble);

        IntSummaryStatistics intSummaryStatistics = primes.stream().mapToInt(Integer::intValue).summaryStatistics();
        intSummaryStatistics.getCount();
        intSummaryStatistics.getMax();
        intSummaryStatistics.getMin();
        intSummaryStatistics.getSum();
        intSummaryStatistics.getAverage();

        //排序增强 Comparator
        List<Human> humans = new ArrayList(Arrays.asList(new Human[]{
                new Human("Sarah", 12), new Human("Sarah", 10), new Human("Zack", 12)}));
        humans.sort(Comparator.comparing(Human::getAge).thenComparing(Human::getName));

        LongAdder longAdder = new LongAdder();
        longAdder.sum();
    }

    public static void filter(Collection<String> col, Predicate<String> predicate){
        col.stream().filter( (a) -> predicate.test(a) ).forEach( (a) -> System.out.print(a + " ") );
    }
}
