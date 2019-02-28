package atcoder.ABC098;

import java.util.Arrays;
import java.util.Scanner;

public class D {

    /*
    長さ N の整数列 A があります。

    次の条件を満たす整数 l, r ( 1≤l≤r≤N ) の組の個数を求めてください。

    Al xor Al+1 xor … xor Ar=Al + Al+1 + … + Ar
     */

    static int N;
    static int[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

//        solve();

        solve2();
    }

    static void solve() {
        // 累積和(cumulative sum キュムレティブサム、cumsum)を求める
        long[] cumsum = new long[N];
        cumsum[0] = A[0];

        for (int i = 1; i < N; i++) {
            cumsum[i] = cumsum[i-1] + A[i];
        }
        System.out.println(Arrays.toString(cumsum));

        long[] xorsum = new long[N];
        xorsum[0] = A[0];
        for (int i = 1; i < N; i++) {
            xorsum[i] = xorsum[i-1] ^ A[i];
        }
        System.out.println(Arrays.toString(xorsum));

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                // 区間の和
                long sum = cumsum[j] - (i == 0 ? 0 : cumsum[i-1]);

                // 区間のxor
                long xor = xorsum[j] ^ (i == 0 ? 0 : xorsum[i-1]);

                if (sum == xor) {
                    count++;
                }

            }
        }
        System.out.println(count);
    }

    // しゃくとり法でやる
    public static void solve2() {

        long count = 0;
        long sum = 0;
        int right = 0;
        for (int left = 0; left < N; left++) {

            while (right < N && (sum ^ A[right]) == sum + A[right]) {
                sum += A[right];
                right++;
            }

            count += right - left;

            if (left == right) {
                right++;
            } else {
                sum -= A[left];
            }
        }

        System.out.println(count);
    }

}
