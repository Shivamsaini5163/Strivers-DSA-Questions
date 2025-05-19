package Leetcode;
//leetcode 81
public class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int k) {
        int l=0;
        int h=nums.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==k){
                return true;
            }
            //just shrink your range and other logic is same as Search in Rotated Sorted Array I
            if(nums[l]==nums[mid]&&nums[mid]==nums[h]){
                l++;
                h--;
            }else if(nums[l]<=nums[mid]){   //this means we enter in first half sorted array
                if(nums[l]<=k&&nums[mid]>=k){   //check is it in first half if yes then cancel second half of it
                    h=mid-1;
                }else{  //it in second half if yes then cancel first half of it
                    l=mid+1;
                }
            }else{  //this means we enter in second half sorted array
                if(nums[mid]<=k&&nums[h]>=k){   //it in second half if yes then cancel first half of it
                    l=mid+1;
                }else{
                    h=mid-1;    //first half if yes then cancel second half of it
                }
            }
        }
        return false;
    }
}
