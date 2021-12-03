package io.kuankuan.leetcode;

/**
 * 11. Container With Most Water
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 * <p>
 * Notice that you may not slant the container.
 *
 * @author Kuankuan Yang
 * @date 2021-12-02 16:19
 */
public class Problem11 {
    /**
     * 暴力搜索 Time Limit Exceeded
     */
//    public int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
//            }
//        }
//        return max;
//    }
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
