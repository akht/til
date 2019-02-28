package sort;

import java.util.*;

public class MergeSort {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList(Arrays.asList(4,8,5,7,1,9,2,6,3,0));
        mergeSort(list, 0, list.size());
        list.forEach(System.out::println);
    }

    // マージソート O(NlogN)
    // 真ん中で分割して再帰的にソートし、最後にマージする
    // バッファを作るための追加メモリが必要なため、内部ソートではない
    static void mergeSort(List<Integer> list, int left, int right) {

        // 再帰の停止条件
        // 要素が１つになったら終了
        if (right - left == 1) {
            return;
        }

        // 分割する位置
        int mid = (left + right) / 2;

        mergeSort(list, left, mid);     // 左半分をソート
        mergeSort(list, mid, right);    // 右半分をソート


        // 左右のソート結果を貯めておくバッファ(あとでマージに使用する)
        // 左半分は正順にバッファに追加していくが、右半分は逆順にバッファに追加していく。
        // そうすることで、先頭と末尾がそれぞれ左半分と右半分の最小の要素ということになるので
        // あとは毎回それらを比べて小さいほうから結果に入れていく
        Deque<Integer> buf = new ArrayDeque<>();

        // 左半分のソート結果を前から走査して、バッファの末尾に追加
        for (int i = left; i < mid; i++) {
            buf.offerLast(list.get(i));
        }
        // 右半分のソート結果を後ろから走査して、バッファの末尾に追加
        for (int i = right - 1; i >= mid; i--) {
            buf.offerLast(list.get(i));
        }


        // マージ処理
        // バッファの先頭が左半分のソート結果の最小値、
        // 末尾が右半分のソート結果の最小値になっているので、
        // 先頭と末尾を毎回比較して、小さいほうを結果に入れる
        for (int i = left; i < right; i++) {
            int lhs = buf.peekFirst();
            int rhs = buf.peekLast();

            if (lhs < rhs) {
                list.set(i, buf.pollFirst());
            } else {
                list.set(i, buf.pollLast());
            }
        }

    }
}
