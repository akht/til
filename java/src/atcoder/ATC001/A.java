package atcoder.ATC001;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class A {

    /*
    問題文
    高橋君の住む街は長方形の形をしており、格子状の区画に区切られています。
    長方形の各辺は東西及び南北に並行です。
    各区画は道または塀のどちらかであり、高橋君は道を東西南北に移動できますが斜めには移動できません。
    また、塀の区画は通ることができません。

    高橋君が、塀を壊したりすることなく道を通って魚屋にたどり着けるかどうか判定してください。
     */


    static int H;
    static int W;

    static char[][] matrix;
    static Point start;
    static Point goal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = Integer.parseInt(sc.next());
        W = Integer.parseInt(sc.next());

        // 街の地図を構築
        matrix = new char[H][W];
        for (int i = 0; i < H; i++) {
            char[] line = sc.next().toCharArray();
            for (int j = 0; j < line.length; j++) {
                if (line[j] == 's') {
                    // スタート地点
                    start = new Point(i,j );
                } else if (line[j] == 'g') {
                    // ゴール地点
                    goal = new Point(i, j);
                }
                matrix[i][j] = line[j];
            }
        }


//        printMatrix(matrix);
//        System.out.println("start = " + start);
//        System.out.println("start = " + goal);

        solve();
    }


    static void solve() {

        // このdx,dyで上下左右(分岐先)を表す(こうしておくとforループで回せて便利)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        // 訪問済みかどうかを覚えておくマトリックス
        boolean[][] visited = new boolean[H][W];

        // スタックを作成
        // スタート地点を先頭に追加し、探索済みとする
        Deque<Point> stack = new ArrayDeque<>();
        stack.offerFirst(start);
        visited[start.x][start.y] = true;


        // ここからスタックを用いた深さ優先探索
        while (!stack.isEmpty()) {
            // 先頭の座標を取得
            Point point = stack.pollFirst();

            // 上下左右を調べる
            for (int i = 0; i < 4; i++) {
                int x = point.x + dx[i];
                int y = point.y + dy[i];

                if (0 <= x && x < H && 0 <= y && y < W) {
                    // 進んだ先が地図の範囲内にあるとき
                    // 進んだ先が塀ではなく、未訪問だったらスタックの先頭に追加する
                    if (matrix[x][y] != '#' && !visited[x][y]) {
                        stack.offerFirst(new Point(x, y));
                        // 追加した座標を探索済みにする
                        visited[x][y] = true;
                    }
                }
            }
        }

        // ゴール地点が探索済みなら到達可能
        System.out.println(visited[goal.x][goal.y] ? "Yes" : "No");
    }


    static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }

}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}