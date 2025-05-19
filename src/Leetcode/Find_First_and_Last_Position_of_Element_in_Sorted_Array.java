package Leetcode;

import java.util.Arrays;
//leetcode 34
//Time and Space complexity => O(logN) O(1)
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        int[] nums={5,7,7,7,8,8,10};
        int target=7;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        int[] ans={-1,-1};
        //Find start index Occurence
        while(s<=e){
            int mid=s+(e-s)/2;
            if (target==nums[mid]){
                ans[0]=mid;
                e=mid-1;
            } else if (target>nums[mid]) {
                s=mid+1;
            }else {
                e=mid-1;
            }
        }
        //Find last index Occurence
        s=0;
        e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if (target==nums[mid]){
                ans[1]=mid;
                s=mid+1;
            } else if (target>nums[mid]) {
                s=mid+1;
            }else {
                e=mid-1;
            }
        }
        return ans;
    }
}
