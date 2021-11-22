package io.kuankuan.leetcode;

import io.kuankuan.leetcode.othermodel.Node;

import java.util.ArrayDeque;

/**
 * 116. Populating Next Right Pointers in Each Node
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 *
 * @author Kuankuan Yang
 * @date 2021-11-22 14:38
 */
public class Problem116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历当前队列
            for (int i = 0; i < size; i++) {
                // 弹出队列顶部的 node
                Node tmp = queue.poll();
                // 如果当前不是该行的最后一个，建立连接
                if (i < size - 1) {
                    tmp.next = queue.peek();
                }
                // 左子节点放入队列
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                // 右子节点放入队列
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
        }
        return root;
    }
}
