package awesome_java_leet_code;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/009/README.md
public class Q09_Palindrome_Number {

    /**
     * Determine whether an integer is a palindrome. Do this without extra space.
     *
     * 与えられた整数が回文になっているか判定してください
     * 制限：余分なメモリは使わない
     */

    public static void main(String[] args) {

        System.out.println( isPalindrome(123454321) );
        System.out.println( isPalindrome(121) );
        System.out.println( isPalindrome(1230) );

        System.out.println( isPalindrome(-1) );
        System.out.println( isPalindrome(-123) );
        System.out.println( isPalindrome(-121) );

    }

    // 整数が回文になっているかどうか判定する
    // 簡単な方法は「逆順にしたものと比較して一致すれば回文である」というのがあるが
    // これは文字列を生成しないといけないので今回はダメ
    static boolean isPalindrome(int n) {
        // 負数は関係ない
        n = Math.abs(n);

        // 桁数をはかって10を累乗する
        int digit = 1;
        while (true) {
            if (n / (digit * 10) > 0) {
                digit *= 10;
            } else {
                break;
            }
        }

        // 回文になっているかどうかの判定
        // 例）n = 12321
        // まず上でもとめた桁数をつかってnを割った商を求めると、1になる
        // nを10で割った余りを求めると、1になる
        // このふたつを比べて(つまり先頭と末尾を比べている)、一致していなければ回文ではない
        // 一致していれば、次の比較に移る
        // 次の比較に備えて、商x桁数(=10000)と余り(=1)を足したものをn(12321)から引く
        // n=2320になるので、これを10で割って232にする
        // 次に、nが先頭と末尾がひとつずつ消えて、桁としては2桁減ったことになるので
        // 次に割る用の桁数(digit)を2つ減らす(digit /= 100)
        // 次の比較を行う
        while (true) {
            if (-10 < n && n < 10) {
                // ひとけたの数字はかならず回文
                break;
            }
            if ((n / digit) == (n % 10)) { // 商 == 余り
                n = n - ((n / digit) * digit + (n % 10));
                n /= 10;
                digit /= 100;
            } else {
                return false;
            }
        }
        return true;
    }
}
