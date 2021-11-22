package io.kuankuan.leetcode;

/**
 * 70. Climbing Stairs
 * <p>
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * @author Kuankuan Yang
 * @date 2021-11-20 01:45
 */
public class Problem70 {

    public int climbStairs(int n) {
        // 要求上 n 层楼梯有几种方法，需要求上 n - 1 层的方法数 + 上 n - 2 层的方法数
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i < n + 1; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

//    public int climbStairs(int n) {
//        // 要求上 n 层楼梯有几种方法，需要求上 n - 1 层的方法数 + 上 n - 2 层的方法数
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        dp[2] = 2;
//
//        for (int i = 3; i < n + 1; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }
}
