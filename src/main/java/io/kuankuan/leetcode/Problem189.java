package io.kuankuan.leetcode;

/**
 * 189. Rotate Array
 * <p>
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * @author Kuankuan Yang
 * @date 2021-11-16 11:24
 */
public class Problem189 {

    public void rotate(int[] nums, int k) {
        int ln = nums.length;
        k = k % ln;
        reverse(nums, 0, ln - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, ln - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

//    /**
//     * 取余计算新下标
//     *
//     * @param nums
//     * @param k
//     */
//    public void rotate(int[] nums, int k) {
//        int length = nums.length;
//        int[] tmp = new int[length];
//        for (int i = 0; i < length; i++) {
//            tmp[(i + k) % length] = nums[i];
//        }
//        System.arraycopy(tmp, 0, nums, 0, length);
//    }
}
