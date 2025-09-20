package GFG;

import java.util.Arrays;

public class Three_Great_Candidates {
    //    Key Observation:
//    1) Maximum product of three numbers can come from:
//    2) The three largest positive numbers.
//    3) Two smallest (most negative) numbers × largest positive number.
//    O(NlogN)
    int maxProduct(int[] arr) {
        int n = arr.length;
        // Sort the array in ascending order
        Arrays.sort(arr);
        // Return the maximum of product of last three
        // elements and product of first two elements
        // and last element
        return Math.max(arr[0] * arr[1] * arr[n - 1], arr[n - 1] * arr[n - 2] * arr[n - 3]);
    }

//    OR
//  We can do without sorting in O(n):
//  Track max1, max2, max3 → three largest numbers
//  Track min1, min2 → two smallest numbers
//  O(N)
    int maxProduct2(int[] arr) {
        int n = arr.length;
        // Initialize Maximum, second maximum and third maximum element
        int maxA = Integer.MIN_VALUE, maxB = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;
        // Initialize Minimum and second minimum element
        int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // Update Maximum, second maximum and third maximum element
            if (arr[i] > maxA) {
                maxC = maxB;
                maxB = maxA;
                maxA = arr[i];
            } else if (arr[i] > maxB) {
                maxC = maxB;
                maxB = arr[i];
            } else if (arr[i] > maxC) {
                maxC = arr[i];
            }

            // Update Minimum and second minimum element
            if (arr[i] < minA) {
                minB = minA;
                minA = arr[i];
            } else if (arr[i] < minB) {
                minB = arr[i];
            }
        }

        return Math.max(minA * minB * maxA, maxA * maxB * maxC);
    }
}
