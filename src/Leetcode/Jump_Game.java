package Leetcode;
//leetcode 55
//Time and Space Complexity => O(N) O(1)
public class Jump_Game {
    public boolean canJump(int[] nums) {
        int maxReach=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>maxReach){
                return false;
            }
            maxReach=Math.max(maxReach,i+nums[i]);
        }
        return true;
    }
}
