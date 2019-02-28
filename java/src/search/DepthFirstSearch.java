package search;


import java.util.*;
import java.util.function.Function;

public class DepthFirstSearch {

    /**
     * //与えられた配列内のいくつかを足して解が偶数になる場合の最大値を返す
     */

    public static void main(String[] args) {
        dfs(0,0);
        System.out.println(max);


        dfs2();

    }


    static int max = 0;
//    static int[] array = {1,4,3,6,5,3,2,1};
    static int[] array = {1,4,3};

    // 深さ優先探索で解く(再帰)
    public static void dfs(int index, int sum) {
        if (index == array.length) {
            if (sum % 2 == 0) {
                max = Math.max(max, sum);
            }
            return;
        }

        dfs(index+1, sum);
        dfs(index+1, sum + array[index]);
    }


    // スタックを使った深さ優先探索
    public static void dfs2() {

        // 配列の長さ
        int len = array.length;

        // この問題では訪問済みかどうかを管理する必要はない
        // なぜなら、迷路(地図、マトリックス)とは違って木構造を作るので
        // 上から下に処理が流れていき、終端が決まっているから(配列の終わり)
        // （言い換えれば、特定のノードに到達するための経路は１つしかないため）
        // ２次元配列(迷路、地図)だと特定のノードに到達するための経路が複数あるため
        // それぞれの経路を通ってきた場合に、そこが訪問済みかどうかを管理しないといけない


        // スタックを用意
        Deque<Point> stack = new ArrayDeque<>();

        // 最初の要素を入れる
        // 配列の0番目から(足す|足さない)で分岐したいので、-1番目の要素(ルート要素)として0があるとする
        Point start = new Point(-1, 0);
        stack.offerFirst(start);


        int max = 0;
        while (!stack.isEmpty()) {
            Point point = stack.pollFirst();

            if (point.index == len - 1) {
                // 配列の最後まで到達(=最深部まで探索)したら、そこまでのaccが条件を満たすか調べる
                if (point.acc % 2 == 0) {
                    max = Math.max(max, point.acc);
                }
            }

            // 次の要素のインデックス
            int nextIndex = point.index + 1;
            if (nextIndex < len) {

                Point next1 = new Point(nextIndex, point.acc + array[nextIndex]);
                // 次の要素を足す分岐をスタックに積む
                stack.offerFirst(next1);

                Point next2 = new Point(nextIndex, point.acc + 0);
                // 次の要素を足さない分岐をスタックに積む
                stack.offerFirst(next2);
            }

        }

        System.out.println(max);
    }



}

class Point {
    int index;  // 配列のインデックス
    int acc;    // その時点での合計
    Point(int index, int acc) {
        this.index = index;
        this.acc = acc;
    }

    @Override
    public String toString() {
        return "(" + index + "," + acc + ")";
    }
}
