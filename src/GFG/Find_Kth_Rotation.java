package GFG;

import java.util.List;

public class Find_Kth_Rotation {
    public int findKRotation(List<Integer> nums) {
        int p=findPivot(nums);
        if(p==-1){
            return 0;
        }
        return p+1;
    }
    private static int findPivot(List<Integer> nums){
        for(int i=0;i<=nums.size()-2;i++){
            if(nums.get(i)>nums.get(i+1)){
                return i;
            }
        }
        return -1;
    }
    //more optimized to find pivot using binary search
    private static int findPivot2(List<Integer> nums){
        int l=0;
        int h=nums.size()-1;
        //Edge Cases
        if(nums.get(0)>nums.get(1)){
            return 0;
        }
        while(l<h){
            int mid=l+(h-l)/2;
            if(nums.get(mid)>nums.get(mid+1)){
                return mid;
            }else if(nums.get(mid)>=nums.get(l)){
                l=mid+1;
            }else{
                h=mid;
            }
        }
        return -1;
    }
}
