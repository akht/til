package atcoder.ABC097;

import java.util.*;

public class D {

    /*
    問題文
    1 から N までの整数を並び替えた順列 p1, p2, .., pN があります。
    また、 1 以上 N 以下の整数のペアが M 個与えられます。
    これらは (x1,y1), (x2,y2), .., (xM,yM) で表されます。
    シカの AtCoDeer くんは順列 p に次の操作を好きなだけ行って、 pi=i となる i (1 ≤ i ≤ N) の数を最大にしようと考えています。

    1 ≤ j ≤ M なる j を選び、 pxj と pyj をスワップする
    操作後の pi=i となる i の数として考えうる最大値を求めてください。

    制約
    2 ≤ N ≤ 105
    1 ≤ M ≤ 105
    p は 1 から N までの整数を並び替えた順列
    1 ≤ xj,yj ≤ N
    xj ≠ yj
    i ≠ j なら、 {xi,yi} ≠ {xj,yj}
    入力は全て整数

    出力
    操作後の pi=i となる i (1 ≤ i ≤ N) の数として考えうる最大値を出力せよ。
     */

    static int N;
    static int M;
    static List<Integer> p = new ArrayList<>();
    static List<int[]> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int M = Integer.parseInt(sc.next());

        String pstr = sc.nextLine();
        for (int i = 0; i < N; i++) {
            p.add(Integer.parseInt(sc.next()));
        }

        path.add(new int[]{-1,-1});
        for (int i = 0; i < M; i++) {
            path.add(new int[]{Integer.parseInt(sc.next()), Integer.parseInt(sc.next())});
        }


        solve();
    }

    static void solve() {
        // 昇順に並んでいれば終了
        if (isSorted()) {
            System.out.println(p.size());
            return;
        }

        int count = 0;
        for (int i = 0; i < p.size(); i++) {

            int from = i + 1;
            int to = p.get(i);

            System.out.println(i + " from=" + from + " to="+to);

            Deque<int[]> stack = new ArrayDeque<>();
            for (int j = 1; j <= path.size(); j++) {
                int[] xy = path.get(j);
                if (xy[0] == from || xy[1] == from) {



                }
            }

        }





        System.out.println(p);
    }

    // 操作が不要かどうかチェック(小さい順に並んでいるか)
    static boolean isSorted() {

        for (int i = 0; i < p.size(); i++) {
            if (i + 1 != p.get(i)) {
                return false;
            }
        }

        return true;
    }
}
