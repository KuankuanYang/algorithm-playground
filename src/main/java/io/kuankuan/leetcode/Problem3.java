package io.kuankuan.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * 步骤：
 * 1. 左右指针 right 和 left 指定一个窗口，初始值均设为 0；
 * 2. 右指针递增，扩大窗口范围，每次增加时检查 arr[right] 是否已经在窗口中，若不存在则更新最大长度
 * 3. 右指针递增时发现 arr[right] 已存在，则开始缩小窗口范围（left 递增），直到 arr[right] 在窗口中唯一
 * 4. 继续右指针递增，直到遍历完整个数组
 *
 * @author Kuankuan Yang
 * @date 2021-11-18 11:17
 */
public class Problem3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < len) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left);
            }
            res = Math.max(res, right - left + 1);
            map.put(s.charAt(right), right + 1);
            right++;
        }
        return res;
    }

//    public static int lengthOfLongestSubstring(String s) {
//        int[] mark = new int[128];
//        char[] arr = s.toCharArray();
//        int res = 0;
//        int left = 0;
//        int right = 0;
//        int length = s.length();
//        while (right < length) {
//            // 右边界字符计数 +1
//            mark[arr[right]]++;
//
//            // 移动左边界，直到右边界字符在该子串中至多出现一次
//            while (mark[arr[right]] > 1) {
//                mark[arr[left]]--;
//                left++;
//            }
//
//            // 更新最大值（若需要）
//            res = Math.max(res, right - left + 1);
//
//            // 移动右边界
//            right++;
//        }
//        return res;
//    }
}