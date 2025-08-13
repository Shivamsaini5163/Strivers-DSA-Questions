package Leetcode;

//leetcode 1004
//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//Brute Force
//Time and Space Complexity =>    O(N^2) O(1)
public class Max_Consecutive_Ones_III {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int maxlen=0;
        for(int i=0;i<n;i++){
            int zeroes=0;
            for(int j=i;j<n;j++){
                if(nums[j]==0){
                    zeroes++;
                }
                if(zeroes>k){
                    break;
                }
                maxlen=Math.max(maxlen,j-i+1);
            }
        }
        return maxlen;
    }
    //Optimize Approach
    //Time and Space Complexity =>    O(2*N) O(1)
    public int longestOnes2(int[] nums, int k) {
        int left = 0;
        int zeroes = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroes++;
            // shrink window until we have at most k zeroes
            while (zeroes > k) {
                if (nums[left] == 0) zeroes--;
                left++;
            }
            // update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    // More Optimize Approach
    //Time and Space Complexity =>    O(N) O(1)
    public int longestOnes3(int[] nums, int k) {
        int left = 0;
        int zeroes = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroes++;
            // shrink window until we have at most k zeroes
            if (zeroes > k) {
                if (nums[left] == 0) zeroes--;
                left++;
            }
            // update max length
            if (zeroes <= k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen;
    }
}
