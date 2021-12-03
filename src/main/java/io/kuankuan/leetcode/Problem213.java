package io.kuankuan.leetcode;

/**
 * 213. House Robber II
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 * @author Kuankuan Yang
 * @date 2021-12-01 16:11
 */
public class Problem213 {

    public int rob(int[] nums, int start, int end) {
        int dp[] = new int[end - start];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i < end; i++) {
            dp[i - start] = Math.max(nums[i] + dp[i - start - 2], dp[i - start - 1]);
        }
        return dp[dp.length - 1];
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }
}
