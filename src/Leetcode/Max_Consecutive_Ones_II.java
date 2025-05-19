package Leetcode;

//leetcode 487
//Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.
//Time and Space Complexity =>    O(N) O(1)
public class Max_Consecutive_Ones_II {
    public static void main(String[] args) {
        int[] arr={1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
    private static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int ans = Integer.MIN_VALUE;
        int window = 0;
        for (int right = 0; right < nums.length; right++) {
            window += nums[right];
            //Check there must be "Atmost" one 0 in window
            while (!(right - left == window ||right-left+1==window)) {
                window -= nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
