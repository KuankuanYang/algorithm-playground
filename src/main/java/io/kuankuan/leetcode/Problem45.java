package io.kuankuan.leetcode;

/**
 * 45. Jump Game II
 * <p>
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * You can assume that you can always reach the last index.
 *
 * @author Kuankuan Yang
 * @date 2021-12-02 14:56
 */
public class Problem45 {
    public static void main(String[] args) {
        Problem45 p = new Problem45();
        System.out.println(p.jump(new int[]{2,1,1,1,1}));
    }

    public int jump(int[] nums) {
        int jumps = 0;
        int currJumpEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currJumpEnd) {
                jumps++;
                currJumpEnd = farthest;
            }
        }
        return jumps;
    }

//    public int jump(int[] nums) {
//        int len = nums.length;
//        int[] step = new int[len];
//        for (int i = len - 2; i >= 0; i--) {
//            if (nums[i] + i >= len - 1) {
//                step[i] = 1;
//            } else {
//                int min = Integer.MAX_VALUE - 1;
//                for (int j = i + 1; j < nums.length - 1 && j < nums[i] + i + 1; j++) {
//                    min = Math.min(min, step[j]);
//                }
//                step[i] = 1 + min;
//            }
//        }
//        return step[0];
//    }
}
