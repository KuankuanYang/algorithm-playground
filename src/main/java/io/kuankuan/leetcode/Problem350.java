package io.kuankuan.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 * <p>
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 * @author Kuankuan Yang
 * @date 2021-12-01 14:29
 */
public class Problem350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 > l2) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int tmp = map.getOrDefault(n, 0);
            if (tmp > 0) {
                nums1[k] = n;
                map.put(n, tmp - 1);
                k++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

//    public int[] intersect(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int l1 = nums1.length;
//        int l2 = nums2.length;
//        int p1 = 0;
//        int p2 = 0;
//        List<Integer> res = new ArrayList<>();
//        while (true) {
//            if (p1 >= l1 || p2 >= l2) {
//                break;
//            }
//            if (nums1[p1] == nums2[p2]) {
//                res.add(nums1[p1]);
//                p1++;
//                p2++;
//            } else if (nums1[p1] < nums2[p2]) {
//                p1++;
//            } else {
//                p2++;
//            }
//        }
//        int[] r = new int[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            r[i] = res.get(i);
//        }
//        return r;
//    }
}
