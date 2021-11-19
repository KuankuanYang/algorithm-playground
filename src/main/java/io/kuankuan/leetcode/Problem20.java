package io.kuankuan.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * @author Kuankuan Yang
 * @date 2021-11-11 21:35
 */
public class Problem20 {

    public static void main(String[] args) {
        print("[][][][][][]");
        print("");
        print("()()(){[[[[]]]]}");
        print("[");
        print("]");
    }

    public static void print(String str) {
        System.out.println(str + ": " + isValid(str));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty() && c == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (!stack.isEmpty() && c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (!stack.isEmpty() && c == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
