package Leetcode;
//leetcode 153
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]<nums[h]){
                h=mid;
            }else{
                l=mid+1;
            }
        }
        return nums[h];
    }
}
