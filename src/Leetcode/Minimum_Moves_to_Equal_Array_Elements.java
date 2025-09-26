package Leetcode;

import java.util.Arrays;

//leetcode 453
public class Minimum_Moves_to_Equal_Array_Elements {
//    O(diff×(n log n))
    public int minMoves(int[] nums) {
//        One important observation is, the order of operations does not matter, we always get the same count.
//        The naive approach increments all elements except the maximum one in each step until all elements become equal..
        int n=nums.length;
        Arrays.sort(nums);
        // Loop until all elements are equal
        int cnt=0;
        while(nums[0]!=nums[n-1]){
            // Increment all elements except the largest element
            for(int i=0;i<n-1;i++){
                nums[i]++;
            }
            cnt++;
            Arrays.sort(nums);  // Sort again after modifying the array
        }
        return cnt;
    }
//    Optimize Approach use formula
//    O(N)
    public int minMoves2(int[] nums) {
        // Incrementing n-1 elements is equivalent to decrementing 1 element.
        // because our main goal is to make them equivalent
        // so think like we want to make every element equals to minimum element  of array
        int min = Integer.MAX_VALUE;
        long sum = 0;  // long to avoid overflow
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return (int)(sum - (long)nums.length * min);
    }
}
