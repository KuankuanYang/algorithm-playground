package io.kuankuan.leetcode;

/**
 * 4. Median of Two Sorted Arrays
 * <p>
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 *
 * @author Kuankuan Yang
 * @date 2021-11-28 22:31
 */
public class Problem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int lensum = l1 + l2;
        // 偶数时，下标为l/2-1和l/2之和除以2
        // 奇数时，下标为l/2
        int indexI = 0;
        int indexJ = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i < lensum / 2 + 1; i++) {
            int tmp = 0;
            if (indexI == l1 || nums1[indexI] >= nums2[indexJ]) {
                tmp = nums2[indexJ];
                indexJ++;
            } else if (nums1[indexI] < nums2[indexJ]) {
                tmp = nums1[indexI];
                indexI++;
            }
            if (i == lensum / 2 - 1) {
                a = tmp;
            }
            if (i == lensum / 2) {
                if (lensum % 2 == 1) {
                    return tmp;
                }
                b = tmp;
            }
        }
        return (a + b) * 1.0 / 2;
    }
}
