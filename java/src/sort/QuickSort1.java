package sort;

import java.util.Arrays;

public class QuickSort1 {

    public static void main(String[] args) {
//        int[] array = {8,1,5,7,4,9,2,6,3,0};
//        int[] array = {16,5,3,2,21,10,4,6,7,9,18};
//        int[] array = {5,5,9,8,4,8,5,4,7,0};
        int[] array = {0,1,2,3,4,5,6,7,8,9};

        quickSort(array, 0, array.length);

        System.out.println(Arrays.toString(array));
    }

    // クイックソート O(NlogN)
    // ピボットを選択し(今回はとりあえず真ん中の値)、
    // ピボットより前は小さい数のみ、ピボットより後は大きい数のみ、となるように要素を移動する
    // その後、対象をピボットで分割して再帰的にソートする
    static void quickSort(int[] array, int left, int right) {

        // 再帰の停止条件
        if (right - left <= 1) {
            return;
        }

        // ピボットのインデックス(とりあえず真ん中とする)
        int pivotIndex = (left + right) / 2;
        int pivotValue = array[pivotIndex];


        // ピボットと最後の要素を交換する
        swap(array, pivotIndex, right - 1);

        // ピボットより小さいをスワップするためのインデックス
        int indexForSwap = left;
        for (int j = indexForSwap; j < right - 1; j++) {
            // 頭からピボットの直前まで走査して、ピボットより小さい値を探す
            // 小さい値が見つかったらindexForSwap番目と交換して、indexforSwapをひとつ進める
            if (array[j] < pivotValue) {
                swap(array, indexForSwap, j);
                indexForSwap++;
            }
        }
        // ピボットより小さい値を移動し終わったら、最後尾にあるピボットをindexForSwapの位置に戻す
        swap(array, indexForSwap, right - 1);


        quickSort(array, left, indexForSwap);            // ピボットから左側をソート
        quickSort(array, indexForSwap + 1, right);   // ピボットより右側をソート
    }

    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
