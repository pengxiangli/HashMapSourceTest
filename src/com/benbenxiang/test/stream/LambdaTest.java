package com.benbenxiang.test.stream;

import com.benbenxiang.test.stream.entrty.Trader;
import com.benbenxiang.test.stream.entrty.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("1......");
        /** 1. 找出2011年发生的所有交易，并按交易额排序*/
        transactions.stream()
                .filter(t -> 2011 == t.getYear())
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("2......");
        /** 2. 交易员在哪些不同的城市工作过*/
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("3......");
        /** 3. 查找所有来自剑桥的交易员，并按姓名排序*/
        transactions.stream()
                .map(t -> t.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println("4......");
        /** 4. 返回所有交易员的姓名字符串，并按字母顺序排序*/
        String s = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce((s1, s2) -> s1 + " " + s2)
                .get();
        System.out.println(s);

        /** 5. 有没有交易员在米兰工作的？*/
        System.out.println("5......");
       /* transactions.stream()
                .map( t -> t.getTrader())
                .distinct()
                .filter( t -> "Milan".equalsIgnoreCase(t.getCity()))
                .forEach(System.out::println);*/
        boolean milan = transactions.stream().anyMatch(t -> t.getTrader().getCity().equalsIgnoreCase("Milan"));
        System.out.println(milan);

        System.out.println("6......");
        /** 6. 打印生活在剑桥的交易员的所有交易额*/
        int sum = transactions.stream()
                .filter(t -> "Cambridge".equalsIgnoreCase(t.getTrader().getCity()))
                .mapToInt(t -> t.getValue())
                .sum();
        System.out.println(sum);

        System.out.println("7......");
        /** 7. 所有交易中，最高的交易额是多少*/
        int max = transactions.stream().mapToInt(t -> t.getValue()).max().getAsInt();
        System.out.println(max);

        System.out.println("8......");
        /** 8. 找到交易额最小的交易*/
        int min = transactions.stream().mapToInt(t -> t.getValue()).min().getAsInt();
        System.out.println(min);
    }
}
