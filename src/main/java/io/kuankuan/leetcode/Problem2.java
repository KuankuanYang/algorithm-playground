package io.kuankuan.leetcode;

import io.kuankuan.leetcode.model.ListNode;

/**
 * 2. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * @author Kuankuan Yang
 * @date 2021-11-17 18:05
 */
public class Problem2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int add = 0;
        while (l1 != null || l2 != null) {
            int x = 0;
            int y = 0;
            if (l1 != null) {
                x = l1.val;
            }
            if (l2 != null) {
                y = l2.val;
            }
            int sum = x + y + add;
            if (sum >= 10) {
                sum -= 10;
                add = 1;
            } else {
                add = 0;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (add > 0) {
            curr.next = new ListNode(add);
        }
        return head.next;
    }
}
