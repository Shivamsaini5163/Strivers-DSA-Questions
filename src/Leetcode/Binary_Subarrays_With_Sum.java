package Leetcode;

import java.util.HashMap;
//leetcode 930
//Time and Space Complexity =>  O(N) O(N)
public class Binary_Subarrays_With_Sum {
    public int numSubarraysWithSum(int[] nums, int k) {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum=sum+nums[i];
            if (map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}