package dp;

import atcoder.ABC026.A;

public class Dp3 {

    /*
    部分和問題
    https://qiita.com/drken/items/a5e6fe22863b7992efdb

    n個の正の整数 a[0],a[1],…,a[n−1]a[0],a[1],…,a[n−1] と正の整数Aが与えられる。
    これらの整数から何個かの整数を選んで総和がAになるようにすることが可能か判定せよ。
    可能ならば "YES" と出力し、不可能ならば "NO" と出力せよ。

     */

    public static void main(String[] args) {

        solve();

    }

    static int n = 3;
    static int A = 11;
    static int[] array = {7, 5, 4};

    static void solve() {

        // DPテーブル
        // dp[i+1][j]は、i番目までの整数のなかからいくつか選んで総和をjとすることができるかどうか
        boolean[][] dp = new boolean[1000][1000];

        // 初期値(なにも選ばなければ総和は0なのでtrue)
        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= A; j++) {
                dp[i+1][j] |= dp[i][j];
                if (j >= array[i]) {
                    dp[i+1][j] |= dp[i][j-array[i]];
                }
            }
        }

        System.out.println(dp[n][A] ? "Yes" : "No");
    }


}





