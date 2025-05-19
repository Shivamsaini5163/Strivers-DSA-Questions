package GFG;

public class Number_of_occurrence {
    int countFreq(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;
        int start=-1;
        int end=-1;
        //find start index
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target){
                start=mid;
                h=mid-1;
            }else if(nums[mid]>target){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        if(start==-1){
            return 0;
        }
        l=0;
        h=nums.length-1;
        //find end index
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target){
                end=mid;
                l=mid+1;
            }else if(nums[mid]>target){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return end-start+1;
    }
}
