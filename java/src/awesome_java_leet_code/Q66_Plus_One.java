package awesome_java_leet_code;

import java.util.Arrays;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/066/README.md
public class Q66_Plus_One {

    /**
     * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
     * You may assume the integer do not contain any leading zero, except the number 0 itself.
     * The digits are stored such that the most significant digit is at the head of the list.
     *
     * 配列で各桁を表した数字に1を足したものを配列で表せ
     * 例)
     * {1,2,3} -> 1を足す -> {1,2,4}
     * {1,2,9} -> 1を足す -> {1,3,0}
     *
     */

    public static void main(String[] args) {

        int[] digits0 = {0};
        int[] digits1 = {1,2,9};
        int[] digits2 = {1,9,9};
        int[] digits3 = {9,9,9};


//        System.out.println(Arrays.toString(plusOne(digits0)));
//        System.out.println(Arrays.toString(plusOne(digits1)));
//        System.out.println(Arrays.toString(plusOne(digits2)));
//        System.out.println(Arrays.toString(plusOne(digits3)));


        System.out.println(Arrays.toString(plusOne2(digits0.length-1, digits0)));
        System.out.println(Arrays.toString(plusOne2(digits1.length-1, digits1)));
        System.out.println(Arrays.toString(plusOne2(digits2.length-1, digits2)));
        System.out.println(Arrays.toString(plusOne2(digits3.length-1, digits3)));
    }


    // 普通に書く
    static int[] plusOne(int[] digits) {
        if (digits.length == 1 && digits[0] == 0) {
            // {0}のときは{1}
            digits[0]++;
            return digits;
        }

        if (digits[digits.length-1] <= 8) {
            // 繰り上がらない場合
            digits[digits.length-1]++;
            return digits;
        }

        // 最後が9で、繰り上がる場合
        digits[digits.length-1] = 0;
        for (int i = digits.length-2; i >= 0; i--) {
            // 繰り上がりを処理
            int digit = digits[i];
            if (digit <= 8) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
            }
        }

        // 全ての桁が9で、繰り上がり続けた場合
        if (digits[0] == 0) {
            // 先頭の桁が0なら繰り上がりでさらに1を先頭にくっつける
            int len = digits.length;
            int[] temp = new int[len+1];
            temp[0] = 1;

            return temp;
        }

        return digits;
    }

    // 再帰で書く
    static int[] plusOne2(int p, int[] digits) {
        digits[p]++;
        if (digits[p] < 10) {
            return digits;
        }

        if (p == 0) {
            if (digits[0] > 9) {
                int[] ret = new int[digits.length+1];
                ret[0] = 1;
                return ret;
            }
            return digits;
        }

        digits[p] = 0;
        return plusOne2(p-1, digits);
    }
}
