package io.kuankuan.leetcode;

import io.kuankuan.leetcode.model.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 19. Remove Nth Node From End of List
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * @author Kuankuan Yang
 * @date 2021-11-19 11:19
 */
public class Problem19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode first = preHead;
        ListNode second = preHead;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return preHead.next;
    }
}
