package com.benbenxiang.test.jvm;

import com.benbenxiang.test.collect.HashMap;
import com.sun.crypto.provider.DESedeKeyFactory;
import sun.applet.AppletClassLoader;

public class ClassLoadDemo {
    public static void main(String[] args) throws ClassNotFoundException {
         System.out.println(HashMap.class.getClassLoader());
        System.out.println(User.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
        System.out.println(DESedeKeyFactory.class.getClassLoader());
        ClassLoader systemClassLoader = AppletClassLoader.getSystemClassLoader();
        systemClassLoader.loadClass("");
        System.out.println(systemClassLoader);
    }
}
