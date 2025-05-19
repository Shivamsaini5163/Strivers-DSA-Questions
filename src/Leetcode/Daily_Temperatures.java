package Leetcode;

import java.util.Arrays;
import java.util.Stack;
//leetcode 739
//Time and Space Complexity => O(N) O(N)
public class Daily_Temperatures {
    public static void main(String[] args) {
        int[] temp={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temp)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res=new int[temperatures.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty()&&temperatures[st.peek()]<temperatures[i]){
                int idx=st.pop();
                res[idx]=i-idx;
            }
            st.push(i);
        }
        return res;
    }
}
