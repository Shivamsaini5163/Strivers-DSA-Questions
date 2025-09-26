package Leetcode;

//leetcode 2134
public class Minimum_Swaps_to_Group_All_1s_Together_II {
    //    Space Complexity O(2*N)
    public int minSwaps(int[] arr) {
        // if circular array was not the case and array was simple then this question will be same as Minimum Swaps required to group all 1's together(GFG),
        // for circular array we use double array simulation
        // Using sliding window
        //  find the total ones
        int totalOnes = 0;
        int n = arr.length;
        for (int num : arr) {
            if (num == 1) totalOnes++;
        }
        if (totalOnes == 0) return 0;

        int count_ones = 0;
        int x = totalOnes;

        // Double the array to simulate circular wrap
        int[] doubled = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            doubled[i] = arr[i % n];
        }
        // Find 1's for first subarray
        // of length x
        for (int i = 0; i < x; i++) {
            if (doubled[i] == 1)
                count_ones++;
        }
        int maxOnes = count_ones;
        // using sliding window technique
        // to find max number of ones in
        // subarray of length x
        for (int i = 1; i < n; i++) {

            if (doubled[i - 1] == 1)
                count_ones--;

            if (doubled[i + x - 1] == 1)
                count_ones++;

            if (maxOnes < count_ones)
                maxOnes = count_ones;
        }
        // calculate number of zeros in
        // subarray of length x with
        // maximum number of 1's
        int numberOfZeroes = x - maxOnes;

        return numberOfZeroes;
    }

    //    Space Complexity O(1)
    //    Use modulo instead of double array simulation
    public int minSwaps2(int[] arr) {
        int totalOnes = 0;
        int n = arr.length;
        for (int num : arr) {
            if (num == 1) totalOnes++;
        }
        if (totalOnes == 0) return 0;

        int count_ones = 0;
        int x = totalOnes;

        for (int i = 0; i < x; i++) {
            if (arr[i] == 1)
                count_ones++;
        }
        int maxOnes = count_ones;

        for (int i = 1; i < n; i++) {
            if (arr[(i - 1) % n] == 1)
                count_ones--;
            if (arr[(i + x - 1) % n] == 1)
                count_ones++;
            if (maxOnes < count_ones)
                maxOnes = count_ones;
        }
        int numberOfZeroes = x - maxOnes;
        return numberOfZeroes;
    }
}
