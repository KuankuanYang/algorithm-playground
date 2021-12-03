package io.kuankuan.leetcode;

/**
 * 844. Backspace String Compare
 * <p>
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * @author Kuankuan Yang
 * @date 2021-12-02 10:41
 */
public class Problem844 {
    public static void main(String[] args) {
        Problem844 p = new Problem844();
        System.out.println(p.backspaceCompare("ab##", "c#d#"));
    }

    public boolean backspaceCompare(String s, String t) {
        int ps = s.length() - 1;
        int pt = t.length() - 1;
        int scount = 0;
        int tcount = 0;

        while (ps >= 0 || pt >= 0) {
            while (ps >= 0) {
                if (s.charAt(ps) == '#') {
                    scount++;
                    ps--;
                } else if (scount > 0) {
                    scount--;
                    ps--;
                } else {
                    break;
                }
            }
            while (pt >= 0) {
                if (t.charAt(pt) == '#') {
                    tcount++;
                    pt--;
                } else if (tcount > 0) {
                    tcount--;
                    pt--;
                } else {
                    break;
                }
            }

            if (ps >= 0 && pt >= 0 && s.charAt(ps) != t.charAt(pt)) {
                return false;
            }

            if ((ps >= 0) != (pt >= 0)) {
                return false;
            }
            ps--;
            pt--;
        }
        return true;
    }
}
