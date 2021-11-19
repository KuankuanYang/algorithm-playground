package io.kuankuan.leetcode.model;

/**
 * @author Kuankuan Yang
 * @date 2021-11-19 11:13
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
