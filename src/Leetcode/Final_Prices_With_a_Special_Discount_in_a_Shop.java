package Leetcode;
import java.util.HashMap;
import java.util.Stack;
//leetcode 1475
//Time and Space Complexity => O(N) O(N)
public class Final_Prices_With_a_Special_Discount_in_a_Shop {
    //we are using monotonic stack
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<prices.length;i++){
            while(!stack.isEmpty()&&prices[stack.peek()]>=prices[i]){
                int idx=stack.pop();
                prices[idx]=prices[idx]-prices[i];
            }
            stack.push(i);  //put index on to stack not element
        }
        return prices;
    }
}
