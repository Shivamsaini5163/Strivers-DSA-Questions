package GFG;

import java.util.Arrays;

public class Remove_minimum_elements {
    public int minRemoval(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int i = 0, j = 0;
        int maxLen = 0;

        // Two-pointer sliding window
        while (j < n) {
            // If condition is satisfied, move j forward
            if (2L * arr[i] >= arr[j]) {
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            } else {
                // Otherwise, move i forward to make condition true
                i++;
            }
        }

        // Minimum elements to remove = total - longest valid subarray
        return n - maxLen;
    }
}
