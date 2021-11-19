package io.kuankuan.leetcode;

/**
 * 35. Search Insert Position
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * @author Kuankuan Yang
 * @date 2021-11-15 16:50
 */
public class Problem35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int r = nums.length - 1;
        int l = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                // 恰好是 target 时，返回中间点
                return mid;
            }
        }
        // 遍历到最左侧还没有结果，返回 0
        if (r < 0) {
            return 0;
        }
        // 遍历到最右侧还没有结果，返回数组长度
        if (l > nums.length - 1) {
            return nums.length;
        }
        // 如果是在中间时结束循环，则通过中间点计算出结果
        return (l + r) / 2 + 1;
    }

//    public int searchInsert(int[] nums, int target) {
//        int numlen = nums.length;
//        for (int i = 0; i < numlen; i++) {
//            if (nums[i] == target || nums[i] > target) {
//                return i;
//            }
//        }
//        if (target > nums[numlen-1]) return numlen;
//        return 0;
//    }
}
