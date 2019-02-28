
package atcoder.ABC096;

import java.util.Scanner;

public class D {

    static int n;
    static boolean[] primes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        sieve();

        solve();
    }

    // 素数を列挙してそのうちの５個を選んで和が合成数になっているかを
    // 調べるのはとても大変(終わらない)
    // 5k+1の素数だけを列挙するようにすれば、和は必ず5の倍数となり合成数になる
    // (n=55でも余裕で終わる)
    static void solve() {
        int count = 0;
        for (int i = 5; i < primes.length; i++) {
            if (!primes[i]) {
                continue;
            }

            // 5k+1の素数だけ出力
            if (i % 5 == 1) {
                count++;
                if (count != n) {
                    System.out.print(i + " ");
                } else {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    // 素数の配列を作る
    static void sieve() {
        int n = 55555;

        final int MAX = n + 1;
        primes = new boolean[MAX]; // falseで初期化される

        for (int i = 3; i < MAX; i+=2) {
            // とりあえず奇数は全て素数であるとしておく
            primes[i] = true;
        }
        // 2は素数
        primes[2] = true;


        // 偶数はすでにふるい落としているので、3以上の奇数だけ探索する
        for (int i = 3; i <= Math.sqrt(MAX); i += 2) {
            if (primes[i]) {    // iが素数なら
                // iの倍数をfalseとしてふるい落す
                // j=i*2で2倍から始め、それ以降はj+=iとすることでiの倍数を探索する
                for (int j = i*2; j < MAX; j += i) {
                    primes[j] = false;
                }
            }
        }
    }
}