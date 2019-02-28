package atcoder.ABC097;

import java.util.*;

public class C {

    /*
    問題文
    文字列 s が与えられます。 s の異なる substring のうち、辞書順で K 番目に小さいものを出力してください。

    ただし、s の substring とは、 s の空でない連続した部分を取り出してできる文字列とします。
    例えば、 s = ababc とすると、 a, bab, ababc は s の substring ですが、 ac, z, 空文字列 は s の substring ではありません。
    また、substring が異なるとは、文字列として異なることを指します。

    なお、X=x1x2…xn, Y=y1y2…ym を二つの異なる文字列とするとき、
    Y が X の接頭辞であるか、j を xj≠yj であるような最小の整数として xj>yj である場合、
    そしてその場合に限って X は Y より辞書順で大きいといいます。

    制約
    1 ≤ |s| ≤ 5000
    s は英小文字からなる
    1 ≤ K ≤ 5
    s は異なる substring を K 個以上持つ

    部分点
    |s| ≤ 50 を満たすデータセットに正解した場合は、部分点として 200 点が与えられる。

    入力
    入力は以下の形式で標準入力から与えられる。
    s
    K

    出力
    辞書順で K 番目に小さい s の substring を出力せよ。
     */

    static String s;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        K = sc.nextInt();

        System.out.println( solve() );
    }

    static String solve() {

        // 各桁からの部分文字列をK個作ってリストに入れて
        // ソートした結果の5番目を取り出す

        List<String> substrings = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = i+1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (!substrings.contains(sub)) {
                    substrings.add(sub);
                }

                count++;
                if (count == K) {
                    break;
                }
            }
        }

        Collections.sort(substrings);
        return substrings.get(K - 1);
    }
}
