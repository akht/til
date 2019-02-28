package levenshtein;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {


        System.out.println( LD("apple", "play") );

        System.out.println( LD("あいうえお", "あうおいえ") );

        System.out.println( LD("this is a apple.", "this is an apple.") );

    }


    // ふたつの文字列のレーベンシュタイン距離を返す
    static int LD(String s1, String s2) {

        int row = s1.length() + 1;
        int col = s2.length() +1;

        // s1とs2のマトリクスを用意(空文字のぶんを+1)
        int[][] matrix = new int[row][col];

        // マトリクスの1行目・1列目を埋める
        IntStream.range(0, row).forEach(i -> matrix[i][0] = i);
        IntStream.range(0, col).forEach(i -> matrix[0][i] = i);

        // 1文字ずつの配列
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        // DP的に、ひとつまえの結果を利用して再帰的に求める
        // 左と上のマスの小さいほうに編集コストを加算していく
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int x;
                if (s1Arr[i-1] == s2Arr[j-1]) {
                    x = 0;
                } else {
                    x = 1;
                }

                matrix[i][j] = Math.min(Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1), matrix[i-1][j-1]+x);
            }
        }

        return matrix[row-1][col-1];
    }

}
