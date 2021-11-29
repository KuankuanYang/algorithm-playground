package io.kuankuan.leetcode;

/**
 * 1137. N-th Tribonacci Number
 * <p>
 * The Tribonacci sequence Tn is defined as follows:
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * <p>
 * Given n, return the value of Tn.
 *
 * @author Kuankuan Yang
 * @date 2021-11-29 14:46
 */
public class Problem1137 {
    public static void main(String[] args) {
        Problem1137 p = new Problem1137();
        p.tribonacci(4);
    }
    public int tribonacci(int n) {
        int t0 = 0, t1 = 1, t2 = 1;
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int tn = 0;
        // Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0. 等价于
        // Tn = Tn-3 + Tn-2 + Tn-1 for n >= 0
        for (int i = 3; i <= n; i++) {
            tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
        return tn;
    }
}
