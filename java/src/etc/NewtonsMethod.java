package etc;

public class NewtonsMethod {
    private static double sqrt(double x) {
        double z = 1.0;

        double p = 0;	// 前回の計算結果

        for (int i = 0; i < 10000; i++, p = z) {
            z = z - (z * z - x) / (2 * z);	// 左辺のzがZn+1になる

            // 前回の計算結果との差が非常に小さくなったら終了
            if (Math.abs(z - p) < 1.0e-10) {
                System.out.println(i + "回目");
                break;
            }
        }

        return z;
    }


    public static void main(String[] args) {

        int x = 3;

        System.out.println("Math.sqrt(" + x + ") = " + Math.sqrt(x));

        System.out.println("sqrt(" + x + ") = " + sqrt(x));
    }
}
