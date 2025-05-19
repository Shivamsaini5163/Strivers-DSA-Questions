package Leetcode;
//leetcode 31
public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        int idx=-1;
        //Start from back and find where our elements start decreasing instead of increasing and store that break point
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        //if no break point found that means we have largest no.so next iteration is smallest no., simply reverser the no.
        if(idx==-1){
            reverse(nums,0,n-1);
            return;
        }
        //find the number which is just greater than break point number and swap it with it
        for(int i=n-1;i>=idx+1;i--){
            if(nums[i]>nums[idx]){
                int temp=nums[i];
                nums[i]=nums[idx];
                nums[idx]=temp;
                break;
            }
        }
//        reverse the array from where break point occurs
        reverse(nums,idx+1,n-1);
    }
    private void reverse(int[] nums,int l,int h){
        while(l<h){
            int temp=nums[l];
            nums[l]=nums[h];
            nums[h]=temp;
            l++;
            h--;
        }
    }
}
