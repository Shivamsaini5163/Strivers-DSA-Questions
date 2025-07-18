package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
//leetcode 128
public class Longest_Consecutive_Sequence {
    //using sorting technique
    //Time and Space Complexity    =>  O(NlogN)   O(1)
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 0) return 0;
        int ans = 1;
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                // skip duplicates
                continue;
            } else if (nums[i]-1 == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
    //Better Approach using HashSet
    //Time and Space Complexity    =>  O(N)   O(N)
    public int longestConsecutive2(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int longest=0;
        for(int num:set){
            if(!set.contains(num-1)){
                //it means it can be start of your longest consecutive sequence
                int length=1;
                //we check how long it can go
                while(set.contains(num+length)) length++;
                longest=Math.max(longest,length);
            }
        }
        return longest;
    }
}
