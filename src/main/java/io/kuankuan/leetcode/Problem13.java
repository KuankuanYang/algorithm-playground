package io.kuankuan.leetcode;

/**
 * 13. Roman to Integer
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 * @author Kuankuan Yang
 * @date 2021-11-12 13:43
 */
public class Problem13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("CMXCIV"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("DXCI"));
    }

    private static int charToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return -1;
        }
    }

    public static int romanToInt(String s) {
        int result = 0;
        int curr;
        int next;

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            curr = charToInt(chars[i]);
            next = charToInt(chars[i + 1]);
            if (curr < next) {
                result -= curr;
            } else {
                result += curr;
            }
        }
        result += charToInt(chars[s.length() - 1]);

        return result;
    }

//    public static int romanToInt(String s) {
//        Map<Character, Integer> symbolMap = new HashMap<>(7);
//        symbolMap.put('I', 1);
//        symbolMap.put('V', 5);
//        symbolMap.put('X', 10);
//        symbolMap.put('L', 50);
//        symbolMap.put('C', 100);
//        symbolMap.put('D', 500);
//        symbolMap.put('M', 1000);
//
//        int result = 0;
//        int curr, next;
//
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < s.length() - 1; i++) {
//            curr = symbolMap.get(chars[i]);
//            next = symbolMap.get(chars[i + 1]);
//            if (curr < next) {
//                result -= curr;
//            } else {
//                result += curr;
//            }
//        }
//        result += symbolMap.get(chars[s.length() - 1]);
//        return result;
//    }
}
