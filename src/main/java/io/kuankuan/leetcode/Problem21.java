package io.kuankuan.leetcode;

import io.kuankuan.leetcode.model.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * <p>
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * @author Kuankuan Yang
 * @date 2021-11-12 14:57
 */
public class Problem21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        if (l1 == null) {
            prev.next = l2;
        } else {
            prev.next = l1;
        }
        return preHead.next;
    }

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null) {
//            return null;
//        } else if (l1 == null) {
//            return l2;
//        } else if (l2 == null) {
//            return l1;
//        }
//
//        ListNode head;
//        if (l1.val < l2.val) {
//            head = l1;
//            l1 = l1.next;
//            if (l1 == null) {
//                head.next = l2;
//                return head;
//            }
//        } else {
//            head = l2;
//            l2 = l2.next;
//            if (l2 == null) {
//                head.next = l1;
//                return head;
//            }
//        }
//        ListNode tmp = head;
//        while (true) {
//            if (l1.val < l2.val) {
//                tmp.next = l1;
//                l1 = l1.next;
//                if (l1 == null) {
//                    tmp.next.next = l2;
//                    break;
//                }
//            } else {
//                tmp.next = l2;
//                l2 = l2.next;
//                if (l2 == null) {
//                    tmp.next.next = l1;
//                    break;
//                }
//            }
//            tmp = tmp.next;
//        }
//        return head;
//    }

}
