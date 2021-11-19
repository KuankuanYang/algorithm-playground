package io.kuankuan.leetcode;

import java.util.Arrays;

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

    public static boolean isSame(int[] sm, int[] pm) {
        return Arrays.equals(sm, pm);
    }

    public boolean checkInclusion(String s1, String s2) {
        int s1l = s1.length();
        int s2l = s2.length();

        // s1 比 s2 长，没有比较的必要
        if (s1l > s2l) {
            return false;
        }

        int[] s1Mark = new int[26];
        int[] s2Mark = new int[26];

        // 统计 s1 中每个字符出现的次数
        for (int i = 0; i < s1l; i++) {
            s1Mark[s1.charAt(i) - 'a']++;
        }

        // 遍历 s2
        for (int i = 0; i < s2l; i++) {
            // 统计 s[i] 出现的次数
            s2Mark[s2.charAt(i) - 'a']++;

            if (i >= s1l) {
                s2Mark[s2.charAt(i - s1l) - 'a']--;
            }

            // 比较统计个数是否相同
            if (isSame(s1Mark, s2Mark)) {
                return true;
            }
        }
        return false;
    }
}
