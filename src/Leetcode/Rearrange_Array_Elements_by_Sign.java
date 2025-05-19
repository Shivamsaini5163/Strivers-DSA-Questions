package Leetcode;
//leetcode 2149
//Time and Space Complexity =>    O(N) O(N)
public class Rearrange_Array_Elements_by_Sign {
    public int[] rearrangeArray(int[] nums) {
        int[] ans=new int[nums.length];
        int even=0;
        int odd=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans[even]=nums[i];
                even+=2;
            }else{
                ans[odd]=nums[i];
                odd+=2;
            }
        }
        return ans;
    }
}
