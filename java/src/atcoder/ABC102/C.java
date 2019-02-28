package atcoder.ABC102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(sc.nextInt());
        }

        solve();
    }

    static int N;
    static List<Integer> A;

    static void solve() {

        // An - nの中央値を求める
        List<Integer> calcList = new ArrayList<>();
        for (int i = 0;i < N; i++) {
            calcList.add(A.get(i) - (i+1));
        }


        Collections.sort(calcList);


        if (calcList.size() % 2 == 0) {
            int i1 = calcList.size() / 2 - 1;
            int m1 = calcList.get(i1);

            int i2 = calcList.size() / 2;
            int m2 = calcList.get(i2);

            System.out.println(Math.min(calc(m1), calc(m2)));
        } else {
            int i = calcList.size() / 2;
            int m = calcList.get(i);

            System.out.println(calc(m));
        }
    }

    static long calc(int b) {
        long sum = 0;
        for (int i = 0; i < A.size(); i++) {

            sum += Math.abs(A.get(i) - (b + i + 1) );

        }

        return sum;
    }
}
