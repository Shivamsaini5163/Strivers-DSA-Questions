package Leetcode;
//leetcode 485
//Time and Space Complexity =>  O(N) O(1)
public class Max_Consecutive_Ones {
    //  Using Sliding Window Approach
    private int findMaxConsecutiveOnes(int[] nums) {
        int left=0;
        int ans=Integer.MIN_VALUE;
        int window=0;
        for(int right=0;right<nums.length;right++){
            window+=nums[right];
            while(right-left+1!=window){
                window-=nums[left];
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
    //  Second Method and More Simpler greedy approach
    private int findMaxConsecutiveOnes2(int[] nums) {
        int count=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            else{
                count=0;
            }
            ans=Math.max(ans,count);
        }
        return ans;
    }
}
