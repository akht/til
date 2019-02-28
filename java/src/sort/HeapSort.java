package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort {

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>(Arrays.asList(19,12,15,10,7,6,1,3,7,5,3,2));
//        heapSort(list).forEach(System.out::println);


        List<Integer> list = new ArrayList<>(Arrays.asList(19,12,15,10,7,6,1,3,7,5,3,2));
        heapSort2(list);
        list.forEach(System.out::println);
    }

    // 内部ソートではない(ヒープを構築するために余分なメモリを使っている)
    static List<Integer> heapSort(List<Integer> list) {

        // ヒープを作る
        Heap heap = Heap.generate(list);

        List<Integer> sorted = new ArrayList<>();
        int i = 0;
        while (!heap.isEmpty()) {
            // ヒープを先頭からpopしていく(popするたびにヒープが再構築される)

            sorted.add(0, heap.pop());

        }

        return sorted;
    }


    // in-placeなヒープソート
    static void heapSort2(List<Integer> list) {

        // 対象のサイズ
        int size = list.size();

        int i;

        // ヒープを構築
        // 二分木なので親ノードのインデックスは(n-1)/2となる
        for (i = (size-1)/2; i >= 0; i--) {
            heapify(list, i, size-1);
        }

        // ヒープソート実行
        // 値を昇順に並べる
        // 先頭要素（最大値）を配列の最後に移動させて
        // 最後の要素を無視してヒープを構築するのを繰り返すと
        // 小さい順に並ぶ
        for (i = size-1; i > 0; i--) {
            swap(list, 0, i);
            heapify(list, 0, i-1);
        }
    }


    /**
     * heapを構築する
     *
     * 親ノードは子ノードより大きいか等しくなる
     *
     * @param array ソートしたい配列
     * @param root 親ノードとなる要素のインデックス
     * @param bottom 最後の要素のインデックス
     */
    static void heapify(List<Integer> list, int root, int bottom) {

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

