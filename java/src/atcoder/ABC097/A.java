package atcoder.ABC097;

import java.util.Scanner;

public class A {
    /*
    問題文
    数直線上にいるAさんとBさんとCさんがトランシーバーで会話をしようとしています。 Aさんは a[m] 地点、Bさんは b[m] 地点、Cさんは c[m] 地点にいます。
     二人の人間は、距離が d[m] 以内のとき直接会話が出来ます。 AさんとCさんが直接的、あるいは間接的に会話ができるか判定してください。
     ただしAさんとCさんが間接的に会話ができるとは、AさんとBさんが直接会話でき、かつBさんとCさんが直接会話できることを指します。

     制約
     ・1 <= a,b,c <= 100
     ・1 <= d <= 100
     ・入力は全て整数

    入力
    入力は以下の形式で標準入力から与えられる。
    a b c d

    出力
     会話できるなら Yes を, できないなら No を出力せよ。
     */

    static int a;
    static int b;
    static int c;
    static int d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        solve();
    }

    static void solve() {
        if (Math.abs(a - c) <= d || (Math.abs(a - b) <= d && Math.abs(b - c) <= d)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
