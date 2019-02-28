package atcoder.ABC095;

import java.util.Scanner;

public class C {

    /*
    ファーストフードチェーン「ピザアット」のメニューは「A ピザ」「B ピザ」「AB ピザ」の3種類です。
    A ピザと B ピザは全く異なるピザで、
    これらをそれぞれ半分に切って組み合わせたものが AB ピザです。
    A ピザ、B ピザ、AB ピザ 1 枚あたりの値段はそれぞれ A 円、B 円、C 円です。

    中橋くんは、今夜のパーティーのために A ピザ X 枚と B ピザ Y 枚を用意する必要があります。
    これらのピザを入手する方法は、A ピザや B ピザを直接買うか、
    AB ピザ 2 枚を買って A ピザ 1 枚と B ピザ 1 枚に組み替える以外にはありません。
    このためには最小で何円が必要でしょうか？
    なお、ピザの組み替えにより、必要な量を超えたピザが発生しても構いません。
     */

    static int A;
    static int B;
    static int C;
    static int X;
    static int Y;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();

        solve();
    }

    public static void solve() {
        long sum = 0;

        if (A + B > C * 2) {
            // Cで、AとBを同じ数だけ作る

            if (X > Y) {
                sum = C * Y * 2;

                if (A < C * 2) {
                    sum += (X - Y) * A;
                } else {
                    sum += (X - Y) * C * 2;
                }

            } else {
                sum = C * X * 2;

                if (B < C * 2) {
                    sum += (Y - X) * B;
                } else {
                    sum += (Y - X) * C * 2;
                }
            }
        } else {
            // AとBでそれぞれ作る
            sum = A * X + B * Y;
        }

        System.out.println(sum);
    }
}
