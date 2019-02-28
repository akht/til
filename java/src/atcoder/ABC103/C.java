package atcoder.ABC103;

import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // mについての制限はないので、
        // 各余りの最大値はそれぞれ(Ai-1)と考えて良い
        // そのようなmを選んだと仮定すればよい(例えば全ての積から-1したもの)

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += sc.nextInt() - 1;
        }

        System.out.println(ans);
    }

}
