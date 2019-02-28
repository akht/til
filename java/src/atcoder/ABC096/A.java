package atcoder.ABC096;

import java.util.Scanner;

public class A {

    /*
    A - Day of Takahashi
    問題文
    AtCoder 王国では, 5 月 5 日のような月の数と日の数が同じ日を「高橋」と言う.
    2018 年 1 月 1 日から 2018 年 a 月 b 日までに, 「高橋」は何日あるか.
    ただし, AtCoder 王国ではグレゴリオ暦を利用しているものとする.

    制約
    a は 1 以上 12 以下の整数
    b は 1 以上 31 以下の整数
    2018 年 a 月 b 日はグレゴリオ暦において正しい日付である.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.next());
        int b = Integer.parseInt(sc.next());

        System.out.println(solve(a, b));
    }

    static int solve(int a, int b) {
        return a > b ? a - 1 : a;
    }

}
