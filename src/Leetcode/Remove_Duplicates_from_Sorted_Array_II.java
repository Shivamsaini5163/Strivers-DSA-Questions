package Leetcode;

//leetcode 80
public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int j=1;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){
                count++;
            }else{
                count=1;
            }
            if(count<=2){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
