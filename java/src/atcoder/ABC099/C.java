package atcoder.ABC099;

import java.util.*;
import java.util.stream.Collectors;

public class C {

    /*
    ある銀行では、お金の引き出しを難しくするために、一回の操作で引き出せる金額が以下のいずれかとなっています。
    1 円
    6 円、6^2(=36) 円、6^3(=216) 円、…
    9 円、9^2(=81) 円、9^3(=729) 円、…
    この銀行からちょうど N 円を引き出すには少なくとも何回の操作が必要か求めてください。
    ただし、一度引き出したお金を再び預け入れてはならないとします。
     */

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

//        solve();

        test();
    }


    public static void solve() {

        // 6の累乗を持っておく
//        int[] pow6 = new int[10];
//        int[] pow9 = new int[10];
//        for (int i = 0; i < 100; i++) {
//            int p6 = (int)Math.pow(6, i+1);
//            if (p6 > 100000) {
//                break;
//            }
//            pow6[i] = p6;
//
//            int p9 = (int)Math.pow(9, i+1);
//            if (p9 < 100000) {
//                pow9[i] = p9;
//            }
//        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int p6 = (int)Math.pow(6, i+1);
            if (p6 > 100000) {
                break;
            }
            list.add(p6);

            int p9 = (int)Math.pow(9, i+1);
            if (p9 < 100000) {
                list.add(p9);
            }
        }
        Collections.sort(list);



        System.out.println(list);
    }

    public static void test() {
        int min = N;
        for (int i = 0; i <= N; i++) {
            int count = 0;
            int t = i;
            while (t > 0) {
                count += t % 6;
                t /= 6;
            }

            t = N - i;

            while (t > 0) {
                count += t % 9;
                t /= 9;
            }

            min = Math.min(min, count);
        }
        System.out.println(min);
    }
}
