package io.kuankuan.leetcode;

import java.util.Collections;
import java.util.List;

/**
 * 120. Triangle
 * <p>
 * Given a triangle array, return the minimum path sum from top to bottom.
 * <p>
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 *
 * @author Kuankuan Yang
 * @date 2021-11-26 15:26
 */
public class Problem120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int r = 1; r < triangle.size(); r++) {
            for (int c = 0; c <= r; c++) {
                int smallestAbove = Integer.MAX_VALUE;
                if (c > 0) {
                    smallestAbove = triangle.get(r - 1).get(c - 1);
                }
                if (c < r) {
                    smallestAbove = Math.min(smallestAbove, triangle.get(r - 1).get(c));
                }
                int path = smallestAbove + triangle.get(r).get(c);
                triangle.get(r).set(c, path);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}
