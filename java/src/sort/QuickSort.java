package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println("クイックソート");
        List<Integer> list = new ArrayList(Arrays.asList(8,1,5,7,4,9,2,6,3,0));

        int[] array = new int[]{8,1,5,7,4,9,2,6,3,0};
//        int[] array = new int[]{16,5,3,2,21,10,4,6,7,9,18};

        quickSort3(array, 0, array.length - 1);
//        hoge(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));


    }

    // クイックソート O(NlogN)
    // ピボットを選択し(今回はとりあえず真ん中の値)、
    // ピボットより前は小さい数のみ、ピボットより後は大きい数のみ、となるように要素を移動する
    // その後、対象をピボットで分割して再帰的にソートする
    static void quickSort(List<Integer> list, int left, int right) {

        // 再帰の停止条件
        if (right - left <= 1) {
            return;
        }

        // ピボットのインデックス(とりあえず真ん中とする)
        int pivotIndex = (left + right) / 2;
        int pivotValue = list.get(pivotIndex);


        // ピボットと最後の要素を交換する
        swap(list, pivotIndex, right - 1);

        // ピボットより小さいをスワップするためのインデックス
        int indexForSwap = left;
        for (int j = indexForSwap; j < right - 1; j++) {
            // 頭からピボットの直前まで走査して、ピボットより小さい値を探す
            // 小さい値が見つかったらindexForSwap番目と交換して、indexforSwapをひとつ進める
            if (list.get(j) < pivotValue) {
                swap(list, indexForSwap, j);
                indexForSwap++;
            }
        }
        // ピボットより小さい値を移動し終わったら、最後尾にあるピボットをindexForSwapの位置に戻す
        swap(list, indexForSwap, right - 1);


        quickSort(list, left, indexForSwap);            // ピボットから左側をソート
        quickSort(list, indexForSwap + 1, right);   // ピボットより右側をソート
    }

    // リストのa番目とb番目の値を交換する
    static void swap(List<Integer> list, int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


    static void quickSort2(List<Integer> list, int left, int right) {
        // 再帰の停止条件
        if (right - left <= 1) {
            return;
        }

        // ピボットのインデックス(とりあえず真ん中とする)
        int pivotIndex = (left + right) / 2;
        int pivotValue = list.get(pivotIndex);


        int l = left;
        int r = right;

        while (l <= r) {

            while (l <= right && list.get(l) < pivotValue) {
                l++;
            }

            while (r >= left && list.get(r) >= pivotValue) {
                r--;
            }

            if (l > r) {
                break;
            }

            swap(list, l, r);
            l++;
            r--;
        }

        quickSort2(list, left, l - 1);     // ピボットから左側をソート
        quickSort2(list, l, right);             // ピボットより右側をソート
    }



    static int partition(int[] array, int left, int right) {
        int pivotIndex = (left + right) / 2;
        int pivotValue = array[pivotIndex];

        int lp = left;
        int rp = right;

        while (true) {
            while (array[lp] < pivotValue) {
                lp++;
            }

            while (array[rp] > pivotValue) {
                rp--;
            }

            if (lp > rp) {
                return lp;
            }

            swap(array, lp, rp);
            lp++;
            rp--;
        }
    }



    static void quickSort3(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partition(array, left, right);

        quickSort3(array, left, pivot-1);
        quickSort3(array, pivot, right);
    }


    public static int[] hoge(int[] arr, int left, int right) {
        if(left<=right) {
            int p = arr[(left+right)/2];
            int l = left;
            int r = right;
            while(l <= r) {
                while(arr[l] < p) l++;
                while(arr[r] > p) r--;

                if(l<=r) {
                    int tmp = arr[l];
                    arr[l] = arr[r];
                    arr[r] = tmp;
                    l++;
                    r--;
                }
            }

            hoge(arr, left, r);
            hoge(arr, l, right);
        }
        return arr;
    }

}
