package io.kuankuan.leetcode;

/**
 * 746. Min Cost Climbing Stairs
 * <p>
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 *
 * @author Kuankuan Yang
 * @date 2021-11-20 12:05
 */
public class Problem746 {
    public int minCostClimbingStairs(int[] cost) {
        int l = cost.length;
        // 到达第 i 层的最优解（最小值），为到达第 i - 1 层的最小值和到达第 i - 2 层的最小值，两者中较小的那一个

        int[] res = new int[l + 1];

        for (int i = 2; i < l + 1; i++) {
            res[i] = Math.min(res[i - 2] + cost[i - 2], res[i - 1] + cost[i - 1]);
        }
        return res[l];
    }
}
