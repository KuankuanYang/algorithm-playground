package io.kuankuan.leetcode;

/**
 * 198. House Robber
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 * @author Kuankuan Yang
 * @date 2021-11-26 15:10
 */
public class Problem198 {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        int robNextPlusOne = 0;
        int robNext = nums[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            int curr = Math.max(robNext, robNextPlusOne + nums[i]);

            robNextPlusOne = robNext;
            robNext = curr;
        }
        return robNext;
    }

//    public int rob(int[] nums) {
//        int len = nums.length;
//        if (len == 1) {
//            return nums[0];
//        }
//        int[] max = new int[len];
//        max[0] = nums[0];
//        max[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < len; i++) {
//            max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
//        }
//        return max[len - 1];
//    }
}
