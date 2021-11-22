package io.kuankuan.leetcode;

/**
 * 695. Max Area of Island
 * <p>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 * @author Kuankuan Yang
 * @date 2021-11-21 16:29
 */
public class Problem695 {

    int[][] grid;
    boolean[][] seen;

    public int area(int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || seen[r][c] || grid[r][c] == 0) {
            return 0;
        }
        seen[r][c] = true;
        return (1 + area(r + 1, c) + area(r - 1, c) + area(r, c + 1) + area(r, c - 1));
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }
}
