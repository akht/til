package atcoder.ABC026;

import java.util.Scanner;

public class C {

    /*
    高橋君は、社員が N 人いる会社の社長です。高橋君の会社では、以下のように給料が決まっています。

    高橋君を含む社員の全員が、 1 から N までの社員番号を持っている。高橋君の社員番号はもちろん 1 である。
    高橋君以外の社員には、必ず自分より社員番号が小さい上司がただ一人存在する。自分が上司になっている社員のことを、直属の部下と呼ぶ。
    直属の部下がいない社員の給料は 1 であり、直属の部下がいる社員の給料は 、max(その社員の直属の部下の給料)+min(その社員の直属の部下の給料)+1 である。直属の部下が一人しかいない場合は、その部下の給料の 2 倍 + 1 が、その社員の給料となる。
    この時、高橋君の給料を求めなさい。
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] matrix = new int[n+2][n+2];

        matrix[1][0] = 1;
        matrix[1][1] = -1;
        matrix[1][2] = -1;
        for (int i = 2; i <= n; i++) {
            matrix[i][0] = i;   // 自分の社員番号
            matrix[i][1] = sc.nextInt(); // 上司の社員番号
            matrix[i][2] = -1; // 自分の給料
        }

        solve(matrix);
    }


    static void solve(int[][] matrix) {
//        printMatrix(matrix);
        int len = matrix.length;
        for (int i = len-1; i >= 1; i--) {
            int[] array = matrix[i];

            int myNo = array[0];
            int buka = 0;
            int min = 1;    // 部下の給料の最小
            int max = 0;    // 部下の給料の最大
            for (int j = 1; j < len; j++) {
                if (matrix[j][1] == myNo) {
                    if (buka == 0) {
                        // 最初の部下の値を設定
                        min = matrix[j][2];
                        max = matrix[j][2];
                    } else {
                        if (max < matrix[j][2]) {
                            max = matrix[j][2];
                        }
                        if (matrix[j][2] < min) {
                            min = matrix[j][2];
                        }
                    }
                    buka++;
                }
            }

            if (buka == 0) {
                // 部下がいなければ自分の給料は1
                array[2] = 1;
            } else {
                // 部下がいる
                array[2] = max + min + 1;
            }

        }

//        printMatrix(matrix);
        System.out.println(matrix[1][2]);
    }


    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
