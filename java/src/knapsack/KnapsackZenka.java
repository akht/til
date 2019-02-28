package knapsack;

import java.util.Arrays;

/**
 * ナップサック問題を漸化式を用いて実装
 */
public class KnapsackZenka {
    // 品物の個数の最大値
    static int MAX_N = 100;
    static int MAX_W = 500;
    // 品物の個数
    static int n;
    // ナップサックの容量
    static int W;
    // i番目の品物の重さをw[i],
    // i番目の品物の価値をv[i]で表す
    static int[] w = new int[MAX_N];
    static int[] v = new int[MAX_N];

    // メモ化テーブル
    // dp[i][j]はi番目以降の品物から重さの和がj以下になるように選んだ時の
    // 価値の和の最大値を表す。
    // -1なら値が未決定であることを表す。
    static int dp[][] = new int[MAX_N + 1][MAX_W + 1];

    //dp[i][j]の変化を観察すると、iが大きくjが小さい順(使える品物と容量が少ない順)にメモの値が確定していくことがわかる。
    // dp[n][j] = 0;
    // dp[i][j] = dp[i+1][j]  (j < w[i])
    //          = max{ dp[i+1][j], dp[i+1][j-w[i]] + v[i} (j >= w[i])
    public static void solve() {
        for (int j = 0; j <= W; j++) {
            dp[n][j] = 0;
        }
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j <= W; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i+1][j];
                } else {
                    dp[i][j] = Math.max(
                            dp[i+1][j],
                            dp[i+1][j - w[i]] + v[i]
                    );
                }
            }
        }
    }

    public static void main(String[] args) {
        w[0] = 11;
        v[0] = 15;
        w[1] = 2;
        v[1] = 3;
        w[2] = 3;
        v[2] = 1;
        w[3] = 4;
        v[3] = 4;
        w[4] = 1;
        v[4] = 2;
        w[5] = 5;
        v[5] = 8;

        n = 6;
        W = 15;

        // メモ化テーブルを-1で初期化
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        solve();
        System.out.println(dp[0][W]);
    }
}
