package two_pointers;

public class TP3 {

    /*
    長さnの整数列 a1,a2,…,ana1,a2,…,an と整数Kが与えられる。
    整数列の連続する部分列で、その積が KK 以下となるもののうち、
    最大の長さを求めよ (条件を満たす区間がないときは0を出力)
     */

    public static void main(String[] args) {

        solve();

    }


    static int n = 7;
    static int K = 6;
    static int[] a = {4,3,1,1,2,10,2};

    public static void solve() {

        // 数列の中に0があれば最大の長さはnになる
        for (int n : a) {
            if (n == 0) {
                System.out.println(n);
                return;
            }
        }

        int max = 0;
        int mult = 1;
        int r = 0;
        for (int l = 0; l < n; l++) {

            while (r < n && mult * a[r] < K) {
                mult *= a[r];
                r++;
            }

            max = Math.max(max, r - l);

            if (l == r) {
                r++;
            } else {
                mult /= a[l];
            }
        }

        System.out.println(max);
    }
}
