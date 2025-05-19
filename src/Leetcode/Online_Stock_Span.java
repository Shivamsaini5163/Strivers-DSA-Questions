package Leetcode;

import java.util.Stack;
//leetcode 901
//Time and Space Complexity => O(1) O(N)
public class Online_Stock_Span {
    class StockSpanner {
        Stack<int[]> stack;
        public StockSpanner() {
            stack=new Stack<>();
        }

        public int next(int price) {
            int ans=1;
            //  monotonically decreasing stack
            //  0 index is price and 1 index is ans
            //  we need previous ans of those which are less or equal to given price
            while(!stack.isEmpty()&&stack.peek()[0]<=price){
                ans+=stack.pop()[1];
            }
            stack.push(new int[]{price,ans});
            return ans;
        }
    }
}
