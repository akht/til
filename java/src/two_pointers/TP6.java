package two_pointers;

public class TP6 {

    /*
    長さnの正の整数列 a1,a2,…,ana1,a2,…,an が与えられる。
    整数列の連続する部分列のうち、「xor 和と加算和とが等しい」という条件を満たすものを数え上げよ。
     */

    public static void main(String[] args) {

        solve();

    }

    static int n = 4;
    static int[] a = {2,5,4,6};

    public static void solve() {

        // 「条件を満たす区間の部分区間も条件を満たす」という構造になっているかの考察

        // 「A xor B」「A + B」を考える
        // xor和の場合、例えばある桁にAとBのどちらもビットが立っていると
        // 打ち消しあって0になってしまう
        // 加算和の場合、両方にビットが立っていると次の位繰り上がる
        // つまり、xorには繰り上がりがないが、加算和には繰り上がりがあるので
        // xorと加算和が等しくなるには、どの桁を見てもAとBのうちビットが立っているのは高々一方のみ、ということになる
        // この条件だと、確かに「条件を満たす区間の部分区間もまた条件を満たす」という構造を満たしていることがわかる

        // ※実装では各桁のビットをみるのは面倒なので、直接 sum xor a[right] == sum + a[right]という条件を使う

        int count = 0;
        int sum = 0; // 加算和
        int right = 0;
        for (int left = 0; left < n; left++) {


            while (right < n && ((sum ^ a[right]) == sum + a[right])) {
                sum += a[right];
                right++;
            }

            count += right - left;

            if (left == right) {
                right++;
            } else {
                sum -= a[left];
            }
        }

        System.out.println(count);
    }
}
