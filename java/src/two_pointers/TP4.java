package two_pointers;

public class TP4 {

    /*
    長さnの正の整数列 a1,a2,…,ana1,a2,…,an が与えられる。
    整数列の連続する部分列のうち、単調増加となっているものを数え上げよ。
     */


    public static void main(String[] args) {

        solve();

    }

    static int n = 5;
    static int[] a = {1,2,3,2,1};

    static void solve() {

        int count = 0;
        int right = 1;  // [0,0)は確実に条件を満たす
        for (int left = 0; left < n; left++) {

            while (right < n && (right <= left || a[right - 1] < a[right])) {
                right++;
            }

            count += right - left;

            if (left == right) {
                right++;
            } else {
                // leftをインクリメントするが
                // 総和から引いたりなどの操作は不要なので何もしない
            }
        }

        System.out.println(count);
    }
}
