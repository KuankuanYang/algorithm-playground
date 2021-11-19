package io.kuankuan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * <p>
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * s: acndbasdcasdfascda
 * p: ads
 *
 * @author Kuankuan Yang
 * @date 2021-11-19 13:37
 */
public class Problem438 {

    public static boolean isSame(int[] sm, int[] pm) {
        return Arrays.equals(sm, pm);
    }

    public List<Integer> findAnagrams(String s, String p) {
        int sl = s.length();
        int pl = p.length();
        List<Integer> res = new ArrayList<>();

        // s 比 p 短，没有比较的必要
        if (sl < pl) {
            return res;
        }

        int[] sMark = new int[26];
        int[] pMark = new int[26];

        // 统计 p 中每个字符出现的次数
        for (int i = 0; i < pl; i++) {
            pMark[p.charAt(i) - 'a']++;
        }

        // 遍历 s
        for (int i = 0; i < sl; i++) {
            // 统计 s[i] 出现的次数
            sMark[s.charAt(i) - 'a']++;

            // 统计 s 子串的长度应小于等于 p 的长度，当已统计的个数大于 p 的长度时，应把子串最左端的字符个数减除
            // 假设 p 长度为 3
            // 则在 s 字符串中，下标为 0、1、2 可直接进入；当 3 进入时，需要将 0 移出；当 4 进入时，需要将 1 移出
            if (i >= pl) {
                sMark[s.charAt(i - pl) - 'a']--;
            }

            // 比较统计个数是否相同
            if (isSame(sMark, pMark)) {
                res.add(i - pl + 1);
            }
        }
        return res;
    }
}
