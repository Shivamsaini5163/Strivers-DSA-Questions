package Leetcode;

//leetcode 918
public class Maximum_Sum_Circular_Subarray {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int curMax = 0, maxSum = nums[0];
        int curMin = 0, minSum = nums[0];

        for (int num : nums) {
            // Normal Kadane for maximum
            // Start a new subarray at this element → just take n
            // Extend the previous subarray → take sum + n
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            // Kadane for minimum (to find min subarray)
            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);

            totalSum += num; // keep total sum
        }

        // Edge case: if all numbers are negative
        if (maxSum < 0) return maxSum;

        // Otherwise: max of normal Kadane vs circular formula
        return Math.max(maxSum, totalSum - minSum);
    }
}
