package etc;

public class Eratosthenes {
    public static void main(String[] args) {
        sieve(3);
    }

    // 整数nまでの素数を出力する
    public static void sieve(int n) {

        // 配列のインデックスを判定対象として使うので+1する
        // (例えば5までの素数を見つけたい場合、+1せずにnew int[5]とすると
        // {0,1,2,3,4}となり4までしか判定できない。
        // +1してnew int[6]とすれば{0,1,2,3,4,5}となり5まで判定できる)
        final int MAX = n + 1;
        // MAX個の要素を持つ配列を作成(要素はすべてfalseで初期化される)
        boolean[] primes = new boolean[MAX];

        // 1と2の倍数(偶数)が素数でないのは自明なので
        // 3から始めてすべての奇数をとりあえず素数であるとしておく
        for (int i = 3; i < MAX; i += 2) {
            primes[i] = true;
        }
        // 偶数のうち、2だけは素数なのでtrueを代入
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


        // primes配列の中でtrueとなっている要素のインデックスが素数ということになる
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }
    }
}
