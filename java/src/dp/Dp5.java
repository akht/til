package dp;

import java.util.Arrays;

public class Dp5 {

    /*
    最小個数部分和問題

    n個の正の整数 a[0],a[1],…,a[n−1]a[0],a[1],…,a[n−1] と正の整数Aが与えられる。
    これらの整数から何個かの整数を選んで総和が AA にする方法をすべて考えた時、
    選ぶ整数の個数の最小値を求めよ。
    Aにすることができない場合は -1 と出力せよ


     */

    public static void main(String[] args) {

        solve();

    }


    static int n = 5;
    static int[] array = {7,4,3,1,8};
    static int A = 12;

    public static void solve() {

        // DPテーブル
        // dp[i+1][j]は、
        // 「i番目までの整数の中からいくつか選んで総和をjとする方法を全て考えたときの、選んだ整数の個数の最小値」
        int[][] dp = new int[1000][1000];

        // 十分大きい数で初期化する
        int INF = 1 << 29;
        for (int[] a : dp) {
            Arrays.fill(a, INF);
        }

        // ひとつも選ばなければ総和は0なので
        // 選ぶ整数の個数の最小値は0
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= A; j++) {
                if (j >= array[i]) {
                    // 選んだとき
                    dp[i+1][j] = Math.min(dp[i][j], dp[i][j-array[i]] + 1);
                } else {
                    // 選ばないとき
                    dp[i+1][j] = dp[i][j];
                }
            }
        }

        if (dp[n][A] < INF) {
            System.out.println(dp[n][A]);
        } else {
            System.out.println(-1);
        }

    }
}
