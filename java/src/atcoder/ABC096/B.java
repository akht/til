package atcoder.ABC096;

import java.util.Scanner;

public class B {

    /*
    問題文
    黒板に, 3 つの正の整数 A,B,C が書かれています. E869120 君は, 以下の操作を K 回行います.

    黒板に書かれている整数のうち 1 つを選び, これを 2 倍した値に書き換える.
    さて, K 回の操作を終えた後の, 黒板に書かれる整数の合計としてありうる最大の値はいくつでしょうか？

    制約
    A,B,C は 1 以上 50 以下の整数
    K は 1 以上 10 以下の整数
     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.next());
        int b = Integer.parseInt(sc.next());
        int c = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());

        System.out.println(solve(a, b, c, k));
    }

    static int solve(int a, int b, int c, int k) {

        // a,b,cのうち最大の数を2倍すればよい

        int max = Math.max(Math.max(a, b), c);

        return (a + b + c - max) + max * (int)Math.pow(2, k);

    }
}
