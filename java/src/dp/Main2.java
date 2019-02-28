package dp;

public class Main2 {
    public static void main(String[] args) {

        dp1();

    }


    /*
    n個の整数 a[0],a[1],…,a[n−1]a[0],a[1],…,a[n−1] が与えられる。
    これらの整数から何個かの整数を選んで総和をとったときの、総和の最大値を求めよ。
    また、何も選ばない場合の総和は 0 であるものとする。
     */
    static void dp1() {
        int[] array = {7, -6, 9};
        int n = array.length;

        // DPテーブル
        int[] dp = new int[array.length + 10];

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i] + array[i]);
        }

        System.out.println(dp[n]);
    }
}
