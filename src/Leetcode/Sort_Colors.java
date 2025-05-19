package Leetcode;
//leetcode 75
//Time and Space Complexity =>    O(N) O(1)
public class Sort_Colors {
    public void sortColors(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int i=0;
        while(i<=r){
            if(nums[i]==0){
                swap(nums,i,l);
                l++;
                i++;
            }else if(nums[i]==1){
                i++;
            }else{
                swap(nums,i,r);
                r--;
            }
        }
    }
    void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
