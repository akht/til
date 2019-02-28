package etc;

import java.util.ArrayList;

/**
 * 1,2,…,9の数をこの順序で、”+”、”-“、またはななにもせず結果が100となるあらゆる組合せを出力するプログラムを記述せよ。
 * 例えば、1 + 2 + 34 – 5 + 67 – 8 + 9 = 100となる
 */
public class Problem5 {
    private static int TARGET_SUM = 100;
    private static int[] VALUES = {1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {
        func(TARGET_SUM, VALUES[0], 1).forEach(System.out::println);
    }

    public static ArrayList func(int sum, int number, int index) {
        // f(12,3..9)のような場合に一番大きな桁をdigitに設定
        int digit = Math.abs(number % 10);

        // indexはVALUESを走査するためのインデックスなので、
        // indexがVALUESの長さを超えたら終了条件
        if (index >= VALUES.length) {
            // 例えばfunc(9,9,9)の時、
            // sumが9になるにはnumberの9を足せばいいだけなので
            // 結果のリストにnumberを格納して返す
            // そうでない時は、そのルートでは100にすることができなかった
            // ということなので空のリストを返す
            if (sum == number) {
                ArrayList result = new ArrayList();
                result.add(Integer.toString(digit));
                return result;
            } else {
                return new ArrayList();
            }
        }

        ArrayList branch1 = func(sum - number, VALUES[index], index + 1);
        ArrayList branch2 = func(sum - number, -VALUES[index], index + 1);

        int concatenatedNumber = number >= 0
                ? 10 * number + VALUES[index]
                : 10 * number - VALUES[index];
        ArrayList branch3 = func(sum, concatenatedNumber, index + 1);

        // 最終的に結果として返すリスト
        ArrayList results = new ArrayList();
        // 現在までの進捗を文字列に変換してresultsに加える
        results.addAll(add(digit, "+", branch1));
        results.addAll(add(digit, "-", branch2));
        results.addAll(add(digit,  "", branch3));

        return results;
    }

    public static ArrayList add(int digit, String sign, ArrayList branches) {
        for (int i = 0; i < branches.size(); i++) {
            branches.set(i, digit + sign + branches.get(i));
        }
        return branches;
    }

    /**
     * 考えかた
     */
    // 一気にやるのは難しいので、小さいピースに分割して考える(分割統治法)
    // まずf()というメソッドを考える。
    // func(1,2,..,9) = 100 は1-9の数字を使って100となるすべての組み合わせを求めるメソッド。
    // func(1,2,..,9) = 100は次の３つの式と同値。
    // 1) 1 + func(2..9) = 100
    // 2) 1 - func(2..9) = 100
    // 3)     func(12,3..9) = 100
    // このことから、さらに次の３つのことが導ける。
    // 1') func(2..9) = 99
    // 2') func(-2,3..,9) = 99
    // 3') func(12,3..9) = 100
    // さらにそれぞれに対して同じことを適用すると
    // 1'') 2 + func(3..9) = 99
    // 1'') 2 - func(3..9) = 99
    // 1'')     func(23,4..9) = 99
    // 2'') -2 + func(3..9) = 99
    // 2'') -2 - func(3..9) = 99
    // 2'')      func(-23,4..9) = 99
    // 3'') 12 + func(3..4) = 100
    // 3'') 12 - func(3..9) = 100
    // 3'')      func(123,4..9) = 100
    // このような操作をメソッドf()が等式の中からなくなるまで続ける。


}
