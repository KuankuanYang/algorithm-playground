package io.kuankuan.leetcode;

/**
 * 557. Reverse Words in a String III
 * <p>
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * @author Kuankuan Yang
 * @date 2021-11-18 10:14
 */
public class Problem557 {

    public static void main(String[] args) {
        Problem557 p = new Problem557();
        p.reverseWords("Let's take LeetCode contest");
    }

    public String reverseWords(String s) {
        char[] sArr = s.toCharArray();
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (sArr[i] == ' ') {
                reverseString(sArr, tmp, i - 1);
                tmp = i + 1;
            }
        }
        if (s.length() > 1) {
            reverseString(sArr, tmp, s.length() - 1);

        }
        return new String(sArr);
    }

    public void reverseString(char[] s, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}
