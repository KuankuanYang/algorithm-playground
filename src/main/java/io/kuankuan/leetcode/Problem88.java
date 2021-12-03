package io.kuankuan.leetcode;

/**
 * 88. Merge Sorted Array
 * <p>
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * @author Kuankuan Yang
 * @date 2021-11-30 16:38
 */
public class Problem88 {
    public static void main(String[] args) {
        Problem88 p = new Problem88();
        p.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{3, 5, 6}, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (p1 == -1) {
                nums1[i] = nums2[p2];
                p2--;
                continue;
            }
            if (p2 == -1) {
                nums1[i] = nums1[p1];
                p1--;
                continue;
            }
            if (nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }
}
