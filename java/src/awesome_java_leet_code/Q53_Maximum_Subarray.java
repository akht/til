package awesome_java_leet_code;

import java.lang.reflect.Array;

// https://github.com/Blankj/awesome-java-leetcode/blob/master/note/053/README.md
public class Q53_Maximum_Subarray {

    /**
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     *
     * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
     * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     */

    public static void main(String[] args) {

        int array[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solve2(array));
    }

    // dp=-2, max=-2
    // i=1のとき、array[i]=1で「dp=1+(-2 > 0 ? dp : 0)」となり、dp=1になる
    //          max = Math.max(dp, max)でmax=1になる
    //
    static int solve(int[] array) {
        int dp = array[0];
        int max = dp;
        for (int i = 1; i < array.length; i++) {
            dp = array[i];
            if (dp > 0) {
                // これまでの結果(dp)がプラスだったら積算する
                // dpがマイナスだったら、これまでの結果は捨てれば良いので0を足す(=仕切り直し)
                // なぜならこれまでのdpがマイナスなら、これまでの要素は足さずに、i番目の要素だけの方が大きくなるため
                dp += dp;
            }

            max = Math.max(max, dp);
        }
        return max;
    }

    static int solve2(int[] array) {
        int sum = 0;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                // マイナスになったら仕切り直し
                sum = 0;
            }
        }

        return max;
    }


    // 分割統治法
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = (left + right) >> 1;
        int leftAns = helper(nums, left, mid);
        int rightAns = helper(nums, mid + 1, right);
        int leftMax = nums[mid], rightMax = nums[mid + 1];
        int temp = 0;
        for (int i = mid; i >= left; --i) {
            temp += nums[i];
            if (temp > leftMax) leftMax = temp;
        }
        temp = 0;
        for (int i = mid + 1; i <= right; ++i) {
            temp += nums[i];
            if (temp > rightMax) rightMax = temp;
        }
        return Math.max(Math.max(leftAns, rightAns), leftMax + rightMax);
    }
}
