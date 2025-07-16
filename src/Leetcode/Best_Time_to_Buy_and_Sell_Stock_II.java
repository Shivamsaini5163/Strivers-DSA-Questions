package Leetcode;
//leetcode 122
public class Best_Time_to_Buy_and_Sell_Stock_II {
    //Using Greedy Approach
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // If today's price > yesterday's, we make a profit
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
}
