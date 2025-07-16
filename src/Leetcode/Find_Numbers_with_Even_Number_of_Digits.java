package Leetcode;
//leetcode 1295
public class Find_Numbers_with_Even_Number_of_Digits {
    public int findNumbers(int[] nums) {
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            int digits=(int)Math.log10(nums[i])+1;
            if((digits&1)==0) cnt++;
        }
        return cnt;
    }
}
