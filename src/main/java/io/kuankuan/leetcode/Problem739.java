package io.kuankuan.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. Daily Temperatures
 * <p>
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i]
 * is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for
 * which this is possible, keep answer[i] == 0 instead.
 *
 * @author Kuankuan Yang
 * @date 2021-11-13 22:11
 */
public class Problem739 {

    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int currIndex = 0; currIndex < len; currIndex++) {
            while (!deque.isEmpty() && temperatures[deque.peek()] < temperatures[currIndex]) {
                int prevIndex = deque.pop();
                res[prevIndex] = currIndex - prevIndex;
            }
            deque.push(currIndex);

        }
        return res;
    }

//    public int[] dailyTemperatures(int[] temperatures) {
//        int len = temperatures.length;
//        int[] res = new int[len];
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (temperatures[j] > temperatures[i]) {
//                    res[i] = j - i;
//                    break;
//                } else {
//                    res[i] = 0;
//                }
//            }
//        }
//        return res;
//    }
}
