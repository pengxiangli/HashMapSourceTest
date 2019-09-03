package com.benbenxiang.test.stream;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    private static List<Apple> appleStory = new ArrayList<>();

    static {
        appleStory.add(new Apple(1, "red", 500, "湖南"));
        appleStory.add(new Apple(2, "red", 400, "湖南"));
        appleStory.add(new Apple(3, "green", 300, "湖南"));
        appleStory.add(new Apple(4, "green", 200, "天津"));
        appleStory.add(new Apple(5, "green", 100, "天津"));
    }



    /** 获取所有红色苹果 **/
    public static void getByRed(){
        List result = new ArrayList();
        for (Apple apple : appleStory) {
            if("red".equals(apple.getColor()))
                result.add(apple);
        }
    }

    public static void getByStream(){
        appleStory.stream()
                .filter(apple -> "red".equals(apple.getColor()))
                .sorted()
                .distinct()
                .map(apple -> apple.getWeight())
                .forEach(System.out::println);
    }

    public static void test1(){
        /**
         * 流，不可重复使用
         */
        Stream<Apple> stream1 = appleStory.stream();
        Stream<Apple> stream2 = stream1.filter(apple -> "red".equals(apple.getColor()));
        Stream<Apple> stream3 = stream1.distinct();
    }

    /**
     * 流的三种操作类型
     * 1. 生成初始流操作
     * 2. 流的中间操作
     * 3. 终止操作
     */

    //1. 初始化流操作
    public static void test2(){
        Stream<String> stream1 = Stream.of("1", "2", "3");//生成一个流
//        Collection.stream()
//        Arrays.stream()
    }

    //2. 中间操作
    public static void test3(){
        /** 中间操作，如果没有终止操作则不会执行 **/
        List<Apple> list = appleStory.stream().filter(apple -> {
            System.out.println("hello");
            return true;
        }).collect(Collectors.toList());
    }



    //3.终止操作
    public static void test4(){
        //只能有一个，而且只能是最后一个
        appleStory.stream().forEach(apple -> {
            apple.setId(new Random().nextInt(1000));
        });
        System.out.println(appleStory);
    }

    //流的执行顺序
    // 按照顺序，一个个的去执行
    public static void test5(){
        appleStory.stream()
                .filter(apple -> "red".equals(apple.getColor()))
                .peek(apple -> System.out.println(apple.getColor()))
                .peek(apple -> System.out.println(apple.getOrigin()))
                .toArray();
    }

    public static void main(String[] args) {
        test8();
    }

    //流的执行顺序
    // 按照顺序，一个个的去执行
    public static void test6(){
        appleStory.stream()
                .filter(apple -> "red".equals(apple.getColor()))
                .map(apple -> apple.getOrigin())
                .count();
    }

    public static void test7(){
        Map<Object, Double> map = appleStory.stream()
                .collect(Collectors.groupingBy(a -> a.getColor(),
                        Collectors.averagingInt(a -> a.getWeight())));
        map.forEach((k,v) -> {
            System.out.println("key:" + k + "\t" + "value:" + v);
        });
    }

    public static void test8(){
        Duration duration = Duration.ofMinutes(10);
        System.out.println(""+ duration.getSeconds());
        System.out.println(""+ duration.getNano());
        Map<String, Double> map = appleStory.stream().collect(Collectors.groupingBy(apple -> apple.getColor(),
                Collectors.averagingInt(apple -> apple.getWeight())));
    }
}
