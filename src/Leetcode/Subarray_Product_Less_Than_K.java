package Leetcode;

// leetcode 713
// using Sliding window
public class Subarray_Product_Less_Than_K {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // Edge case
        int l=0,count=0,n=nums.length;
        long product=1;
        for (int r = 0; r < n; r++) {
            product*=nums[r];
            while(l<=r && product>=k){
                product/=nums[l];
                l++;
            }
            count+=r-l+1;
        }
        return count;
    }
}
