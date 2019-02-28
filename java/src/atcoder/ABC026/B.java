package atcoder.ABC026;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {

    /*
    高橋君は、丸が大好きです。今日も、原点を中心とした大きさの違う円を
    N個書きました。

    その円の集合に対し、外側から赤白交互に色を塗ったとき、赤く塗られる部分の面積を出力しなさい。
     */

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//
//        int[] array = new int[n];
//        for (int i = 0; i < n; i++) {
//            array[i] = sc.nextInt();
//        }
//
//        solve(array);

        int[] a = {15,2,3,7,6,9};
//        int[] a = {1,2,3};
        solve(a);

    }

    private static void solve(int[] array) {
        Arrays.sort(array);

        int count = 0;
        double a = 0;
        for (int i = array.length-1; i >= 0; i--) {
            if (count % 2 == 0) {
                a += array[i] * array[i];
            } else {
                a -= array[i] * array[i];
            }
            count++;
        }

        System.out.println( a * Math.PI );
    }
}
