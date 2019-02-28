package dp;

public class Dp4 {

    /*
    部分和数え上げ問題

    n個の正の整数 a[0],a[1],…,a[n−1]a[0],a[1],…,a[n−1] と正の整数Aが与えられる。
    これらの整数から何個かの整数を選んで総和がAになるようにする方法が何通りあるかを求めよ。
     */

    public static void main(String[] args) {

        solve();

    }


    static int n = 5;
    static int[] array = {7,5,3,1,8};
    static int A = 12;

    public static void solve() {

        // DPテーブル
        // dp[i+1][j] = i番目までの整数のなかからいくつか選んで総和をjとする場合の数
        // とすると、dp[i+1][j]の値を求めるには、以下の２つの場合を加算すればよい
        // (1) array[i]を選ぶ場合
        //      dp[i][j-array[i]]通り
        // (2) array[i]を選ばない場合
        //      dp[i][j]通り
        // まとめると
        // <DP漸化式>
        // dp[i+1][j] = {
        //                dp[i][j-array[j]] + dp[i][j] (j >= array[i]) - 選ぶ場合
        //                dp[i][j]                     (j < array[i]) - 選ばない場合
        //              }
        // <DP初期条件>
        // dp[0][j] = {
        //              1 (j == 0) (0個の整数の和は0とみなせるので1通り)
        //              0 (j != 0)
        //            }
        int[][] dp = new int[110][10010];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= A; j++) {
                if (j >= array[i]) {
                    // 選ぶとき
                    dp[i+1][j] = dp[i][j-array[i]]+ dp[i][j];
                } else {
                    // 選ばないとき
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }

        System.out.println(dp[n][A]);
    }
}
