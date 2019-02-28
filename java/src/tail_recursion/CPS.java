package tail_recursion;

import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;

public class CPS {

    /**
     * CPS変換の例
     */

    /**
     * 末尾再帰呼び出しになっていないsum関数
     */
    long sum(long n) {
        if (n == 0) { return 0; }

        // 再帰呼び出しをしてからnを足している！(=末尾再帰呼び出しになってない)
        return n + sum(n-1);


        // 呼び出し方はこんな感じ
        // System.out.println(sum(100));
    }

    /**
     * CPS変換
     *
     * 1. 引数に継続を追加する
     * 2. 0を返している箇所を継続に渡すようにする
     * 3. sum2関数の実行結果を変数で受け取る
     * 4. nとsum2関数の結果の足し算を関数化する
     * 5. sum2関数に継続を渡す
     */
    void sum2(int n, IntConsumer k) {
        if (n == 0) {
            k.accept(0);
        } else {
            sum2(n-1, ret -> k.accept(n + ret));
        }

        // こんな感じで呼び出す
        // sum(100, System.out::println);
    }
    /**
     * ↑これの戻り値をvoidじゃなくてintにする
     *
     * 1. 戻り値をintにして
     * 2. returnをつけて
     * 3. IntConsumerをIntUnaryOperatorにして
     * 4. acceptをapplyAsIntにする
     */
    int sum3(int n, IntUnaryOperator k) {
        if (n == 0) {
            return k.applyAsInt(0);
        } else {
            return sum3(n-1, ret -> k.applyAsInt(n + ret));
        }

        // この関数をどうやって呼び出すか？もともとは↓
        // sum(100, System.out::println);
        // という感じで呼び出していた。(System.out::printlnがIntConsumer)
        // つまり、
        // ・計算結果(int)を受け取って消費していた(void)ところを
        // ・計算結果(int)を受け取って返す(int)ようにすればいい
        // => 恒等関数を渡して呼び出せばいい
        // int ret = sum3(100, IntUnaryOperator.identity());
        // System.out.println(ret);
    }

    /**
     * 再帰呼び出しをCPS変換するポイント
     * ・returnしている箇所を継続の実行に変える
     * ・再帰呼び出しから後の処理を継続として渡すように変える
     */

}
