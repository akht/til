package awesome_java_leet_code;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/069/README.md
public class Q69_Sqrt {

    /**
     * Implement int sqrt(int x).
     *
     * Compute and return the square root of x.
     * x is guaranteed to be a non-negative integer.
     */

    public static void main(String[] args) {

        System.out.println(sqrt(2));
        System.out.println(sqrt(3));
        System.out.println(sqrt(4));
        System.out.println(sqrt(5));
        System.out.println(sqrt(6));

    }

    // ニュートン法で平方根を求める
    static double sqrt(int x) {
        // 初期値(とりあえず元の値としておく。平方根はこれよりは必ず小さくなるため)
        double d = x;

        // d^2が元の数より大きいかぎり計算を続ける
        while (true) {
            double before = d;
            d = (d + x / d) / 2;

            if (Math.abs(before - d) < 1.0e-10) {
                // 計算後が誤差レベルになったら終了
                break;
            }
        }
        return d;
    }

}
