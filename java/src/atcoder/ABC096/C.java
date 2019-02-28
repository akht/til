package atcoder.ABC096;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    /*
    問題文
    H 行 W 列のマス目で表されるキャンバスがあります. 上から i 番目, 左から j 番目のマスを (i,j) と表します.
    最初, すべてのマス目は白色です. square1001 君は, 黒い絵の具を使って絵を描きたいと思いました. 具体的には, square1001 君の目標は, si,j= # のときマス (i,j) を黒色, si,j= . のときマス (i,j) を白色にすることです.
    しかし, 彼は絵を描くことが得意ではないので, 何回か (0 回でもよい)「上下左右に隣接する 2 つのマスを選び, 両方黒く塗る」ことしかできません. ただし, すでに黒く塗られているマスを選ぶこともでき, この場合マスの色は黒のまま変わりません.
    square1001 君が目標を達成することができるか判定してください.

    制約
    H は 1 以上 50 以下の整数
    W は 1 以上 50 以下の整数
    すべての (i,j) (1≤i≤H,1≤j≤W) に対して, si,j は # または .
     */


    static int H;
    static int W;
    static String[][] matrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = Integer.parseInt(sc.next());
        W = Integer.parseInt(sc.next());

        // 初期化
        matrix = new String[H+2][W+2];
        for (String[] a : matrix) {
            Arrays.fill(a, "");
        }

        for (int i = 1; i <= H; i++) {
            String line = sc.next();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j+1] = String.valueOf(line.charAt(j));
            }
        }

//        printMatrix(matrix);

        solve();

    }

    // 上下左右のどこかに#があればOK
    // 完全に孤立したマスがひとつでもあるとNG
    static void solve() {
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                String p = matrix[i][j];
                if (p.equals("#")) {
                    // 上下左右
                    String around = matrix[i-1][j] + matrix[i+1][j] + matrix[i][j-1] + matrix[i][j+1];
                    if (around.indexOf("#") == -1) {
                        System.out.println("No");
                        return;
                    }
                }
            }
        }
        System.out.println("Yes");
    }

    static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
