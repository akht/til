package atcoder.ABC095;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {


    static int N;
    static int X;
    static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.next());
        X = Integer.parseInt(sc.next());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(sc.nextInt());
        }

        solve();
    }

    static void solve() {
        int sum = list.stream().mapToInt(x -> x).sum();
        int min = Collections.min(list);

        System.out.println(list.size() + ((X - sum) / min));
    }
}