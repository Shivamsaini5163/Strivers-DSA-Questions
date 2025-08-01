package Leetcode;

import java.util.Arrays;
import java.util.Stack;

//leetcode 503
public class Next_Greater_Element_II {
    // Brute Force O(N^2) O(N)
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n+i;j++){
                int idx=j%n;
                if(nums[i]<nums[idx]) {
                    res[i]=nums[idx];
                    break;
                }
            }
        }
        return res;
    }
    // Optimized Approach O(N) O(2*N)
    public int[] nextGreaterElements2(int[] nums) {
        int n=nums.length;
        int[] res=new int[nums.length];
        Stack<Integer> stack=new Stack<>(); // Using Monotonic Decreasing Stack
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty()&&stack.peek()<=nums[i%n]) stack.pop();
            if(i<n) {
                res[i]=stack.isEmpty()?-1:stack.peek();
            }
            stack.push(nums[i%n]);
        }
        return res;
    }
}
