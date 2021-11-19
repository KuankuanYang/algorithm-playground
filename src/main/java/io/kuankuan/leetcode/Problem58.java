package io.kuankuan.leetcode;

/**
 * 58. Length of Last Word
 * <p>
 * Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal substring consisting of non-space characters only.
 *
 * @author Kuankuan Yang
 * @date 2021-11-13 21:39
 */
public class Problem58 {

    public int lengthOfLastWord(String s) {
        int length = s.length();
        char[] chArr = s.toCharArray();
        int index = s.length() - 1;
        while (chArr[index] == ' ' || chArr[index] == '\t') {
            index--;
        }
        int endIndex = index;
        while (index >= 0 && chArr[index] != ' ' && chArr[index] != '\t') {
            index--;
        }
        return endIndex - index;
    }
}
