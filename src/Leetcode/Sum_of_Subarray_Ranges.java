package Leetcode;

import java.util.Stack;

//leetcode 2104
public class Sum_of_Subarray_Ranges {
    //Brute Force   O(N^2)  O(1)
    public long subArrayRanges(int[] nums) {
        int n=nums.length;
        long sum=0;
        for(int i=0;i<n;i++){
            int largest=nums[i],smallest=nums[i];
            for(int j=i+1;j<n;j++){
                largest=Math.max(nums[j],largest);
                smallest=Math.min(nums[j],smallest);
                sum+=largest-smallest;
            }
        }
        return sum;
    }
    //Optimized Approach    O(N)   O(N)
    //Exactly Similar to Sum Of Subarray Minimums(leetcode 907)
    public long subArrayRanges2(int[] arr) {
        //PART 1
        int n=arr.length;
        int[] nse=new int[n];
        int[] pse=new int[n];
        Stack<Integer> stack=new Stack<>();       // using Monotonic Stack
        // next smaller element (to the right)
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack.clear();
        // previous smaller element (to the left)
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&arr[i]<arr[stack.peek()]){
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        long mins = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            mins += arr[i] * left  * right ;
        }
        stack.clear();
        //PART 2
        int[] nge=new int[n];
        int[] pge=new int[n];
        // next greater element (to the right)
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&arr[i]>=arr[stack.peek()]){
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        StringBuilder sb=new StringBuilder();

        stack.clear();
        // previous greater element (to the left)
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&arr[i]>arr[stack.peek()]){
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        long maxs = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            maxs += arr[i] * left  * right ;
        }
        return maxs-mins;
    }
}
