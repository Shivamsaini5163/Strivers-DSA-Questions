package Leetcode;
//leetcode 1838
import java.util.Arrays;
//Time and Space Complexity   =>  O(NlogN)   O(1)
public class Frequency_of_the_Most_Frequent_Element {
    //using sliding window
    public int maxFrequency(int[] nums, int k) {
        long sum=0;
        int n=nums.length;
        int ans=0;
        Arrays.sort(nums);
        int l=0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(nums[r] *(long)(r-l+1)>k+sum){
                sum-=nums[l];
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}
