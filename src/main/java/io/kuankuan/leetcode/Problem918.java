package io.kuankuan.leetcode;

/**
 * 918. Maximum Sum Circular Subarray
 * <p>
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 * <p>
 * A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
 * <p>
 * A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 *
 * @author Kuankuan Yang
 * @date 2021-12-03 15:04
 */
public class Problem918 {
    public static void main(String[] args) {
        Problem918 p = new Problem918();
        System.out.println(p.maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        // 最大值的出现分两种情况：
        // 1. 子串不穿过首尾相连点
        // 2. 子串穿过首尾相连点，这种情况可以将问题转化为：所有节点的值，减去子串和最小值（不需要穿过首尾相连点），即寻找最小子串的和

        int allSum = 0;
        // 情况一
        int soFarMax = 0;
        int max = Integer.MIN_VALUE;
        int soFarMin = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            // 如果加上当前值，导致子串和小于 0，则当前值不如不加
            // 到目前为止的最大值：
            // 1. 当前 num 加上前序的和
            // 2. 仅选择当前 num
            soFarMax = Math.max(num, soFarMax + num);
            max = Math.max(max, soFarMax);

            // 计算所有 num 之和，备用
            allSum += num;

            // 如果加上当前值，导致子串和大于 0，则当前值不如不加
            // 到目前为止的最小值：
            // 1. 当前 num + 前序的和
            // 2. 当前 num
            soFarMin = Math.min(num, soFarMin + num);
            min = Math.min(min, soFarMin);
        }

        // 如果最小子串和与所有值加起来和相同，即该数组中元素全为负数，此时需返回最大子串和（所有数中最大的那个）
        if (allSum == min) {
            return max;
        } else {
            return Math.max(allSum - min, max);
        }
    }


//    public int maxSubarraySumCircular(int[] nums) {
//        // 最大值的出现分两种情况：
//        // 1. 子串不穿过首尾相连点
//        // 2. 子串穿过首尾相连点，这种情况可以将问题转化为：所有节点的值，减去子串和最小值（不需要穿过首尾相连点），即寻找最小子串的和
//
//        int allSum = 0;
//        // 情况一
//        int max = Integer.MIN_VALUE;
//        int soFarMax = 0;
//        for (int num : nums) {
//            // 如果加上当前值，导致子串和小于 0，则当前值不如不加
//            // 到目前为止的最大值：
//            // 1. 当前 num 加上前序的和
//            // 2. 仅选择当前 num
//            soFarMax = Math.max(num, soFarMax + num);
//            max = Math.max(max, soFarMax);
//
//            // 计算所有 num 之和，备用
//            allSum += num;
//        }
//
//        int soFarMin = 0;
//        int min = Integer.MAX_VALUE;
//        // 情况二
//        for (int num : nums) {
//            // 如果加上当前值，导致子串和大于 0，则当前值不如不加
//            // 到目前为止的最小值：
//            // 1. 当前 num + 前序的和
//            // 2. 当前 num
//            soFarMin = Math.min(num, soFarMin + num);
//            min = Math.min(min, soFarMin);
//        }
//
//        // 如果最小子串和与所有值加起来和相同，即该数组中元素全为负数，此时需返回最大子串和（所有数中最大的那个）
//        if (allSum == min) {
//            return max;
//        } else {
//            return Math.max(allSum - min, max);
//        }
//    }
}