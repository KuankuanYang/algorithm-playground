package io.kuankuan.leetcode;

/**
 * 278. First Bad Version
 * <p>
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 * @author Kuankuan Yang
 * @date 2021-11-15 16:25
 */
public class Problem278 {
    public static boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            // 使用下面的算法，避免通过 mid = (l + r) / 2 计算时潜在的整型溢出风险
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
