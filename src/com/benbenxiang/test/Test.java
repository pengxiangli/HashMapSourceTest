package com.benbenxiang.test;

import com.benbenxiang.test.collect.HashMap;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("0", "jack");
        hashMap.put("1", "sdf");
        hashMap.put("2", "james");
        hashMap.put("3", "mic");
        hashMap.put("5", "tom");
        hashMap.put("6", "tom");
        hashMap.put("7", "tom");
        hashMap.put("8", "tom");
        hashMap.put("9", "tom");
        hashMap.put("10", "tom");
        hashMap.put("11", "tom");
        hashMap.put("17", "tom");
        hashMap.put("18", "tom");
        hashMap.put("19", "tom");
        hashMap.put("20", "tom");
        hashMap.remove("1");

        TreeMap map = new TreeMap<>();
        map.put("1", "1");
        ConcurrentHashMap conMap = new ConcurrentHashMap();
        conMap.put("1", "1");
        System.out.println(hashMap);


        Random random = new Random();
        int temp;
        for (int i = 0; i < 100; i++){
            temp = random.nextInt(9999999);
            System.out.println(temp % 16 + "       " + temp % 32);
        }

    }
}
