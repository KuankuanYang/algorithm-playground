package io.kuankuan.leetcode;

/**
 * 33. Search in Rotated Sorted Array
 * <p>
 * There is an integer array nums sorted in ascending order (with distinct values).
 * <p>
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * <p>
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * @author Kuankuan Yang
 * @date 2021-11-29 15:29
 */
public class Problem33 {
    public static void main(String[] args) {
        Problem33 p = new Problem33();
//        System.out.println(p.search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2, 3}, 4));
        System.out.println(p.search(new int[]{1, 3}, 3));
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        // 找到最大值
        int l = 0;
        int r = len - 1;
        int mid = -1;
        int maxIndex = len - 1;
        int minIndex = 0;
        if (nums[l] < nums[r]) {
            return binarySearch(nums, target, 0, len - 1);
        } else {
            while (l <= r) {
                mid = (l + r) / 2;
                if (nums[mid] > nums[mid + 1]) {
                    break;
                } else {
                    if (nums[mid] < nums[l]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
            maxIndex = mid;
            // 找到最小值
            minIndex = mid + 1;
        }
        // 检查最大最小值是否恰好为 target
        if (nums[maxIndex] == target) {
            return maxIndex;
        }
        if (nums[minIndex] == target) {
            return minIndex;
        }
        // 如果 target >= nums[0]，说明其位于 [0, maxIndex)
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, maxIndex);
        }
        // 如果 target <= nums[len - 1]，说明其位于 (minIndex, len - 1]
        if (target <= nums[len - 1]) {
            return binarySearch(nums, target, minIndex, len - 1);
        }
        return -1;
    }
}
