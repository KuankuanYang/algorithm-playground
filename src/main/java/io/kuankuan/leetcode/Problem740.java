package io.kuankuan.leetcode;

/**
 * 740. Delete and Earn
 * <p>
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
 * <p>
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 *
 * @author Kuankuan Yang
 * @date 2021-12-01 16:56
 */
public class Problem740 {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int num : nums) {
            count[num] += num;
        }
        return rob(count);
    }
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
            // 当前最优为：抢劫下一家，当前家+抢劫下下家，两者的最大值
            int curr = Math.max(robNext, robNextPlusOne + nums[i]);
            // 下下家更新为下家
            robNextPlusOne = robNext;
            // 下家更新为当前家
            robNext = curr;
        }
        return robNext;
    }
}
