package com.benbenxiang.test.stream;

public class LambadaDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        }).start();

        new Thread(() -> System.out.println("hello")).start();

        /** 参数声明 **/
        create( (a,b) -> a+b );
        create( (String a,String b) -> a+b );
        /** 单行语句块 **/
        create( (String a,String b) -> a+b );

        /** 多行语句块 **/
        create( (String a,String b) -> {
            return a+b;
        } );

        /** 静态方法引用 **/
        create(LambadaDemo::build);

        /** 非静态方法引用 **/
        create(new LambadaDemo()::build2);

        /** 参数方法引用 **/
        create(String::concat);
    }

    /**
     * 函数式接口
     * 1.只有一个抽象方法
     * 2.默认方法除外
     * 3.Object中的方法除外
     */
    @FunctionalInterface
    public interface MyRunnable extends Runnable{
        //默认实现
        default void run2(){
            System.out.println("hello run2");
        }
        boolean equals(Object obj);
    }


    public static void create(MyInterfact myInterfact){
        System.out.println("benbenxiang" + "hello world");
        myInterfact.build("benbenxiang", "hello world");
    }

    public static String build(String name, String massage){
        System.out.println(name + massage);
        return name + massage;
    }

    public String build2(String name, String massage){
        System.out.println(name + massage);
        return name + massage;
    }

    @FunctionalInterface
    public interface MyInterfact{
        String build(String name, String massage);
    }
}
