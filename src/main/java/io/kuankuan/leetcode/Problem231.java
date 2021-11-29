package io.kuankuan.leetcode;

/**
 * @author Kuankuan Yang
 * @date 2021-11-27 14:00
 */
public class Problem231 {

    public static void main(String[] args) {
        Problem231 p = new Problem231();
        p.isPowerOfTwo(-24);
//        int a = -1024;
//        int x = a;
//        System.out.println(Integer.toBinaryString(x));
//        // How to get / isolate the rightmost 1-bit : x & (-x).
//        x = x & (-x);
//        System.out.println(Integer.toBinaryString(x));
//        System.out.println(x);
//        int y = a;
//        System.out.println(Integer.toBinaryString(y));
//        // How to turn off (= set to 0) the rightmost 1-bit : x & (x - 1).
//        y = y & (y - 1);
//        System.out.println(Integer.toBinaryString(y));
//        System.out.println(y);

    }

    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i <= 30; i++) {
            if ((int) Math.pow(2, i) == n) {
                return true;
            }
        }
        return false;
    }

//    public boolean isPowerOfTwo(int n) {
//        if (n == 0) {
//            return false;
//        }
//        long x = n;
////        return (x & (-x)) == x;
//        return (x & (x - 1)) == 0;
//    }

//    // 常规解法 O(logN)
//    public boolean isPowerOfTwo(int n) {
//        if (n == 0) {
//            return false;
//        }
//        while (n % 2 == 0) {
//            n /= 2;
//        }
//        return n == 1;
//    }
}
