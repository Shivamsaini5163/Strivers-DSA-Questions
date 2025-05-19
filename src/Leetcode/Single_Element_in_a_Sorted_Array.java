package Leetcode;
//leetcode 540
public class Single_Element_in_a_Sorted_Array {
    //Brute Force   O(N)
    public int singleNonDuplicate(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans^=nums[i];
        }
        return ans;
    }
    //Optimized Approach O(logN)
    public int singleNonDuplicate2(int[] nums) {
        int l=0;
        int h=nums.length-1;
        //Edge Cases
        if(nums.length==1||nums[0]!=nums[1]){
            return nums[0];
        }
        while(l<h){
            int mid=l+(h-l)/2;
            if(nums[mid]!=nums[mid+1]&&nums[mid-1]!=nums[mid]){
                return nums[mid];
            }
            else if((nums[mid]==nums[mid-1]&&mid%2==0)||(nums[mid]==nums[mid+1]&&mid%2==1)){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return nums[l];
    }
}
