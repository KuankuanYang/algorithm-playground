package io.kuankuan.leetcode;

import io.kuankuan.leetcode.model.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * <p>
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * @author Kuankuan Yang
 * @date 2021-11-22 15:26
 */
public class Problem98 {
    private Integer prev;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    public boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }

    public boolean dfs(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    /**
     * 对于例如：
     *       5
     *      /\
     *     4  6
     *        /\
     *       3  7
     * 3 和 7 虽然对于 6 满足要求，但 3 不满足大于 5 的要求，故其不是 BST
     * 下述算法错误
     *
     * @param root
     * @return
     */
    public boolean dfsWrong(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        return dfsWrong(root.left) && dfsWrong(root.right);
    }
}
