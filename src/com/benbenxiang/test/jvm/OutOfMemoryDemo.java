package com.benbenxiang.test.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/home/li/Desktop/bleege/HashMapSourceTest/oomdump.dump
 */
public class OutOfMemoryDemo {
    public static void main(String[] args) {
        List<User> list = new ArrayList();
        int i = 0;
        while(true)
            list.add( new User(i++, UUID.randomUUID().toString()));
    }
}
