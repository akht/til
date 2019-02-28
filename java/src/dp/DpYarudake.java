package dp;

public class DpYarudake {
    public static void main(String[] args) {

    }

    /**
     *  A_0=1, A_1=1のフィボナッチ数列A_nのn番目の値を返す関数<br>
     *  再帰バージョン
     */
    static int fib(int n) {
        if (n == 0) { return 0; }
        if (n == 1) { return 1; }
        return fib(n-1) + fib(n-2);
    }


    /**
     * A_0=1, A_1=1のフィボナッチ数列A_nの結果をresult[n]に格納する<br>
     * 再帰しないバージョン
     */
    static int[] fib() {
        int[] result = new int[1000];
        result[0] = 0;
        result[1] = 1;
        for (int i = 1; i < 1000; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result;
    }


    // 問題
    // サイズNのintの配列A[N]が与えられる
    // 与えられた配列の中身のうち、最大値を求めよ
    // 制約 1 <= A[i] <= 100000, 1 <= A[i] <= 100000000 (0 <= i < N)

    // 素直に書いたやつ
    static int maxOfArray(int A[], int N) {
        int max = -999999999; // Aのどの要素より必ず小さい値で初期化
        for (int i = 0; i < N; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }

}
