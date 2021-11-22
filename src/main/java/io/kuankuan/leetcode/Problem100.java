package io.kuankuan.leetcode;

import io.kuankuan.leetcode.model.TreeNode;

/**
 * 100. Same Tree
 * <p>
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 * @author Kuankuan Yang
 * @date 2021-11-15 14:44
 */
public class Problem100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traverse(p, q);
    }

    public boolean traverse(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return traverse(p.left, q.left) && traverse(p.right, q.right);
    }
}
