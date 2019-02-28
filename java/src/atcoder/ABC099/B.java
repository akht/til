package atcoder.ABC099;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class B {

    /*
    ある村には、高さ 1,(1+2),(1+2+3),…,(1+2+3+…+999) メートルの 999 本の塔が、西から順に 1 メートル間隔で立っています。
    長く降り続けた雪がようやく収まったので、まだ雪に完全には埋もれていない、互いに 1 メートル離れたある 2 つの塔の、雪に埋もれていない部分の高さを測ったところ、
    西側の塔は a メートル、東側の塔は b メートルでした。
    積雪量と標高が村内のどこでも等しいと仮定したとき、雪が何メートル積もっているか求めてください。
    ただし、雪は必ず 1 メートル以上積もっているものとします。
     */

    static int a;
    static int b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        solve();
    }

    public static void solve() {

        // 1番目の塔から順に1, (1+2), (1+2+3), ... (1+2+3+...+999)なので
        // 右隣の塔との差は2, 3, ..., 999となる

        // b - aの差で、どの２つの塔なのかがわかるので
        // 元の塔の長さから与えられた長さを引けば積雪量がわかる


        int bHeight = IntStream.rangeClosed(1, b - a).sum();

        System.out.println(bHeight - b);
    }
}
