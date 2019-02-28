package awesome_java_leet_code;

import java.util.Arrays;
import java.util.List;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/035/README.md
public class Q35_Search_Insert_Position {

    /**
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     *
     * You may assume no duplicates in the array.
     */

    public static void main(String[] args) {

        System.out.println( solve(Arrays.asList(1,3,5,6), 5) );
        System.out.println( solve(Arrays.asList(1,3,5,6), 2) );
        System.out.println( solve(Arrays.asList(1,3,5,6), 4) );
        System.out.println( solve(Arrays.asList(1,3,5,6), 7) );
        System.out.println( solve(Arrays.asList(1,3,5,6), 0) );
        System.out.println();
        System.out.println( solve(Arrays.asList(1,3,5), 5) );
        System.out.println( solve(Arrays.asList(1,3,5), 2) );
        System.out.println( solve(Arrays.asList(1,3,5), 4) );
        System.out.println( solve(Arrays.asList(1,3,5), 7) );
        System.out.println( solve(Arrays.asList(1,3,5), 0) );
        System.out.println();
        System.out.println( solve(Arrays.asList(1), 0) );
        System.out.println( solve(Arrays.asList(1), 1) );
        System.out.println( solve(Arrays.asList(1), 2) );

    }

    static int solve(List<Integer> list, int target) {
        int begin = 0;
        int end = list.size() - 1;
        int mid = (end + begin) >> 1;
        while (begin <= end) {
            if (target <= list.get(mid)) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
            mid = (begin + end) >> 1;
        }
        return begin;
    }
}
