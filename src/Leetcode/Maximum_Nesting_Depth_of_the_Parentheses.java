package Leetcode;

import java.util.Stack;
//leetcode 1614
public class Maximum_Nesting_Depth_of_the_Parentheses {
    //Brute Force   Time=> O(N)   Space=>O(N)
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                max = Math.max(max, stack.size());
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        return max;
    }
    //Optimized Approach   Time=> O(N)   Space=>O(1)
    public int maxDepth2(String s) {
        int depth=0;
        int ans=0;
        int n=s.length();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                depth++;
            }else if(ch==')'){
                depth--;
            }
            ans=Math.max(ans,depth);
        }
        return ans;
    }
}
