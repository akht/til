package euclidean_algorithm;

public class Gcd {

    /*
     ユークリッドの互除法

    （例）300と780の最大公約数を求める

     1. 780を300で割る: 780 ÷ 300 = 2 ... 180
     2. 300を180で割る: 300 ÷ 180 = 1 ... 120
     3. 180を120で割る: 180 ÷ 120 = 1 ... 60
     4. 120を60で割る:  120 ÷ 60  = 2
     5. 割り切れたらおしましで、最後に割った数が答え: 60
     */


    /**
     * ユークリッドの互除法を再帰で実装
     *
     * @param a
     * @param b
     * @return
     */
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }


    public static void main(String[] args) {

        System.out.println( gcd(160, 1200) );

        System.out.println( gcd(7800000, 3000000) );

    }



}
