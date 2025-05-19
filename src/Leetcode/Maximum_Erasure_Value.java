package Leetcode;

import java.util.HashSet;
//leetcode 1695
//Time and Space Complexity =>    O(N) O(N)
public class Maximum_Erasure_Value {
    public static void main(String[] args) {
        int[] nums={5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(nums));
    }
    public static int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int left=0;
        int window=0;
        int ans=0;
        for (int right = 0; right < nums.length ; right++) {
            window+=nums[right];
            while (set.contains(nums[right])){
                set.remove(nums[left]);
                window-=nums[left];
                left++;
            }
            set.add(nums[right]);
            ans=Math.max(ans,window);
        }
        return ans;
    }
}
