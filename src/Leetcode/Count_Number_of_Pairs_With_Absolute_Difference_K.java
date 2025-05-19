package Leetcode;

import java.util.HashMap;
//leetcode 2006
//Time and Space Complexity => O(N) O(N)
public class Count_Number_of_Pairs_With_Absolute_Difference_K {
    //Method 1 using HashMap
    public int countKDifference(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=map.getOrDefault(nums[i]+k,0);
            ans+=map.getOrDefault(nums[i]-k,0); //we are taking + and - both because 5 is ans for 7(5+k) and 3(5-k) also for k=2
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return ans;
    }
    //Method 2 using count array more optimized
    public int countKDifference2(int[] nums, int k) {
        int[] count=new int[101];
        int ans=0;
        for(int i=0;i<nums.length;i++){
            count[nums[i]]++;
        }
        for(int i=0;i<101-k;i++){
            ans+=count[i]*count[i+k]; //  multiply because of multiple elements forming permutations and combinations
        }
        return ans;
    }
}
