package io.kuankuan.leetcode;

/**
 * 704. Binary Search
 * <p>
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * @author Kuankuan Yang
 * @date 2021-11-15 15:54
 */
public class Problem704 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        System.out.println(search(nums, 12));
    }

    public static int search(int[] nums, int target) {
        int r = nums.length - 1;
        int l = 0;

        while (r >= l) {
            int mid = (r + l)/2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
