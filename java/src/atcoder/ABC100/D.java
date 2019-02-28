package atcoder.ABC100;

import java.util.*;
import java.util.stream.Collectors;

public class D {

    /*
    問題文
    高橋君はプロのパティシエになり, AtCoder Beginner Contest 100 を記念して, 「ABC洋菓子店」というお店を開いた.

    ABC洋菓子店では, N 種類のケーキを売っている.
    各種類のケーキには「綺麗さ」「おいしさ」「人気度」の 3 つの値を持ち, i 種類目のケーキの綺麗さは xi, おいしさは yi, 人気度は zi である.
    これらの値は 0 以下である可能性もある.

    りんごさんは, ABC洋菓子店で M 個のケーキを食べることにした. 彼は次のように, 食べるケーキの組み合わせを選ぶことにした.

    同じ種類のケーキを 2 個以上食べない.
    上の条件を満たしつつ, (綺麗さの合計の絶対値) + (おいしさの合計の絶対値) + (人気度の合計の絶対値) が最大になるように選ぶ.
    このとき, りんごさんが選ぶケーキの (綺麗さの合計の絶対値) + (おいしさの合計の絶対値) + (人気度の合計の絶対値) の最大値を求めなさい.

    制約
    N は 1 以上 1 000 以下の整数
    M は 0 以上 N 以下の整数
    xi,yi,zi (1≤i≤N) は, それぞれ −10 000 000 000 以上 10 000 000 000 以下の整数.
     */

    static int N;
    static int M;
    static List<long[]> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            long z = sc.nextLong();

            list.add(new long[]{x, y, z});
        }

        solve();
    }

    // まず、|x|を考える(xの絶対値)と、|x| = max(x, -x)となる。
    // (元の数字と、符号を反転した数字との大きいほうが絶対値)
    // つまり、|x|+|y| = max(x, -x)+max(y, -y)となり
    // 展開すると
    // |x|+|y| = max(x+y, x-y, -x+y, -x-y)となることがわかる。
    //
    // よって、x, y, zと３つの要素があるとき
    // |x|+|y|+|z|=max(x, -x)+max(y, -y)+max(z, -z)となり、
    // 展開すると
    // |x|+|y|+|z| = max(
    //                   x + y + z,
    //                   x + y - z,
    //                   x - y + z,
    //                   x - y - z,
    //                  -x + y + z,
    //                  -x + y - z,
    //                  -x - y + z,
    //                  -x - y - z
    //                  )
    // ということになる。
    // あとは、上の8通りの計算でそれぞれのケーキの数値を計算して、
    // それの上位M個を取って合計し、
    // 8パターンなかからその合計が最大になるものを出力すればよい
    static void solve() {
        List<int[]> signs = new ArrayList<>();
        signs.add(new int[]{ 1,  1,  1});
        signs.add(new int[]{ 1,  1, -1});
        signs.add(new int[]{ 1, -1,  1});
        signs.add(new int[]{ 1, -1, -1});
        signs.add(new int[]{-1,  1,  1});
        signs.add(new int[]{-1,  1, -1});
        signs.add(new int[]{-1, -1,  1});
        signs.add(new int[]{-1, -1, -1});

        long max = 0;
        for (int[] sign : signs) {
            max = Math.max(
                    max,
                    list.stream()
                        .map(xyz -> xyz[0] * sign[0] + xyz[1] * sign[1] + xyz[2] * sign[2])
                        .sorted(Comparator.reverseOrder())
                        .limit(M)
                        .mapToLong(Long::longValue)
                        .sum()
            );
        }

        System.out.println(max);
    }

}
