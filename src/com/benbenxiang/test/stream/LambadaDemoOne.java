package com.benbenxiang.test.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class LambadaDemoOne {

    public static void main(String[] args) {
        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

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
    }

    public static void filter(Collection<String> col, Predicate<String> predicate){
        col.stream().filter( (a) -> predicate.test(a) ).forEach( (a) -> System.out.print(a + " ") );
    }
}
