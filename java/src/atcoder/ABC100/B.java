package atcoder.ABC100;

import java.util.Scanner;

public class B {

    /*
    問題文
    今日は, 記念すべき AtCoder Beginner Contest 100 が開催される.
    そのため, 高橋君はりんごさんに, ある整数をプレゼントしようと思った.
    今日のコンテストは「AtCoder Beginner Contest 100」なので,
    りんごさんは 100 で ちょうど D 回割りきれる正の整数をプレゼントされると喜ぶ.

    さて, りんごさんがプレゼントされると喜ぶような整数のうち N 番目に小さいものを求めなさい.

    制約
    D は 0,1,2 のいずれかである
    N は 1 以上 100 以下の整数
     */

    static int D;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        D = sc.nextInt();
        N = sc.nextInt();


        if (N == 100) {
            System.out.println((int)((N+1) * Math.pow(100, D)));
        } else {
            System.out.println((int)(N * Math.pow(100, D)));
        }
    }
}
