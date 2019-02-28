package dp;

public class Dp1 {

    /*
    問題１：最大和問題
    https://qiita.com/drken/items/a5e6fe22863b7992efdb

    n個の整数 a[0],a[1],…,a[n−1]a[0],a[1],…,a[n−1] が与えられる。
    これらの整数から何個かの整数を選んで総和をとったときの、総和の最大値を求めよ。
    また、何も選ばない場合の総和は 0 であるものとする。
     */

    public static void main(String[] args) {

        dp();


        dfs(0, 0);
        System.out.println(max);

    }

    static int n = 3;
    static int[] a = {7, -6, 9};

    // DP
    static void dp() {

        // すでにdp[i]の値が求まっていることを前提に、do[i+1]の値を求めることを考える
        // dp[i]を使ってdp[i+1]を考えるとき、
        // a[0],a[1],...,a[i-1]のどれを選んだら良いかが既に決まっているので、
        // a[i]を選ぶか選ばないかだけ決めれば良い
        // ・選ぶとき
        //      dp[i]にa[i]が加算されるので、dp[i+1] = dp[i] + a[i]となる
        // ・選ばないとき
        //      dp[i]は何も加算されれないので、dp[i+1] = dp[i]となる
        // よって、選んだときと選ばないときのmaxを取ればよいということになる
        // <DP遷移式>
        //      dp[i+1] = max(dp[i], dp[i] + a[i])
        // 遷移していくためには初期値が必要
        // <初期値>
        //      dp[0] = 0(何も選んでいない状態)
        // あとは以上を実装する

        // DPテーブル
        // dp[0]は、何も選ばない状態
        // dp[i]は、0番目までの要素の中から選んで総和を取った時の、総和の最大値
        // ...
        // dp[i+1]は、i番目までの要素の中から選んで総和を取った時の、総和の最大値
        // 求める値は、dp[n]になる
        int[] dp = new int[1000];
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            dp[i+1] = Math.max(dp[i], dp[i] + a[i]);
        }

        System.out.println(dp[n]);
    }

    static int max = 0;
    // 深さ優先探索(再帰)だとこんな感じ
    static void dfs(int index, int sum) {

        if (index == a.length) {
            max = Math.max(max, sum);
            return;
        }

        dfs(index+1, sum);
        dfs(index+1, sum + a[index]);
    }
}
