package io.kuankuan.leetcode;

/**
 * 209. Minimum Size Subarray Sum
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 * @author Kuankuan Yang
 * @date 2021-12-03 13:55
 */
public class Problem209 {
    public static void main(String[] args) {
        Problem209 p = new Problem209();
        System.out.println(p.minSubArrayLen(1, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int result = 100001;
        int left = 0;
        int right = 0;
        int sum = 0;
        for (; right < nums.length; right++) {
            if (nums[right] == target) {
                return 1;
            }
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == 100001 ? 0 : result;
    }
}
