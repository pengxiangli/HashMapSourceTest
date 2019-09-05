package com.benbenxiang.test.stream;

import com.benbenxiang.test.stream.entrty.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * 聚合流练习
 */
public class ParallelStreams {

    public static void main(String[] args) {
        ArrayList<Object> strs = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            strs.add("item " + i);
        }

//        strs.stream().forEach(System.out::println);
//        strs.parallelStream().forEach(System.out::println);
//        long count = strs.stream().count();
        long count = strs.parallelStream().count();
        System.out.println("Count :" + count);

        Person[] people = {
                new Person("Mohamed", 69),
                new Person("Doaa", 25),
                new Person("Malik", 6)};

        int sum = Arrays.stream(people).mapToInt(p -> p.getAge()).sum();
        System.out.println("sum age:" + sum);
        OptionalDouble average = Arrays.stream(people).mapToInt(p -> p.getAge()).average();
        double ave = average.getAsDouble();
        System.out.println("ave age:" + ave);
    }
}
