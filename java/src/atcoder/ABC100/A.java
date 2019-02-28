package atcoder.ABC100;

import java.util.Scanner;

public class A {

    /*
    もうすぐ E869120 君と square1001 君の 16 才の誕生日が来る.
    そこで, AtCoder 王国の高橋君は, 円形のケーキ 1 個に放射状に切れ目を入れ 16 等分したものを, 彼らにプレゼントした.

    E869120 君はそのうち A 切れ、square1001 君は B 切れを食べようとした.
    しかし, ケーキと一緒についていた紙を見ると, 「同じ人が隣り合う 2 切れのケーキを両方取ってはならない」と書かれていた.

    さて、彼らは紙に書かれたことを守って、2 人とも食べたい数のケーキを取ることができるだろうか？

    制約
    A,B は 1 以上 16 以下の整数
    A+B は 16 以下である.
     */

    static int A;
    static int B;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        solve();
    }

    public static void solve() {

        if (A <= 8 && B <= 8) {
            System.out.println("Yay!");
        } else {
            System.out.println(":(");
        }
    }
}
