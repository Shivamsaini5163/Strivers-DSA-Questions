package Leetcode;
//leetcode 121
public class Best_Time_to_Buy_and_Sell_Stock {
    //Brute Force
    public int maxProfit(int[] prices) {
        int ans=0;
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                ans=Math.max(ans,prices[j]-prices[i]);
            }
        }
        return ans;
    }
    //Optimize Approach
    public int maxProfit2(int[] prices) {
//        Track the lowest price so far, and at each step, calculate possible profit if you sell today.
//        Keep updating the maxProfit and minimum stock value.
        int ans=0;
        int minPrice=prices[0]; // suppose we buy the stock first day
        for(int i=1;i<prices.length;i++){
            ans=Math.max(ans,prices[i]-minPrice);   // try to sell it every day to see what max profit can i get
            minPrice=Math.min(minPrice,prices[i]);  // if that day stock price is lowest of all time then we buy stock this day
        }
        return ans;
    }
}
