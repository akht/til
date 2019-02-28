package atcoder.ABC100;

import java.util.Scanner;

public class C {

    /*
    問題文
    AtCoder Beginner Contest 100 の開催にともなって,
    AtCoder 社では長さ N の数列 a={a1,a2,a3,…,aN} が飾られることになった.
    社員のすぬけ君は, この数列で遊んでみようと思った.

    具体的には, 以下の操作をできるだけ多くの回数繰り返そうと思った.

    1≤i≤N を満たす全ての i に対して, それぞれ「ai の値を 2 で割る」「ai の値を 3 倍する」のどちらかを行う.
    ただし, 全ての i に対して 3 倍することはできず, 操作後の ai の値は整数でなければならない.
    最大で何回の操作が可能か, 求めなさい.

    制約
    N は 1 以上 10 000 以下の整数
    ai は 1 以上 1 000 000 000 以下の整数
     */

    static int N;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        solve();
    }

    static void solve() {
        // 各aiについて、2の何乗になっているか調べて合計する

        long sum = 0;
        for (int ai : a) {

            int temp = 0;
            while (true) {
                if (ai % 2 == 0) {
                    temp++;
                    ai /= 2;
                } else {
                    break;
                }
            }
            sum += temp;
        }

        System.out.println(sum);
    }
}
