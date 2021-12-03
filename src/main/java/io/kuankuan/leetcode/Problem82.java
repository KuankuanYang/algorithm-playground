package io.kuankuan.leetcode;

import io.kuankuan.leetcode.model.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * <p>
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 * @author Kuankuan Yang
 * @date 2021-12-01 17:11
 */
public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pred = preHead;
        while (head != null) {
            // curr 的下一个不为空，且 curr 的值与下一个的值相等
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    // 往后移动一个
                    head = head.next;
                }
                // 前一个的 next 指向 curr 的 next，即移除 curr
                pred.next = head.next;
            } else {
                // 正常移动 pred，不需要进行移除
                pred = pred.next;
            }
            head = head.next;
        }
        return preHead.next;
    }
}
