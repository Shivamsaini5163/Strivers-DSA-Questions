package GFG;

public class Implement_Lower_Bound {
    int lowerBound(int[] nums, int target) {
        // code here
        int l=0;
        int h=nums.length-1;
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
