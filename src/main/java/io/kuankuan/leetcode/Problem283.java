package io.kuankuan.leetcode;

/**
 * 283. Move Zeroes
 * <p>
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 *
 * @author Kuankuan Yang
 * @date 2021-11-17 15:29
 */
public class Problem283 {

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int zeroCount = 0;
        int readPoint = 0;
        int writePoint = 0;
        while (readPoint < length) {
            if (nums[readPoint] != 0) {
                nums[writePoint] = nums[readPoint];
                writePoint++;
            } else {
                zeroCount++;
            }
            readPoint++;
        }
        for (int i = writePoint; i < length; i++) {
            nums[i] = 0;
        }
    }

//    public void moveZeroes(int[] nums) {
//        int readpointer = 0;
//        int writepointer = 0;
//        int length = nums.length;
//        int zerocount = 0;
//        for (; readpointer < length; readpointer++) {
//            if (nums[readpointer] != 0) {
//                nums[writepointer] = nums[readpointer];
//                writepointer++;
//            } else {
//                zerocount++;
//            }
//        }
//
//        for (int i = writepointer; i < length; i++) {
//            nums[i] = 0;
//        }
//    }
}
