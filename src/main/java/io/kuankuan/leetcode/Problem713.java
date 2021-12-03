package io.kuankuan.leetcode;

/**
 * 713. Subarray Product Less Than K
 * <p>
 * Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
 *
 * @author Kuankuan Yang
 * @date 2021-12-03 13:46
 */
public class Problem713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int prod = 1;
        int ans = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
