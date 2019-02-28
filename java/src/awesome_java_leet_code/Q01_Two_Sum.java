package awesome_java_leet_code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q01_Two_Sum {
    public static void main(String[] args) {

        /**
         *
         * 数字が入った配列と、ターゲットの数字が与えられる。
         *
         * 配列のなかの数字同士を足して、ターゲットと同じ数になるペアのインデックスを返せ。
         *
         * ※必ず１つのペアが存在する
         *
         *
         */


        // nums = [2, 7, 11, 15], target=9
        // nums[0] + nums[1] = 7
        // return [0, 1]

        System.out.println(Arrays.toString( find(new int[]{2, 7, 11, 15, 1, 3, 24}, 26) ));

    }

    static int[] find(int[] array, int target) {

        // 答え
        int[] ret = new int[2];

        // キー：欲しい値、値：自分のインデックス
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < array.length; i++) {

            if (memo.containsKey(array[i])) {
                return new int[]{memo.get(array[i]), i};
            }

            int want = target - array[i];
            memo.put(want, i);
        }

        return null;
    }



    // 初歩的な実装
    // 配列を2回ループして探索する O(n^2)
    static int[] easyButSlow(int[] array, int target) {

        for (int i = 0; i < array.length; i++) {

            System.out.println("i="+i);

            for (int j = 0; j < array.length; j++) {

                System.out.println("j="+j);

                if (array[i] + array[j] == target) {

                    System.out.println("発見 i*j=" + i*j);
                    return new int[]{i, j};
                }

            }
        }

        return null;
    }

    // HashMapを使った実装 O(n)
    // 1. 配列の最初array[0]を読み取る => 2
    // 2. 2と足して9になるのは7なので、7が欲しい。なので7をハッシュマップのkeyにする
    //    7が見つかったときのために、自分(=2)のインデックス(i=0)をvalueとしてハッシュマップに保持する
    // 3. iを次にすすめる
    // 4. array[i]は7なので、7を欲しがっている値があるかどうかハッシュマップ内を検索する(配列・リストと違ってここが速い)
    // 5. 7を欲しがっているものが存在して、そしてそいつのインデックスは0である
    // 6. 2重ループすることなくO(n)で答えが得られる
    static int[] twoSum(int[] array, int target) {

        int len = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {

            System.out.println("i="+i + " array[i]="+array[i] + " target-array[i]="+(target-array[i]));
            map.forEach((k, v) -> System.out.println("key=" + k + " value="+v));

            if (map.containsKey(array[i])) {

                System.out.println("発見 i=" + i);

                return new int[]{map.get(array[i]), i};
            }

            System.out.println("map追加 key=" + "(" + target + "-" + array[i] + "), value="+i);
            map.put(target - array[i], i);
            map.forEach((k, v) -> System.out.println("更新後 key=" + k + " value="+v));
        }

        return null;
    }


}
