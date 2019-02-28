package two_pointers;

import java.util.HashSet;
import java.util.Set;

public class TP5 {

    /*
    長さnの正の整数列 a1,a2,…,ana1,a2,…,an が与えられる。
    整数列の連続する部分列のうち、「同じ数値が 2 箇所以上登場しない」という条件を満たす最大長を求めよ。
     */

    public static void main(String[] args) {

        solve();

    }

    static int n = 7;
    static int[] a= {1,2,1,3,1,4,4};

    public static void solve() {

        Set<Integer> set = new HashSet<>();

        int max = 0;
        int right = 0;

        for (int left = 0; left < n; left++) {

            while (right < n && !set.contains(a[right])) {
                set.add(a[right]);
                right++;
            }

            max = Math.max(max, right - left);

            if (left == right) {
                right++;
            } else {
                set.remove(a[left]);
            }
        }

        System.out.println(max);
    }
}
