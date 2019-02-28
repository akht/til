package sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class QuickSort2 {

    public static void main(String[] args) {

        int[] array = {11,8,2,12,9,4,13,7,3,15,6,10,5,14,1};

        quickSort(array, 0, array.length-1);

        System.out.println(Arrays.toString(array));
    }


    // クイックソート O(NlogN)
    // ピボットを選択し(今回はとりあえず先頭・中間・末尾の中間値)、
    // ピボットより前は小さい数のみ、ピボットより後は大きい数のみ、となるように要素を移動する
    // その後、対象をピボットで分割して再帰的にソートする
    static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;

            int pivotValue = med3(array[i], array[i + (j - i) / 2], array[j]);

            while (true) {
                while (array[i] < pivotValue) {
                    i++;
                }
                while (pivotValue < array[j]) {
                    j--;
                }
                if (i >= j) {
                    break;
                }
                swap(array, i, j);
                i++;
                j--;
            }

            quickSort(array, left, i - 1);
            quickSort(array, j + 1, right);
        }
    }

    // x, y, zの中間値を返す
    static int med3(int x, int y, int z) {
        if (x < y) {
            if (y < z) {
                return y;
            } else if (z < x) {
                return x;
            } else {
                return z;
            }
        } else {
            if (z < y) {
                return y;
            } else if (x < z) {
                return x;
            } else {
                return z;
            }
        }
    }

    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
