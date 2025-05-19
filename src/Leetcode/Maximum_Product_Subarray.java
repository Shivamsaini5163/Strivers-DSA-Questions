package Leetcode;
//leetcode 152
public class Maximum_Product_Subarray {
    //Brute Force   O(N^2)
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int product=1;
            for(int j=i;j<n;j++){
                product*=nums[j];
                ans=Math.max(ans,product);
            }
        }
        return ans;
    }
    //Optimized Approach O(N)
    public int maxProduct2(int[] nums) {
        int n=nums.length;
        int ans=Integer.MIN_VALUE;
        int prefix=1,suffix=1;
        for(int i=0;i<n;i++){
            if(prefix==0) prefix=1;
            if(suffix==0) suffix=1;
            prefix*=nums[i];
            suffix*=nums[n-i-1];
            ans=Math.max(ans,Math.max(prefix,suffix));
        }
        return ans;
    }
}
