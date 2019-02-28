package awesome_java_leet_code;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/007/README.md
public class Q07_Reverse_Integer {

    /**
     * Given a 32-bit signed integer, reverse digits of an integer.
     */

    public static void main(String[] args) {

        System.out.println( reverse(123) == 321 );
        System.out.println( reverse(-123) == -321 );

        System.out.println( reverse(120) == 21 );
        System.out.println( reverse(-120) == -21 );

        System.out.println( reverse(123) );

        System.out.println( reverse(-2147483648) );
    }

    // 32bitの符号付整数の桁をひっくりかえす
    static int reverse(int i) {
        long reverse = 0;
        while (i != 0) {
            reverse *= 10;
            reverse += i % 10;
            i /= 10;
        }

        // while文をforに書き換えると↓
//        for (; i != 0; i /= 10) {
//            reverse *= 10;
//            reverse += i % 10;
//        }

        // 32bitのIntegerの範囲を超えていたら0にする
        if (reverse < Integer.MIN_VALUE || Integer.MAX_VALUE < reverse) {
            reverse = 0;
        }

        return (int)reverse;
    }
}
