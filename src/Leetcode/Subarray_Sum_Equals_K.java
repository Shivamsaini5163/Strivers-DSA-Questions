package Leetcode;

import java.util.HashMap;
//leetcode 560
//Time and Space Complexity =>  O(N) O(N)
public class Subarray_Sum_Equals_K {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k));
    }
    public static int subarraySum(int[] nums, int k) {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0, 1);  //if nums={1,0,1} and k=1 so first index should also be included in ans because sum-k=>1-1 and
        // it search for 0 but initially 0 was not present in map
        // so it was not adding in ans to avoid this problem we include 0 one time
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
