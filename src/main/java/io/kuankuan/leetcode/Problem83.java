package io.kuankuan.leetcode;

import io.kuankuan.leetcode.model.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * <p>
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 *
 * @author Kuankuan Yang
 * @date 2021-11-15 13:43
 */
public class Problem83 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
