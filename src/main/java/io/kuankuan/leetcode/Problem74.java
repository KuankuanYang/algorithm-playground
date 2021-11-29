package io.kuankuan.leetcode;

/**
 * 74. Search a 2D Matrix
 * <p>
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * @author Kuankuan Yang
 * @date 2021-11-29 16:22
 */
public class Problem74 {
    private static boolean binarySearch(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            // int mid = (l + r) / 2;
            // 防止溢出
            int mid = l + (r - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int len = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && matrix[i][len - 1] >= target) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
}
