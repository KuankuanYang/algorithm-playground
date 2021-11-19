package io.kuankuan.leetcode;

/**
 * 67. Add Binary
 * <p>
 * Given two binary strings a and b, return their sum as a binary string.
 *
 * @author Kuankuan Yang
 * @date 2021-11-15 11:48
 */
public class Problem67 {

    public static void main(String[] args) {
        Problem67 problem67 = new Problem67();
        System.out.println(problem67.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
            "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        if (n < m) {
            return addBinary(b, a);
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int j = m - 1;
        for (int i = n - 1; i > -1; --i) {
            if (a.charAt(i) == '1') {
                carry++;
            }
            if (j > -1 && b.charAt(j--) == '1') {
                carry++;

            }

            if (carry % 2 == 1) {
                sb.append('1');
            } else {
                sb.append('0');
            }

            carry /= 2;
        }
        if (carry == 1) {
            sb.append('1');
        }
        sb.reverse();

        return sb.toString();
    }

//    public String addBinary(String a, String b) {
//        int numA = Integer.parseInt(a, 2);
//        int numB = Integer.parseInt(b, 2);
//        return Integer.toBinaryString(numB + numA);
//    }
}
