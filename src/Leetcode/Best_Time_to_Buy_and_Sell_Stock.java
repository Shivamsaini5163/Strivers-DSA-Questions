package Leetcode;
//leetcode 121
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int minimal=prices[0];
        int profit=0;   //in starting profit is 0 because 1st buy and sell on that day
        for(int j=1;j<prices.length;j++){
            int cost=prices[j]-minimal;
            profit=Math.max(profit,cost);
            minimal=Math.min(minimal,prices[j]);    //maintain a minimum value for in the left direction of current day
        }
        return profit;
    }
}
