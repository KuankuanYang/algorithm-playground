package io.kuankuan.leetcode;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * <p>
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * @author Kuankuan Yang
 * @date 2021-11-17 15:37
 */
public class Problem167 {

    public static void main(String[] args) {
        Problem167 p = new Problem167();
        p.twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int tmpSum = numbers[left] + numbers[right];
            if (tmpSum == target) {
                return new int[]{left + 1, right + 1};
            } else if (tmpSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }
}
