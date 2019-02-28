package awesome_java_leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/058/README.md
public class Q58_Length_Of_Last_Word {

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
     *
     * If the last word does not exist, return 0.
     */


    public static void main(String[] args) {

        String s = "Hello World";
        System.out.println(solve(s));
        System.out.println(solve2(s));
        System.out.println(solve3(s));

    }

    // 単純な方法
    static int solve(String s) {

        return s.trim().length() - s.indexOf(' ') - 1;

    }

    // 畳み込み
    static int solve2(String str) {

        return Arrays.stream(str.trim().split(" ")).map(x -> x.length()).reduce((x, y) -> y).orElse(0);

    }

    // whileでポインタをずらしていく
    static int solve3(String str) {

        int p = str.length() - 1;
        while (p >= 0 && str.charAt(p) == ' ') {
            // 末尾にスペースが付いている場合を考慮して、スペースがないところまでポインタを進める
            p--;
        }
        int end = p;
        while (p >= 0 && str.charAt(p) != ' ') {
            // 末尾からスペースの手前までポインタを進める
            p--;
        }
        return end - p;
    }
}
