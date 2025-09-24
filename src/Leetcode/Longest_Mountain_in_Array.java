package Leetcode;

//leetcode 845
public class Longest_Mountain_in_Array {
    //  Brute Force O(N^2)
    public int longestMountain(int[] a) {
        int ans = 0;
        int n = a.length;
        // Iterate over the array
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int inc = 0, dec = 0;
            // Check increasing sequence
            while (j < n && a[j] > a[j - 1]) {
                inc = 1;
                j++;
            }
            // Check decreasing sequence
            while (j < n && a[j] < a[j - 1]) {
                dec = 1;
                j++;
            }
            // If a mountain is found, update max length
            if (inc == 1 && dec == 1) {
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    //  Optimize Approach O(N)
    public int longestMountain2(int[] arr) {
        int n = arr.length;
        int maxLen = 0;
        int i = 1; // start from second element

        while (i < n - 1) {
            // Check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;
                // Expand left while strictly increasing
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }
                // Expand right while strictly decreasing
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                // Update max length
                maxLen = Math.max(maxLen, right - left + 1);
                // Move i to the end of this mountain
                i = right + 1;
            } else {
                i++;
            }
        }
        return maxLen;
    }
}
