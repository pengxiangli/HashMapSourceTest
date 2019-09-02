package com.benbenxiang.test;

import com.benbenxiang.test.collect.HashMap;

import java.util.Map;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "jack");
        hashMap.put("1", "sdf");
        hashMap.put("2", "james");
        hashMap.put("3", "mic");
        hashMap.put("4", "tom");

        HashMap map = new HashMap();
        System.out.println(hashMap);


        Random random = new Random();
        int temp;
        for (int i = 0; i < 100; i++){
            temp = random.nextInt(9999999);
            System.out.println(temp % 16 + "       " + temp % 32);
        }
    }
}
