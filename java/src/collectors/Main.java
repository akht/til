package collectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        List<String> list = Arrays.asList("a", "bb", "ccc", "dd");


        // リストの要素と、その長さからなるマップを作る
        Map<String, Integer> lengthMap = list.stream()
                                             .collect(Collectors.toMap(Function.identity(), String::length));

        System.out.println(lengthMap);


        // 要素を全てつなぐ
        String join = list.stream().collect(Collectors.joining());
        System.out.println(join);

        // デリミタを指定して連結
        String join2 = list.stream().collect(Collectors.joining(","));
        System.out.println(join2);

        // デリミタ,prefix,suffixを指定して連結
        String join3 = list.stream().collect(Collectors.joining(",", "{", "}"));
        System.out.println(join3);


        DoubleSummaryStatistics dss = list.stream().collect(Collectors.summarizingDouble(String::length));
        System.out.println(dss.getCount());     // 個数
        System.out.println(dss.getAverage());   // 平均
        System.out.println(dss.getMax());       // 最大
        System.out.println(dss.getMin());       // 最小
        System.out.println(dss.getSum());       // 合計


        // 要素の長さごとにグルーピングしてSetにし、長さをキーとしたMapを作る
        Map<Integer, Set<String>> map = list.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(map);


        Map<Boolean, List<String>> partition = list.stream().collect(Collectors.partitioningBy(s -> s.length() > 2));
        System.out.println(partition);


    }
}
