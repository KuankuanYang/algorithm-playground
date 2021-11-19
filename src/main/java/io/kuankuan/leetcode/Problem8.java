package io.kuankuan.leetcode;

/**
 * 8. String to Integer (atoi)
 *
 * @author Kuankuan Yang
 * @date 2021-11-18 17:54
 */
public class Problem8 {

    public static void main(String[] args) {
//        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("      -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String str) {

        final int len = str.length();
        if (len == 0) {
            return 0;
        }
        int index = 0;
        while (index < len && str.charAt(index) == ' ') {
            ++index;
        }
        boolean isNegative = false;
        if (index < len) {
            if (str.charAt(index) == '-') {
                isNegative = true;
                ++index;
            } else if (str.charAt(index) == '+') {
                ++index;
            }

        }
        int result = 0;
        while (index < len && isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';

            // to avoid integer overflow
            if (result > (Integer.MAX_VALUE / 10) || (result == (Integer.MAX_VALUE / 10) && digit > 7)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            result = (result * 10) + digit;
            ++index;
        }

        return isNegative ? -result : result;
    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
