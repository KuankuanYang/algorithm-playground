package io.kuankuan.leetcode;

/**
 * @author Kuankuan Yang
 * @date 2021-12-02 11:12
 */
public class Problem566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int matRowCount = mat.length;
        int matColCount = mat[0].length;
        if (matRowCount * matColCount != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[count / c][count % c] = mat[i][j];
                count++;
            }
        }
        return res;
    }
}
