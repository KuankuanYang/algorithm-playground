package io.kuankuan.leetcode;

/**
 * 567. Permutation in String
 * <p>
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * @author Kuankuan Yang
 * @date 2021-11-19 11:55
 */
public class Problem567 {

    // todo 未完成
    public boolean checkInclusion(String s1, String s2) {
        int s1L = s1.length();
        int s2L = s2.length();
        if (s1L > s2L) {
            return false;
        }
        int[] mark = new int[26];
        for (char ch : s1.toCharArray()) {
            mark[ch - 'a']++;
        }
        int left = 0;
        int right = 0;
        char[] s2Arr = s2.toCharArray();
        while (right < s2L) {
            while (mark[s2Arr[right] - 'a'] > 0) {
                mark[s2Arr[right] - 'a']--;
                right++;
            }
        }
        return false;
    }
}
