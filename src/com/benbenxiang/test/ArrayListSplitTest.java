package com.benbenxiang.test;

import com.benbenxiang.test.collect.HashMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ArrayListSplitTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Spliterator<Integer> split1 = list.spliterator();
        System.out.println("sprlit1: ");
//        split1.forEachRemaining(System.out::println);
        Spliterator<Integer> split2 = split1.trySplit();
        System.out.println(split1.characteristics());
        System.out.println(split1.getExactSizeIfKnown());
        Spliterator<Integer> split3 = split1.trySplit();
        System.out.println(split1.getExactSizeIfKnown());
        split1.forEachRemaining(System.out::println);
//        Spliterator<Integer> split2 = split1.trySplit();
        System.out.println("split2:");
        split2.forEachRemaining(System.out::println);
        Spliterator<Integer> integerSpliterator = split1.trySplit();
    }
}
