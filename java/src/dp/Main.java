package dp;

public class Main {
    /**
     * フィボナッチ数列の第n項を返す関数fib(n)をつくる
     */


    /**
     * 単純な全探索(再帰)
     */
    static int fib(int n) {
        if (n == 0) { return 1; }
        if (n == 1) { return 1; }

        return fib(n - 1) + fib(n - 2);
    }


    /**
     * メモ化再帰
     */
    static int[] memo = new int[10000005];
    static int fib2(int n) {
        if (memo[n] > 0) { return memo[n]; }

        if (n <= 1) {
            memo[n] = 1;
        }

        memo[n] = fib2(n - 1) + fib2(n - 2);

        return memo[n];
    }


    /**
     * DP
     */
    static int[] dp = new int[1000009];
    static void init() {
        dp[0] = dp[1] = dp[1];

        for (int i = 2; i < 10000; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
    }
    int fib3(int n) {
        return dp[n];
    }

}
