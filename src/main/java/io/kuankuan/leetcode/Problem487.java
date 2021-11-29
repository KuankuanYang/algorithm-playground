package io.kuankuan.leetcode;

/**
 * 487. Max Consecutive Ones II
 * <p>
 * Given a binary array nums, return the maximum number of consecutive 1's in the array if you can flip at most one 0.
 *
 * @author Kuankuan Yang
 * @date 2021-11-28 16:40
 */
public class Problem487 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = -1;
        int curr = 0;
        int prev = 0;
        int seenZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                seenZero = 1;
                prev = curr;
                curr = 0;
            } else {
                curr++;
            }
            max = Math.max(max,  prev + curr + seenZero);
        }
        return max;
    }
}
