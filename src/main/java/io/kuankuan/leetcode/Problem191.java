package io.kuankuan.leetcode;

/**
 * 191. Number of 1 Bits
 * <p>
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 *
 * @author Kuankuan Yang
 * @date 2021-11-27 14:36
 */
public class Problem191 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }
//    public int hammingWeight(int n) {
//        String ns = Integer.toBinaryString(n);
//        int res = 0;
//        for (int i = 0; i < ns.length(); i++) {
//            if (ns.charAt(i) == '1') {
//                res++;
//            }
//        }
//        return res;
//    }
//    public int hammingWeight(int n) {
//        return Integer.bitCount(n);
//    }
}
