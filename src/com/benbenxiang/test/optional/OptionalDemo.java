package com.benbenxiang.test.optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("12");
        Optional<String> s = Optional.ofNullable("123");
        s.isPresent();
        Optional<String> empty = Optional.empty();
        Optional<String> name = Optional.of("benbenxiang");
        optional.ifPresent((str) -> System.out.println(str + "123"));
        String benbenxiang = empty.orElse("benbenxiang");
        empty.orElseGet( () -> "benbenxiang" );

        empty.orElseThrow(RuntimeException::new);
        Optional<String> toUp = name.map((value) -> value.toUpperCase());
        Optional<Character> character = name.map((value) -> Character.valueOf(value.charAt(0)));

        name.flatMap( (a) -> Optional.of(a.toUpperCase()));

        name.filter( (a) -> a.length() > 4 ).orElseThrow(RuntimeException::new);
    }
}
