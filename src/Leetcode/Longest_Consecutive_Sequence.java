package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
//leetcode 128
public class Longest_Consecutive_Sequence {
    //using sorting technique
    //Time and Space Complexity    =>  O(NlogN)   O(1)
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int n=nums.length;
        Arrays.sort(nums);
        int longest=1,count=0,lastSmaller=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            //when duplicates coming we do nothing just ignore it
            if(nums[i]-1==lastSmaller){
                count++;
            }
            else if(nums[i]!=lastSmaller){  //it means it is not fulfilling above condition and also it is not duplicates so new start comes
                count=1;
            }
            lastSmaller=nums[i];
            longest=Math.max(longest,count);
        }
        return longest;
    }
    //Better Approach using HashSet
    //Time and Space Complexity    =>  O(N)   O(N)
    public int longestConsecutive2(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longest=Integer.MIN_VALUE;
        for(int i:set){
            if(!set.contains(i-1)){
                //it means it can be start of your longest consecutive sequence
                int length=1;
                //we check how long it can go
                while(set.contains(i+length)){
                    length++;
                }
                longest=Math.max(longest,length);
            }
        }
        return longest;
    }
}
