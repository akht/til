package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        int[] array = {4, 8, 10, 2, 1, 6};

        insertionSort(array);

        Arrays.stream(array).forEach(System.out::println);


    }

    // 挿入ソート O(n^2) 遅い
    static void insertionSort(int[] array) {

        // ２つめの要素から順にみていく
        for (int i = 1; i < array.length; i++) {

            // 挿入したい値
            int target = array[i];

            // 挿入したい値と同じ位置から、先頭にむかってみていく
            // あとでjのインデックスをつかって挿入するのでfor文の外で宣言しておく
            int j = i;
            for (; j > 0; j--) {
                if (target < array[j - 1]) {
                    // 挿入したい値より大きければひとつ後ろにずらす
                    array[j] = array[j - 1];
                } else {
                    // 小さければ終わり
                    break;
                }
            }

            // 挿入するべき場所に値を入れる
            array[j] = target;
        }
    }

    // 挿入ソート
    private static void insertionSort2(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int target = array[i]; // 挿入したい値

            int j = i;
            for (; j > 0; j--) {
                if (target < array[j-1]) {
                    // 自分より大きい奴は１つ後ろにずらす
                    // = ずらすことで、挿入するための場所を作っている
                    array[j] = array[j-1];
                } else {
                    // target以下になったら止める
                    break;
                }
            }

            // ずらし終わってできた隙間に目的の値を挿入
            array[j] = target;
        }


    }
}
