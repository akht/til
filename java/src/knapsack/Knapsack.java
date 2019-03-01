package knapsack;

/**
 *
 * ナップサック問題を解く
 *
 * 深さ優先探索を再帰を使って行う
 * 全探索なのでMAX_Nが25くらいまでしか計算できない
 */
public class Knapsack {
    // 品物の個数の最大値
    static int MAX_N = 25;
    // 品物の個数
    static int n;
    // ナップサックの容量
    static int W;
    // i番目の品物の重さをw[i],
    // i番目の品物の価値をv[i]で表す
    static int[] w = new int[MAX_N];
    static int[] v = new int[MAX_N];

    // i番目以降の品物から重さの和がj以下になるように選んだ時の、
    // 取りうる価値の総和の最大値を返す関数
    // i : 品物の番号
    // j : 品物iを重さjのナップサックに入れた時の価値の最大値
    //
    // rec_dp(0, W)を考える。
    // 品物0を入れるとすると、次の品物(つまり品物1)以降の価値の最大値は、
    // 「品物0が使えず、かつナップサックの容量がw[0]だけ減った時の価値の最大値」
    // と考えることができる。
    // すると、品物0を入れた時の価値の最大値はv[0] + rec_dp(1, W-w[0])と表せる。
    // 同様に、品物0を入れないとすると、ナップサックの容量は変化しないので
    // 価値の最大値はrec(1, W)と表せる。
    // このように品物0を入れた時と入れない時を考えると、rec_dp(0, W)全体の最大値は
    // その２つの大きい方になる。
    //
    // iがn(品物の数)以上の時、rec_dp(i, j)は明らかに0になる
    // (使える品物が何もない)ので、再帰は無限ループにならず必ず終了する。
    public static int rec(int i, int j) {
        int result;
        if (i == n) {
            // 品物が残っていない時は、価値の和の最大値は0
            result = 0;
        } else if (j < w[i]) {
            // 残りの容量が足りず品物iを入れられないので、入れないパターンだけを調べる
            // i+1以降の品物のみを使った時の最大値をそのままこの場合の最大値にする
            result = rec(i + 1, j);
        } else {
            // 品物iを入れるか入れないか選べるので、両方試して価値の和が大きい方を選ぶ
            result = Math.max(
                    rec(i + 1, j),
                    rec(i + 1, j - w[i]) + v[i]
            );
        }
        return result;
    }

    public static void main(String[] args) {
        w[0] = 11;
        v[0] = 15;
        w[1] = 2;
        v[1] = 3;
        w[2] = 3;
        v[2] = 1;
        w[3] = 4;
        v[3] = 4;
        w[4] = 1;
        v[4] = 2;
        w[5] = 5;
        v[5] = 8;

        n = 6;
        W = 15;

        System.out.println(rec(0, W));
    }

}