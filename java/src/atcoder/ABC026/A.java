package atcoder.ABC026;

import java.util.Scanner;

public class A {

    /*
     問題文
     正の偶数 A が与えられる。

     x+y=A となる正の整数 x, y のうち、 x×y が最大となるものを選び、その値を出力しなさい。

     入力
     入力は以下の形式で標準入力から与えられる。

     A
     1 行目には、正の偶数 A(2≦A≦100) が与えられる。
     出力
     x×y の最大値を出力しなさい。 出力の末尾には改行を入れること。

     入力例1
     10
     出力例1
     25

     x=5, y=5 のとき、 x×y=25 となり、これが最大値となります。
     */

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        solve(n);


        System.out.println(solve(10));
        System.out.println(solve(60));

        System.out.println(solve2(10));
        System.out.println(solve2(60));

        System.out.println(solve3(10));
        System.out.println(solve3(60));
    }

    /**
     * 全探索での解法
     *
     */
    private static int solve(int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i * (n - i) > max) {
                max = i * (n - i);
            }
        }

        return max;
    }


    /**
     * 相加相乗平均の関係
     * x,y>0のとき、(x+y)/2 >= sqrt(x*y) (等号が成り立つのはx=yのとき)
     *
     * sqrt(x*y)が最大になるとき、x*yもまた最大になる
     * x*yが最大になるのはx=yのときで、今回はn=x+yなので
     * nを半分にしたのがそれぞれxとyになる
     */
    private static int solve2(int n) {

        return n / 2 * n / 2;

    }


    /**
     * ２次方程式を使った考え方
     *
     * xy = x(n - x) = -x^2 + nx = -(x - n/2)^2 + n^2/4
     * この上に凸の２次方程式はx=n/2のときに最大値n^2/4になる
     */
    private static int solve3(int n) {

        return n * n / 4;

    }

}
