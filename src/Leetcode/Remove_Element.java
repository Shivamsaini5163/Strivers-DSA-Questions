package Leetcode;
//leetcode 27
public class Remove_Element {
    public int removeElement(int[] nums, int val) {
        // using two pointers
        int k=0;    // keep trace where we find val last time and put non val to that position
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}
