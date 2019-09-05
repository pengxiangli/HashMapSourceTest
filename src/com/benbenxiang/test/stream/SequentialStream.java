package com.benbenxiang.test.stream;

import com.benbenxiang.test.stream.entrty.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SequentialStream {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Mohamed", 69));
        people.add(new Person("Doaa", 25));
        people.add(new Person("Malik", 6));

        Predicate<Person> pred = p -> p.getAge() > 65;

//        displayPerson(people, pred);

        people.stream().filter( p -> p.getAge() > 65).forEach(System.out::println);

        people.parallelStream().filter(pred).forEach(System.out::println);
        people.stream().parallel().filter(pred).forEach(System.out::println);


        System.out.println("-------------------------------");
        Person[] people2 = {
                new Person("Mohamed", 69),
                new Person("Doaa", 25),
                new Person("Malik", 6)};

        Stream.of(people2).forEach(System.out::println);
        System.out.println();
        Arrays.stream(people2).forEach(System.out::println);
    }

    public static void displayPerson(List<Person> list , Predicate pred){
        list.forEach( p -> {
            if(pred.test(p))
                System.out.println(p);
        });
    }
}
