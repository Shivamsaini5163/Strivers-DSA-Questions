package Leetcode;
//leetcode 643
//Time and Space Complexity =>  O(N) O(1)
public class Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        int left=0;
        double ans=Integer.MIN_VALUE;
        double window=0;
        for(int i=0;i<k;i++){
            window+=nums[i];
        }
        ans=window/k;
        for(int right=k;right<nums.length;right++){
            window+=nums[right]-nums[left];
            left++;
            ans=Math.max(ans,window/k);
        }
        return ans;
    }
}
