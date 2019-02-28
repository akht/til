package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dp2 {

    /*
    問題２：ナップサック問題
    https://qiita.com/drken/items/a5e6fe22863b7992efdb

    n個の品物があり、ii 番目の品物のそれぞれ重さと価値が
    weight[i],value[i]となっている (i=0,1,...,n−1i=0,1,...,n−1)。
    これらの品物から重さの総和がWを超えないように選んだときの、価値の総和の最大値を求めよ。
     */


    static int n = 6;
    static int W = 8;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {

        // {重さ、価値}
        list.add(new int[]{2,3});
        list.add(new int[]{1,2});
        list.add(new int[]{3,6});
        list.add(new int[]{2,1});
        list.add(new int[]{1,3});
        list.add(new int[]{5,85});


        dp();
    }


    static void dp() {
        // 基本的には重さに対する価値の比率が大きいものを選んでいきたいが、
        // 単純にweight/valueが大きい順にソートして、重さがWを超えないギリギリまで詰める
        // という方針では最適解にはならない。

        // DPテーブルの設計を考える。
        // 単純に dp[i+1] = i番目までの品物の中から重さがWを超えないように選んだときの、価値の最大値
        // としてしまうと詰まってしまう。
        // dp[i+1]を考える時に、dp[i]に対して品物を加えるか否かを考えるわけだが、
        // 加えた時に重さがWを超えてしまうのかどうかがわからない。
        // dp[i]に対して、「いま、重さがどうなっているか」という情報が必要になる。
        // そこでDPテーブルを以下のように定義する。
        // dp[i+1][w] = i番目までの品物の中から重さがwを超えないように選んだときの、価値の総和の最大値
        // そしてdp[i][w]の値が求まっていることを前提にしてdp[i+1][w]の値を考える。
        // dp[i+1][w]の値を求めるには、以下のうちの大きい方をとる。
        // ・品物を選ぶ場合(weight[i] <= wの場合のみ)
        //      dp[i+1][w] = dp[i][w - weight[i]] + value[i]
        //      (w - weight[i]というのは、足した品物の重さをナップサックの容量から引くため)
        //      (ex. A,B,Cとw[kg]入るリュックがあるとき、Aを選んだ場合、リュックにAの価値を足し、Aの重さを引いた残りがリュックに入る)
        // ・品物を選ばない場合
        //      dp[i+1][w] = dp[i][w]
        // まとめると、
        // <DP漸化式>
        // dp[i+1][w] = {
        //               max(dp[i][w - weight[i]] + value[i], dp[i][w]) (w >= weight[i])
        //               dp[i][w] (w < weight[i])
        //              }
        // 遷移するための初期値は
        // <DP初期条件>
        // dp[0][w] = 0 (w=0,1,2,...,W)

        int[][] dp = new int[100][100];

        for (int i = 0; i < n; i++) {
            for (int w = 0; w <= W; w++) {
                if (w >= list.get(i)[0]) {
                    dp[i+1][w] = Math.max(
                                    dp[i][w - list.get(i)[0]] + list.get(i)[1],
                                    dp[i][w]
                                );
                } else {
                    dp[i+1][w] = dp[i][w];
                }
            }
        }

        System.out.println(dp[n][W]);
    }
}
