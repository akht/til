package atcoder.ABC098;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class B {

    /*
    英小文字からなる長さ N の文字列 S が与えられます。
    この文字列を一箇所で切断して、文字列 X と Y に分割します。
    このとき、「X と Y のどちらにも含まれている文字」の種類数を最大化したいです。
    文字列を切断する位置を適切に決めた際の「X と Y のどちらにも含まれている文字」の種類数の最大値を求めてください。
     */

    static int N;
    static String S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.next();

        solve();
    }

    static void solve() {

        int max = 0;
        for (int i = 1; i < N; i++) {

            String lhs = S.substring(0, i);
            String rhs = S.substring(i, N);

            max = Math.max(max, intersection(lhs, rhs));
        }

        System.out.println(max);
    }

    static int intersection(String s1, String s2) {

        Set<String> set1 = s1.chars().mapToObj(c -> String.valueOf((char)c)).distinct().collect(Collectors.toSet());
        Set<String> set2 = s2.chars().mapToObj(c -> String.valueOf((char)c)).distinct().collect(Collectors.toSet());

        set1.retainAll(set2);

        return set1.size();
    }

}
