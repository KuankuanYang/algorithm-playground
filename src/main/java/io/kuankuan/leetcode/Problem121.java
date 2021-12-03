package io.kuankuan.leetcode;

/**
 * 121. Best Time to Buy and Sell Stock
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * @author Kuankuan Yang
 * @date 2021-12-01 15:53
 */
public class Problem121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            // 如果当前价格更低，更新最低价
            if (price < minPrice) {
                minPrice = price;
            }
            // 如果当前收益最高，更新最高价
            if (price - minPrice > profit) {
                profit = price - minPrice;
            }
        }
        return profit;
    }
}
/**
 * 7 1 5 3 6 4
 * price minPrice profit
 * 7        7      0
 * 1        1      0
 * 5        1      4
 * 3        1      4
 * 6        1      5
 * 4        1      5
 * result = 5
 */