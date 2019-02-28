package knapsack;

import java.util.Arrays;

/**
 * Knapsack.javaにメモ化を施したもの
 */

// Knapsack.javaではrec(i, j)が指数回数分だけ呼び出されるが、
// iとjが同じならばrec(i, j)の結果は常に一定になる。
// (使える品物と使える容量が一定なら価値の和の最大値も一定となるため)
// よって、rec_dp(i, j)の結果を配列に記憶しておけば、同じ計算をする手間を省ける。
public class KnapsackMemo {
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

    public static int rec_dp(int i, int j) {
        // すでに調べたことがあるならその結果を再利用
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int result;
        if (i == n) {
            // 品物が残っていない時は、価値の和の最大値は0
            result = 0;
        } else if (j < w[i]) {
            // 残りの容量が足りず品物iを入れられないので、入れないパターンだけを調べる
            // i+1以降の品物のみを使った時の最大値をそのままこの場合の最大値にする
            result = rec_dp(i + 1, j);
        } else {
            // 品物iを入れるか入れないか選べるので、両方試して価値の和が大きい方を選ぶ
            result = Math.max(
                    rec_dp(i + 1, j),
                    rec_dp(i + 1, j - w[i]) + v[i]
            );
        }
        // 結果をテーブルに記憶する
        dp[i][j] = result;
        return result;
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


        System.out.println(rec_dp(0, W));
    }
}

