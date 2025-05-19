package Leetcode;
//leetcode 53
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            max=Math.max(sum,max);
            if(sum<0)
                sum=0;
        }
        return max;
    }
    //if you have to print the sub array then use start and end pointers to have trace
    public int[] maxSubArrayPrint(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0, end = 0, tempStart = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
                //update your range
                start = tempStart;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                //shrinking the sub array
                tempStart = i + 1;
            }
        }
        // Extract the sub array from the original array
        int[] result = new int[end - start + 1];
        System.arraycopy(nums, start, result, 0, result.length);
        return result;
    }
}
