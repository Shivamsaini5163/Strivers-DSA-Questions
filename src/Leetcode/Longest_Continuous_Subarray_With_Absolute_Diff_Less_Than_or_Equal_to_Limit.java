package Leetcode;

import java.util.ArrayDeque;
//leetcode 1438
//Time and Space Complexity => O(N) O(N)
public class Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> inc=new ArrayDeque<>(); //  Min at top
        ArrayDeque<Integer> dec=new ArrayDeque<>(); //  Max at top
        int res=0;
        int left=0;
        for (int right = 0; right < nums.length; right++) {
            while(!inc.isEmpty()&&inc.getLast()>nums[right]){
                inc.removeLast();
            }
            while(!dec.isEmpty()&&dec.getLast()<nums[right]){
                dec.removeLast();
            }
            inc.addLast(nums[right]);
            dec.addLast(nums[right]);
            while(dec.getFirst()-inc.getFirst()>limit){ //if condition false means out of range then stay in this while loop
                //check which stack is creating problem due to which limit exceed
                if(dec.getFirst()==nums[left]){
                    dec.removeFirst();
                }
                if (inc.getFirst()==nums[left]){
                    inc.removeFirst();
                }
                left++;
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
}
