package io.kuankuan.leetcode;

/**
 * 1051. Height Checker
 * <p>
 * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
 * <p>
 * You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
 * <p>
 * Return the number of indices where heights[i] != expected[i].
 *
 * @author Kuankuan Yang
 * @date 2021-11-15 15:17
 */
public class Problem1051 {

    public static void main(String[] args) {
        System.out.println(new Problem1051().heightChecker(new int[]{5, 1, 2, 3, 4}));
    }

    public int heightChecker(int[] heights) {
        int[] mark = new int[101];

        for (int height : heights) {
            mark[height]++;
        }

        int res = 0;
        int cur = 0;

        for (int height : heights) {
            // 从小到大，找到值不为 0 的下标
            while (mark[cur] == 0) {
                cur++;
            }

            if (cur != height) {
                res++;
            }
            mark[cur]--;
        }
        return res;
    }

//    public int heightChecker(int[] heights) {
//        int[] sortedArr = Arrays.stream(heights).sorted().toArray();
//        int count = 0;
//        for (int i = 0; i < heights.length; i++) {
//            if (heights[i] != sortedArr[i]) {
//                count++;
//            }
//        }
//        return count;
//    }
}
