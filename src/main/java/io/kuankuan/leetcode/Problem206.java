package io.kuankuan.leetcode;

import io.kuankuan.leetcode.model.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 206. Reverse Linked List
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * @author Kuankuan Yang
 * @date 2021-11-24 19:23
 */
public class Problem206 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode l2 = reverseList(l1);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

//    public static ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        Deque<ListNode> stack = new ArrayDeque<>();
//        while (head != null) {
//            stack.push(head);
//            head = head.next;
//        }
//        ListNode newHead = stack.pop();
//        ListNode tmp = newHead;
//        while (!stack.isEmpty()) {
//            tmp.next = stack.pop();
//            tmp = tmp.next;
//        }
//        tmp.next = null;
//        return newHead;
//    }
}
