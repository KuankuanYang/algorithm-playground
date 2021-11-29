package io.kuankuan.leetcode;

import io.kuankuan.leetcode.model.TreeNode;

/**
 * 99. Recover Binary Search Tree
 * <p>
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 *
 * @author Kuankuan Yang
 * @date 2021-11-22 16:17
 */
public class Problem99 {

    /**
     * 方法一：递归中序遍历，获取列表，寻找并交换错位节点
     */
//    private List<TreeNode> tnList = new ArrayList<>();
//
//    public void recoverTree(TreeNode root) {
//        // 通过中序遍历，获取数组，该数组中仅有两个数字错位
//        inorder(root);
//        TreeNode a = null;
//        TreeNode b = null;
//        // 遍历数组，用临时 TreeNode 指向这两个错位的节点
//        for (int i = 0; i < tnList.size() - 1; i++) {
//            // 正常情况下，该数组为升序，两两对比数字
//            if (tnList.get(i + 1).val < tnList.get(i).val) {
//                // 每次遇到错位数字对时，保留后一个数，该值可能为错位的数字之一（两个错位数字挨在一起时），也有可能不是
//                a = tnList.get(i + 1);
//                if (b == null) {
//                    // 首次遇到错位数字对时，前一个必为错位数字
//                    b = tnList.get(i);
//                } else {
//                    // 第二次遇到错位数字对时，后一个必为错位数字
//                    break;
//                }
//            }
//        }
//        // 交换两个错位数字的值
//        int tmp = a.val;
//        a.val = b.val;
//        b.val = tmp;
//    }
//
//    public void inorder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        inorder(root.left);
//        tnList.add(root);
//        inorder(root.right);
//    }

    /**
     * 方法二：循环中序遍历，遍历途中找到错位节点，最后交换错位节点
     */
//    public void recoverTree(TreeNode root) {
//        inorderTraversal(root);
//    }
//
//    public void inorderTraversal(TreeNode root) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        TreeNode a = null;
//        TreeNode b = null;
//        TreeNode pre = null;
//
//        while (!stack.isEmpty() || root != null) {
//            while (root != null) {
//                stack.add(root);
//                root = root.left;
//            }
//            root = stack.removeLast();
//            if (pre != null && root.val < pre.val) {
//                a = root;
//                if (b == null) {
//                    b = pre;
//                } else {
//                    break;
//                }
//            }
//            pre = root;
//            root = root.right;
//        }
//        int tmp = a.val;
//        a.val = b.val;
//        b.val = tmp;
//    }

    /**
     * 方法三：基本思路与上述方法类似，但是通过 Morris Inorder Traversal 的方式遍历，从而实现 O(1) 的空间开销
     */
    public void recoverTree(TreeNode root) {
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pred = null;
        TreeNode predecessor = null;

        while (root != null) {
            // If there is a left child
            // then compute the predecessor.
            // If there is no link predecessor.right = root --> set it.
            // If there is a link predecessor.right = root --> break it.
            if (root.left != null) {
                // Predecessor node is one step left
                // and then right till you can.
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root)
                    predecessor = predecessor.right;

                // set link predecessor.right = root
                // and go to explore left subtree
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // break link predecessor.right = root
                // link is broken : time to change subtree and go right
                else {
                    // check for the swapped nodes
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) x = pred;
                    }
                    pred = root;

                    predecessor.right = null;
                    root = root.right;
                }
            }
            // If there is no left child
            // then just go right.
            else {
                // check for the swapped nodes
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) x = pred;
                }
                pred = root;

                root = root.right;
            }
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}