package GFG;

public class Ceil_in_a_Sorted_Array {
    public int findCeil(int[] nums, int target) {
        // write code here
        int l=0;
        int h=nums.length-1;
        if(target>nums[h]){
            return -1;
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target){
                h=mid-1;
            }else if(nums[mid]>target){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}
