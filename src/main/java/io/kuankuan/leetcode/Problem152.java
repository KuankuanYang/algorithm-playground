package io.kuankuan.leetcode;

/**
 * 152. Maximum Product Subarray
 * <p>
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 * <p>
 * It is guaranteed that the answer will fit in a 32-bit integer.
 * <p>
 * A subarray is a contiguous subsequence of the array.
 *
 * @author Kuankuan Yang
 * @date 2021-12-03 17:12
 */
public class Problem152 {
    public static void main(String[] args) {
        Problem152 p = new Problem152();
        System.out.println(p.maxProduct(new int[]{2, 3, -2, 4}));
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int maxProduct(int[] nums) {
        int soFarMax = nums[0];
        int soFarMin = nums[0];
        int max = soFarMax;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            // 临时最大值：当前值，之前最大值乘当前值，之前最小值乘当前值
            int tmpMax = max(curr, soFarMax * curr, soFarMin * curr);
            // 当前最小值：当前值，之前最大值乘当前值，之前最小值乘当前值
            soFarMin = min(curr, soFarMax * curr, soFarMin * curr);
            // 更新当前最大值
            soFarMax = tmpMax;
            max = Math.max(max, soFarMax);
        }
        return max;
    }
}
