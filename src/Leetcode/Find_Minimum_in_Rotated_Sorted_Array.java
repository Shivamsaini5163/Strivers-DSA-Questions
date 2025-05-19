package Leetcode;
//leetcode 153
public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int p=findPivot(nums);
        if(p==-1){
            return nums[0];
        }
        return nums[p+1];
    }
    private static int findPivot(int[] nums){
        for(int i=0;i<=nums.length-2;i++){
            if(nums[i]>nums[i+1]){
                return i;
            }
        }
        return -1;
    }
    //more optimized
    private static int findPivot2(int[] nums){
        int l=0;
        int h=nums.length-1;
        //Edge Cases
        if(nums.length==1){
            return -1;
        }
        while(l<h){
            int mid=l+(h-l)/2;
            if(nums[mid]>nums[mid+1]){
                return mid;
            }else if(nums[mid]>=nums[l]){
                l=mid+1;
            }else{
                h=mid;
            }
        }
        return -1;
    }
}
