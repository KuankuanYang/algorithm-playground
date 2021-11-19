package io.kuankuan.leetcode;

import io.kuankuan.leetcode.model.ListNode;

/**
 * 203. Remove Linked List Elements
 * <p>
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 *
 * @author Kuankuan Yang
 * @date 2021-11-12 16:53
 */
public class Problem203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode prev = preHead;
        while (head != null) {
            if (head.val == val) {
                head = head.next;
                if (head == null) {
                    prev.next = null;
                }
                continue;
            } else {
                prev.next = head;
            }
            head = head.next;
            prev = prev.next;
        }

        return preHead.next;
    }
}
