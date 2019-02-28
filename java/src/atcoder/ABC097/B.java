package atcoder.ABC097;

import java.util.Scanner;

public class B {
    /*
    問題文
    正整数 X が与えられます。 X 以下の最大のべき乗数を求めてください。
    ただし、べき乗数とは、ある 1 以上の整数 b と 2 以上の整数 p を使って bp とかける整数のことを指すこととします。

    制約
    1 ≤ X ≤ 1000
    X は整数

    入力
    入力は以下の形式で標準入力から与えられる。

    出力
    X 以下の最大のべき乗数を出力せよ。
     */

    static int X;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();

        solve();
    }

    static void solve() {

        // Xの平方根の小数部分を切り捨ててそれを2乗したものが答え
        // ↑まちがい
        // 2乗とは限らないのでこれではダメ
        // 例)28と入力されたら、↑の方法では25を出力するが3^3=27が正解

        // 冪根でやる

        int MAX_ROOT = (int)Math.sqrt(X);   // Xは1000以下なので最大でも根は31までになる

        int max = 1;
        for (int i = 2; i <= MAX_ROOT; i++) {
            for (int j = 1; j <= 9; j++) {      // 仮に最も小さい2でも、10乗すると1024で1000を超えるので9まででよい

                if ((int)Math.pow(i, j) > X) {
                    break;
                }

                max = Math.max((int)Math.pow(i, j), max);

            }
        }

        System.out.println(max);
    }

}
