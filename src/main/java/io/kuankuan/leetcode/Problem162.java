package io.kuankuan.leetcode;

/**
 * 162. Find Peak Element
 * <p>
 * A peak element is an element that is strictly greater than its neighbors.
 * <p>
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 *
 * @author Kuankuan Yang
 * @date 2021-11-30 17:29
 */
public class Problem162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1 || nums[0] > nums[1]) {
            return 0;
        }
        if (nums[len - 2] < nums[len - 1]) {
            return len - 1;
        }
        int l = 1;
        int r = len - 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
