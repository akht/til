package atcoder.ABC007;
// http://keita-matsushita.hatenablog.com/entry/2016/11/08/193052

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class C {
    static int R;
    static int C;
    static int sy;
    static int sx;
    static int gy;
    static int gx;
    static List<List<String>> maze = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        R = Integer.valueOf(line.split(" ")[0]);
        C = Integer.valueOf(line.split(" ")[1]);

        line = sc.nextLine();
        sy = Integer.valueOf(line.split(" ")[0]) - 1;
        sx = Integer.valueOf(line.split(" ")[1]) - 1;

        line = sc.nextLine();
        gy = Integer.valueOf(line.split(" ")[0]) - 1;
        gx = Integer.valueOf(line.split(" ")[1]) - 1;

        for (int i = 1; i <= R; i++) {
            List<String> l = new ArrayList(Arrays.asList(sc.nextLine().split("")));
            maze.add(l);
        }

        System.out.println(dfs());
    }

    static int[][] visited;

    // 幅優先探索で最短経路での距離を求める
    public static int dfs() {
        // dfsに使うキュー
        Deque<Point> queue = new ArrayDeque<>();
        Point start = new Point(sy, sx);
        start.dist = 0;
        queue.push(start);

        // 訪問管理の二次元配列
        visited = new int[R][C];
        visited[start.y][start.x] = 1;

        while (!queue.isEmpty()) {
            // 現在の場所
            Point now = queue.poll();

            List<Point> children = getChildren(now);
            for (Point child : children) {
                child.dist = now.dist + 1;

                if (isGoal(child)) {
                    return child.dist;
                }
                markVisited(child);
                queue.offerLast(child);
            }

        }

        return -1;
    }

    public static boolean isGoal(Point p) {
        return p.y == gy && p.x == gx;
    }

    public static void markVisited(Point p) {
        visited[p.y][p.x] = 1;
    }

    public static boolean isVisited(Point p) {
        return visited[p.y][p.x] == 1;
    }


    static int[] moveY = {1, 0, -1,  0};
    static int[] moveX = {0, 1,  0, -1};

    // 上下左右に隣接するマスを返す
    public static List<Point> getChildren(Point parent) {
       List<Point> children = new ArrayList<>();

        // 上下左右のマスを加える
        for (int i = 0; i < 4; i++) {
            int y = parent.y + moveY[i];
            int x = parent.x + moveX[i];
            if (0 <= y && y < R && 0 <= x && x < C) {
                if (!maze.get(y).get(x).equals(".")) {
                    continue;
                }

                Point child = new Point(y, x);
                child.dist = parent.dist + 1;   // 親のマスに隣接するので距離は親+1

                if (isVisited(child)) {
                    continue;
                }

                children.add(child);
            }
        }

        return children;
    }


    public static void printMatrix(List<List<String>> matrix) {
        matrix.stream()
                .map(line -> line.stream().collect(Collectors.joining(",")))
                .forEach(System.out::println);
    }
}

class Point {
    int y;
    int x;
    int dist;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
        this.dist = 0;
    }
}