package tail_recursion;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntConsumer;

public class Main {


    /**
     * 普通にフィボナッチ数列の第n項を求める関数
     *
     * ※n=100くらいで返ってこない
     */
    int fib(int n) {
        if (n == 0) { return 0; }
        if (n == 1) { return 1; }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * ↑こいつをメモ化する
     *
     * ※Integerだと桁が溢れるのでBigIntegerを使う
     * n=100くらいだと返って来るが、10000だとスタックオーバーフローになる
     */
    static Map<BigInteger, BigInteger> values = new HashMap<>();
    static BigInteger zero = BigInteger.ZERO;
    static BigInteger one = BigInteger.ONE;
    static BigInteger two = one.add(one);

    static BigInteger fib_memo(BigInteger n) {
        if (n.compareTo(zero) == 0) { return zero; }
        if (n.compareTo(one) == 0) { return one; }

        BigInteger m = values.get(n);
        if (m != null) { return m; }

        m = fib_memo(n.subtract(one)).add(fib_memo(n.subtract(two)));
        values.put(n, m);
        return m;
    }

    /**
     * ここまで、普通の再帰をメモ化して書いたが
     * それでもスタックオーバーフローは起きてしまう。
     * これをスタックを消費しない形の再帰に書き換えるのが今回の主題。
     *
     * 1.末尾再帰呼び出しに変形して
     * 2.末尾再帰呼び出しを最適化
     *
     */


    /* まずは簡単な例で考える */

    /**
     * 1からnまでを足す再帰関数
     */
    long sum(long n) {
        if (n == 0) { return 0; }
        return n + sum(n - 1);  // n=10000くらいでスタックオーバーフロー
    }

    /**
     * ↑を末尾再帰呼び出しに変形する
     */
    long sum2(long n) {
        return sum2(n, 0);
    }
    long sum2(long n, long m) {
        if (n == 0) { return m; }

        // ↓再帰呼び出しでスタック消費
        return sum2(n - 1, n + m);
    }

    /**
     * ↑これだとまだスタックオーバーフローになるので
     * この末尾再帰呼び出しを最適化する。
     *
     * 末尾再帰呼び出し用のクラスTailRecを作成する
     */



    /**
     * TailRecクラスを使ってsum2関数の末尾再帰呼び出しを最適化する
     *
     * 戻り値をTailRecにして、
     * returnしているところをTailRec.callとTailRec.doneで包んだだけ
     */
    static long sum3(long n) {
        System.out.printf("return sum3(%s, 0).get()\n", n);
        return sum3(n, 0).get();
    }
    static TailRec<Long> sum3(long n, long m) {

        // 再帰の終了部分をTailRec.doneでラップ
        if (n == 0) {
            System.out.printf("return TailRec.done(%s)\n", m);
            return TailRec.done(m);
        }

        // ↓再帰呼び出し部分をTailRec.callでラップして返し、
        // ↓実行は呼び出し元に任せることでスタックを消費しなくなった。
        // ↓※再帰呼び出しをTailRecで表現して呼び出し元に返す。
        // ↓ここではメソッド実行はしていない
        System.out.printf("return TailRec.call(() -> sum3(%d, %d))\n", n-1, n+m);
        return TailRec.call(() -> sum3(n-1, n+m));
    }
    /**
     * ↑処理の流れのイメージ
     * ・sum3を実行してTailRec.callでTailRecを返す
     * ・Stream.iterateでTailRec.next.getを実行する
     * ・これを再帰呼び出しのぶんだけ繰り返す
     * ・再帰呼び出しが終了したらTailRec.doneでTailRecを返す
     * ・TailRecから値を取り出して処理終了
     *
     * これが再帰呼び出しではなくループで実現されている
     */


    /**
     * いよいよTailRecを使ってfib_memo関数をループ化する、が、
     * そもそもfib_memoは再帰呼び出しが２つ存在して末尾再帰呼び出しになっていない
     * （m = fib_memo(n.substact(one)).add(fib_memo(n.subtract(two)))の部分）
     *
     * ので、まずは末尾再帰呼び出しに変形する。
     * CPS変換というものを行う。
     */

    /**
     * CPS変換とは
     * ・継続渡しスタイルに変換すること
     * ・継続とは、ある時点における残りの処理
     * ・関数を「計算結果を返す」から「計算結果を継続に渡す」よう変換する
     */



    /**
     * CPS変換の例
     *
     * ↓下の一連の関数たちは計算結果を返す通常の形式(int値を戻り値として返している)
     */
    int increment(int n) {
        return n + 1;
    }
    int twice(int n) {
        return n * 2;
    }
    void run() {
        System.out.println(twice(increment(1)));
    }
    /**
     * ↑これを呼び出し元の後続処理を継続として受け取り、
     * 計算結果を渡すようにすると・・・
     *
     * ↓継続渡しスタイル
     * ※IntConsumerはint->voidな関数型インターフェース
     */
    void increment(int n, IntConsumer k) {
        int ret = n + 1;
        k.accept(ret);
    }
    void twice(int n, IntConsumer k) {
        int ret = n * 2;
        k.accept(ret);
    }
    void run2() {
        increment(1, x -> twice(x, y -> System.out.println(y)));
    }
    /**
     * 継続渡しスタイルにすると、
     * ・継続は「ある時点における残りの処理」なので自然と末尾で呼び出すことになる
     * ・つまり、再帰呼び出しを行う関数を継続渡しスタイルで書けば
     *   末尾再帰呼び出しを自然と書くことができる
     */


    /**
     * CPS変換の例２
     *
     * => CPS.javaに書いた
     *
     */


    /**
     * CPS変換を使ってfib_memo関数を末尾再帰呼び出しにする
     *
     * 1. まず引数に継続を追加する
     * 2. 値を返している箇所を継続に渡すようにする
     * 3. fib_cps関数の実行結果を変数で受け取る
     * 4. xとyの足し算(とメモ化)を関数化する
     * 5. fib_cps関数に継続を渡す
     * 6. ひとつめのfib_cps関数呼び出しの後続処理を関数化する
     * 7. ひとつめのfib_cps関数に継続を渡す
     *
     * TailRecを使って末尾再帰呼び出しを最適化する
     * 1. 戻り値をTailRec<BigInteger>にする
     * 2. returnしている箇所をTailRec.callで包む
     * 3. UnaryOperator<BigInteger>をFunction<BigInteger, TailRec<BigInteger>>にする
     *
     */
    static TailRec<BigInteger> fib_cps(BigInteger n, Function<BigInteger, TailRec<BigInteger>> k) {

        if (n.compareTo(zero) == 0) { return TailRec.call(() -> k.apply(zero)); }
        if (n.compareTo(one) == 0) { return TailRec.call(() -> k.apply(one)); }

        BigInteger m = values.get(n);
        if (m != null) {
            return TailRec.call(() -> k.apply(m));
        }

        return TailRec.call(() -> fib_cps(n.subtract(one), x -> {
            return TailRec.call(() -> fib_cps(n.subtract(two), y -> {
                BigInteger z = x.add(y);
                values.put(n, z);
                return TailRec.call(() -> k.apply(z));
            }));
        }));
    }



    public static void main(String[] args) {
        // fib_cps関数の呼び出し方
        BigInteger n = new BigInteger("10000");
        TailRec<BigInteger> tailRec = fib_cps(n, TailRec::done);
        BigInteger ret = tailRec.get();
        System.out.println(ret);

    }










}
