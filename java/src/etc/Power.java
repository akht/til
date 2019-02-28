package etc;

public class Power {

    /**
     * 累乗計算
     */

    public static void main(String[] args) {

//        System.out.println(power2(2, 0));
//        System.out.println(power2(2, 1));
//        System.out.println(power2(2, 2));
//        System.out.println(power2(2, 3));
//        System.out.println(power2(2, 4));
//        System.out.println(power2(2, 5));



//        int n = 22;
//        System.out.println(Integer.toBinaryString(n));
//        n >>= 1;
//        System.out.println(Integer.toBinaryString(n));


        System.out.println(power3(3, 5));
    }

    // 累乗計算
    // 単純にxをn回かける　O(n)
    static int power(int x, int n) {

        int pow = 1;
        for (int i = 1; i <= n; i++) {
            pow *= x;
        }

        return pow;
    }

    // 高速化を図ったもの(再帰)
    // x^nにおいてnが偶数のとき、x^n = (x^2)^n/2と等しくなることを利用
    // (例) 6^6 = 36^3, 9^8 = 81^4
    // こうすることで、毎回半分になるので計算量はO(logN)になる
    static int power2(int x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            return power2(x * x, n / 2);
        } else {
            return x * power2(x, n - 1);
        }

    }

    // 繰り返し二乗法
    // http://fantom1x.blog130.fc2.com/blog-entry-203.html
    static int power3(int x, int n) {
        int sum = 1;
        while (0 < n) {
//            System.out.println(Integer.toBinaryString(n));
            if ((n & 1) == 1) {
                // 最後のビットが1ならかけていく
                sum *= x;

//                System.out.println("sum=" + sum + " * " + x);
            }

            x *= x; // ここで各桁ごとに２乗して増やしていく
//            System.out.println("x = " + x);

            n >>= 1;// 桁をひとつ落とす(=10進数的には2で割る)
//            System.out.println(Integer.toBinaryString(n));
//            System.out.println("-------");
        }
        return sum;
    }
}
