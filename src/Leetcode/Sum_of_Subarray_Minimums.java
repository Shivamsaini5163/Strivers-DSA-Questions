package Leetcode;

import java.util.Stack;

//leetcode 907
public class Sum_of_Subarray_Minimums {
    // Brute Force Approach  O(N^2)   O(1)
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long res = 0;
        long mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                res = (res + min) % mod;
            }
        }
        return (int) res;
    }

    public int sumSubarrayMins2(int[] arr) {
        // Optimized Approach    O(N)   O(N)
        int n=arr.length;
        long MOD=1000000007;
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
        long res = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            res = (res + (arr[i] * left % MOD) * right % MOD) % MOD;
        }
        return (int) res;
    }
}
