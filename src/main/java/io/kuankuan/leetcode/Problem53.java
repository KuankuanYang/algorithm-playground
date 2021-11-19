package io.kuankuan.leetcode;

/**
 * 53. Maximum Subarray
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * A subarray is a contiguous part of an array.
 *
 * @author Kuankuan Yang
 * @date 2021-11-11 22:10
 */
public class Problem53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, -2}));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray(new int[]{1}));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

    public static int maxSubArray(int[] nums) {
        // 将最大值设置为最小的 int 值
        int max = Integer.MIN_VALUE;
        // 将临时子段和设置为 0
        int tmp = 0;
        // 遍历数组
        for (int num : nums) {
            // 临时子段的值为其本身与当前遍历到的数字之和
            tmp += num;
            // 如果最大值比临时子段值小，则更新为临时子段的值
            if (max < tmp) {
                max = tmp;
            }
            // （关键！）临时子段的值小于 0，意味着在后续的计算中，当前临时子段的加入只会让新的临时子段的值变得更小
            // 例如：tmp = -1，则无论如何，tmp + num < num
            // 由此可得，当 tmp 的值小于 0 时，tmp 应当重置为 0
            if (tmp < 0) {
                tmp = 0;
            }
        }
        return max;
    }

    /**
     * Worst solution, Time Limit Exceeded
     *
     * @param nums
     * @return
     */
    public static int maxSubArrayWorst(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int tmp = nums[i];
            if (tmp > sum) {
                sum = tmp;
            }
            for (int j = i + 1; j < len; j++) {
                tmp += nums[j];
                if (tmp > sum) {
                    sum = tmp;
                }
            }
        }
        return sum;
    }
}
