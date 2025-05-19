package Leetcode;

//leetcode 209
//Time and Space Complexity =>    O(N) O(1)
public class Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        int target=7;
        System.out.println(minSubArrayLen(target,nums));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int window=0;
        int ans=Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            window+=nums[right];
            while (window >= target) {
                ans = Math.min(ans, right - left + 1);
                window -= nums[left]; // Shrink the window by moving left pointer
                left++;
            }
        }
        return ans;
    }
}
