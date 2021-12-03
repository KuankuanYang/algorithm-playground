package io.kuankuan.leetcode;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * <p>
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 *
 * @author Kuankuan Yang
 * @date 2021-11-30 17:20
 */
public class Problem153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid + 1 < len && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else {
                if (nums[mid] < nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return nums[0];
    }
}
