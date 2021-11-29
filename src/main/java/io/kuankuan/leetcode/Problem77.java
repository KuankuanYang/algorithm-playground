package io.kuankuan.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 * <p>
 * You may return the answer in any order.
 *
 * @author Kuankuan Yang
 * @date 2021-11-25 11:25
 */
public class Problem77 {
    List<List<Integer>> res = new LinkedList<>();
    int n, k;

    public static void main(String[] args) {
        Problem77 p = new Problem77();
        p.combine(4,3);
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        back(1, new LinkedList<>());
        return res;
    }

    public void back(int first, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            res.add(new LinkedList<>(curr));
        }
        for (int i = first; i < n + 1; i++) {
            // 把 i 放入
            curr.add(i);
            // 放入下一个数，进入递归
            back(i + 1, curr);
            // 把最后一个数移除，回溯
            curr.removeLast();
        }
    }
}
