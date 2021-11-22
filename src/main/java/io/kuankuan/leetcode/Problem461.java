package io.kuankuan.leetcode;

/**
 * 461. Hamming Distance
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * <p>
 * Given two integers x and y, return the Hamming distance between them.
 *
 * @author Kuankuan Yang
 * @date 2021-11-19 15:05
 */
public class Problem461 {

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
