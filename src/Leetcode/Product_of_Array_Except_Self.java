package Leetcode;
//leetcode 238
public class Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        //Calculating Prefix and suffix product
        int n=nums.length;
        int[] ans=new int[n];
        int left=1;
        int right=1;
        //calculate product from left side
        for(int i=0;i<n;i++){
            ans[i]=left;
            left=left*nums[i];
        }
        //calculate product from right side
        for(int i=n-1;i>=0;i--){
            ans[i]*=right;
            right=right*nums[i];
        }
        return ans;
    }
}
