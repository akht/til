package atcoder.ABC101;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {

    static int N;
    static int K;
    static List<Integer> A = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int Ai = sc.nextInt();
            A.add(Ai);
        }

        solve();
    }

    static void solve() {
        // 最初1を含むK個を選んだあと、
        // 残りの(N-K)個から(K-1)個のグループがいくつできるか
        // (a+b-1)/b

        int answer = 1 + (((N - K) + (K - 1) - 1) / (K - 1));
        System.out.println(answer);
    }
}
