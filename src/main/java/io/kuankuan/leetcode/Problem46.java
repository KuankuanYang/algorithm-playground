package io.kuankuan.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 46. Permutations
 * <p>
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * @author Kuankuan Yang
 * @date 2021-11-25 14:33
 */
public class Problem46 {

    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> numList;
    int len;

    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
//        numList = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        back(0, nums);
        return res;
    }
//    public void back(int first, ArrayList<Integer> curr) {
//        if (first == len) {
//            res.add(new ArrayList<>(curr));
//        }
//        for (int i = first; i < len; i++) {
//            Collections.swap(curr, first, i);
//            back(first + 1, curr);
//            Collections.swap(curr, first, i);
//        }
//    }

    public void back(int first, int[] curr) {
        if (first == len) {
            res.add(arrayToList(curr));
        }
        for (int i = first; i < len; i++) {
            swap(curr, first, i);
            back(first + 1, curr);
            swap(curr, first, i);
        }
    }

    private void swap(int[] curr, int index1, int index2) {
        int tmp = curr[index1];
        curr[index1] = curr[index2];
        curr[index2] = tmp;
    }

    private ArrayList<Integer> arrayToList(int[] ints) {
        ArrayList<Integer> res = new ArrayList<>(ints.length);
        for (int i : ints) {
            res.add(i);
        }
        return res;
    }
}
