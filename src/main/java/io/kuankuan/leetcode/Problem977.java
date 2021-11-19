package io.kuankuan.leetcode;

/**
 * 977. Squares of a Sorted Array
 * <p>
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 * @author Kuankuan Yang
 * @date 2021-11-16 10:43
 */
public class Problem977 {

    public int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int res[] = new int[length];

        int start = 0;
        int end = length - 1;

        int insertPosition = end;

        int pow1, pow2;

        while (start <= end) {
            pow1 = nums[start] * nums[start];
            pow2 = nums[end] * nums[end];
            if (pow1 > pow2) {
                res[insertPosition] = pow1;
                insertPosition--;
                start++;
            } else {
                res[insertPosition] = pow2;
                insertPosition--;
                end--;
            }
        }
        return res;
    }

//    public int[] sortedSquares(int[] nums) {
//        if (nums == null) {
//            return null;
//        }
//
//        int length = nums.length;
//        int[] res = new int[length];
//
//        int start = 0, end = length - 1;
//        int insertPosition = end;
//        int pow1 = 0;
//        int pow2 = 0;
//        while (start <= end) {
//            pow1 = nums[start] * nums[start];
//            pow2 = nums[end] * nums[end];
//            if (pow1 > pow2) {
//                res[insertPosition] = pow1;
//                insertPosition--;
//                start++;
//            } else {
//                res[insertPosition] = pow2;
//                insertPosition--;
//                end--;
//            }
//        }
//        return res;
//
//    }
}
