package sort;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private List<Integer> list;

    private Heap(List<Integer> source) {
        this.list = new ArrayList<>();

        for (int n : source) {
            push(n);
        }
    }

    public static Heap generate(List<Integer> source) {
        return new Heap(source);
    }

    /**
     * ヒープのサイズを返す
     */
    public int size() {
        return list.size();
    }


    /**
     * ヒープが空かどうか
     * true:空
     * false:空ではない
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }


    /**
     * ヒープに値を追加する
     *
     * @param value
     */
    public void push(int value) {

        // 最後尾に追加
        list.add(value);

        // 追加されたノード番号
        int i = list.size()-1;

        while (i > 0) {
            // 親のノード番号
            int p = (i - 1) / 2;

            if (list.get(p) >= value) {
                // 親子関係が逆転していなかったら終わり
                break;
            }

            // 親と自分をswap
            swap(p, i);
            // 自分は親の位置に行く
            i = p;
        }
        // 追加したい値は最終的にこの位置に決定する
        list.set(i, value);
    }

    /**
     * ヒープの最大値を返す（削除しない）
     * @return
     */
    public int top() {
        return list.get(0);
    }


    /**
     * ヒープから最大値を取り出す
     *
     * @return
     */
    public int pop() {

        // 最大値(=返り値)
        int max = top();

        // とりあずルートノードに持ってくる値(最後尾を採用)
        int selectedNode = list.get(list.size()-1);
        list.remove(list.size()-1);

        // ルートノードから降ろしていく
        int i = 0;
        while (i * 2 + 1 < size()) {
            // 左側の子が配列のサイズを超えるまで
            // (= 左側の子が配列サイズを超えているということは、そのノードには子が存在しないこということになる)

            // 左右の子ノードの値を比較して大きいほうをmin_childとする
            int lhs_child = i * 2 + 1;  // 左側の子
            int rhs_child = i * 2 + 2;  // 右側の子
            int min_child = lhs_child;  // とりあえず左側が大きいと仮定しておく(右側の子が存在しないこともあるため)
            if (rhs_child < size()) {
                // 右側の子のインデックスが配列サイズを超えていないとき
                // (=超えているということは、右側の子は存在しないということ)
                // (=その場合は左側の子が採用される)

                if (list.get(lhs_child) < list.get(rhs_child)) {
                    min_child = rhs_child;
                }

            }

            if (list.get(min_child) <= selectedNode) {
                // 逆転していなければ終了
                break;
            }

            // 自分のノードを子供の値にする
            list.set(i, list.get(min_child));
            // 自分はその子供の位置に行く
            i = min_child;
        }

        // 選んだノードは最終的にこの位置に決定
        if (!list.isEmpty()) {
            // 空なら最後の要素だったということなのでセット不要
            list.set(i ,selectedNode);
        }


        return max;
    }


    public void swap(int i1, int i2) {
        int temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2 ,temp);
    }


    public void print() {
        System.out.println(list.stream().map(i -> i.toString()).reduce((x,y) -> x+","+y).orElse(""));
    }
}

