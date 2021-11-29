package io.kuankuan.leetcode;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * @author Kuankuan Yang
 * @date 2021-11-29 14:58
 */
public class Problem34 {
    public static void main(String[] args) {
        Problem34 p = new Problem34();
        p.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }

    public int[] searchRange(int[] nums, int target) {
        // 通过二分查找到 target
        int left = 0;
        int right = nums.length - 1;
        int resL = -1;
        int resR = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                // 往前往后确定下标
                resL = mid;
                resR = mid;
                while (resL >= 0 && nums[resL] == target) {
                    resL--;
                }
                resL++;
                while (resR <= nums.length - 1 && nums[resR] == target) {
                    resR++;
                }
                resR--;
                break;
            }
        }
        return new int[]{resL, resR};
    }
}
