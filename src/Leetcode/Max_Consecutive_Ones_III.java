package Leetcode;

//leetcdoe 1004
//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//Time and Space Complexity =>    O(N) O(1)
public class Max_Consecutive_Ones_III {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int ans = Integer.MIN_VALUE;
        int window = 0;
        for (int right = 0; right < nums.length; right++) {
            window += nums[right];
            //Check there must be "Atmost" one 0 in window
            while (!(right-left+1-window <= k)) {
                window -= nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
