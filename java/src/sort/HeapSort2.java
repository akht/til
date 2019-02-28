package sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort2 {

    public static void main(String[] args) {


//        int[] array = {3,7,15,2,10,9,1};
        List<Integer> list = new ArrayList<>(Arrays.asList(8,14,28,1, 30, 7, 6, 5, 2, 13, 7, 6, 5, 5, 9));
//        List<Integer> list = new ArrayList<>(Arrays.asList(3,7,15,2,10,9,1));
        heapSort(list);
        list.forEach(System.out::println);
    }

    // in-placeなヒープソート(内部ソート)
    static void heapSort(List<Integer> list) {

        // 対象のサイズ
        int size = list.size();

        // list全体をヒープにする
        for (int i = (size-1)/2; i >= 0; i--) {
//            heapify(list, i, size);
            heapify2(list, i, size);
        }

        // ヒープからひとつずつ最大値をpopする
        for (int i = size-1; i > 0; i--) {
            swap(list, 0, i);       // ヒープの最大値を左詰め
//            heapify(list, 0, i);    // ヒープサイズはiにする
            heapify2(list, 0, i);
        }
    }

    // listのうち、size番目までをヒープとして、i番目のノードについて下と比べて逆転していたら解消する
    static void heapify(List<Integer> list, int i, int size) {

        // 親の値
        int parent_value = list.get(i);

        // 左側の子のインデックス
        int c_lhs = i * 2 + 1;
        // 右側の子のインデックス
        int c_rhs = c_lhs + 1;

        // 左側の子が存在しなければ終了(左がなければ右もないので)
        if (c_lhs >= size) {
            return;
        }


        // 比較対象の子供の値(とりあえず左側としておく)
        int child_value = list.get(c_lhs);
        int child_index = c_lhs;


        // 右側の子が存在していれば、左と右の子同士を比べて大きいほうを採用
        if (c_rhs < size) {
            if (list.get(c_lhs) < list.get(c_rhs)) {
                // もし右側の子のほうが大きければ子供の値は右側とする
                child_value = list.get(c_rhs);
                child_index = c_rhs;
            }
        }

        // 大きいほうの子と親を比べて、子のほうが大きければswapして解消する
        if (parent_value <= child_value) {
            swap(list, i, child_index);
        }

        // 再帰的に繰り返す
        heapify(list, child_index, size);
    }


    static void heapify2(List<Integer> list, int root, int bottom) {

        // 子ノードのインデックス
        int child = 2 * root + 1;

        // 親ノードの値
        int temp = list.get(root);

        while (child <= bottom) {
            if (child < bottom && list.get(child+1) > list.get(child)) {
                // 二分木のふたつの子ノードから値が大きいほうの子ノードを選択する
                child = child+1;
            }
            if (temp > list.get(child)) {
                // 親ノードの値が子ノードの値より大きい場合はなにもしない
                break;
            } else {
                // 親が子より小さいか等しい場合は、親と子を入れ替える
                swap(list, (child-1)/2, child);
                // 子ノードのインデックスを進める
                child = 2 * child + 1;
            }
        }
        // 親ノードとなる要素に値を入れる
        list.set((child-1)/2, temp);

    }




    static void swap(List<Integer> list, int i1, int i2) {
        int temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }
}

