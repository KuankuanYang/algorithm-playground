package io.kuankuan.leetcode;

/**
 * 190. Reverse Bits
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 *
 * @author Kuankuan Yang
 * @date 2021-11-28 14:11
 */
public class Problem190 {
    public static void main(String[] args) {
        Problem190 p = new Problem190();
        System.out.println(p.reverseBits(Integer.valueOf("00000010100101000001111010011100", 2)));
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if (n == 0) return 0;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) {
                result++;
            }
            n >>= 1;
        }
        return result;
    }
}
