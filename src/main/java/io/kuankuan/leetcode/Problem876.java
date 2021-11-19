package io.kuankuan.leetcode;

import io.kuankuan.leetcode.model.ListNode;

/**
 * 876. Middle of the Linked List
 * <p>
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 *
 * @author Kuankuan Yang
 * @date 2021-11-19 11:12
 */
public class Problem876 {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
