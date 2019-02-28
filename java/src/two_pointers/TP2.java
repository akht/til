package two_pointers;

public class TP2 {

    /*
    長さnの正の整数列 a1,a2,…,ana1,a2,…,an と整数 xx が与えられる。
    整数列の連続する部分列で、その総和がx以上となるもののうち、最小の長さを求めよ
     */

    public static void main(String[] args) {

        solve();

    }

    static int n = 10;
    static int x = 28;
    static int[] a = {5,2,3,5,10,7,4,9,2,8};

    public static void solve() {

        // 区間の長さの最小値(上界n+1を入れておく)
        int min = n + 1;

        // 区間の総和
        int sum = 0;

        // 右端
        int right = 0;

        // 区間の左端で場合分け
        for (int left = 0; left < n; left++) {

            // [left,right)の総和がx以上となる最小のrightを求める
            // = 満たさない最大の位置まで進めればよい
            while (right < n && sum < x) {
                // rightが右端まで行くか、総和を超えたら終わり
                sum += a[right];
                right++;
            }

            if (sum < x) {
                // ここに来るのは上のwhileの条件で、right < nになったとき
                // つまり最後までいったときなので、この時点でsum < xになって入れば
                // これ以上leftを進めても無駄なので終了
                break;
            } else {
                // 現在の最小値と今の区間を比べる
                min = Math.min(min, right - left);
            }

            // leftを動かす準備
            if (right == left) {
                // leftがrightに重なっていたらrightも動かす
                right++;
            } else {
                // leftのみが動くのでsumからa[left]を引く
                sum -= a[left];
            }
        }

        if (min < n + 1) {
            System.out.println(min);
        } else {
            System.out.println(0);
        }

    }
}
