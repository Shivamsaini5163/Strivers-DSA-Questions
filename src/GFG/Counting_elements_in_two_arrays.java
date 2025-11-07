package GFG;

import java.util.ArrayList;

public class Counting_elements_in_two_arrays {
    public static ArrayList<Integer> countLessEq(int[] a, int[] b) {
        int MAX = 100000; // constraint limit
        int[] freq = new int[MAX + 1];

        // Step 1: Frequency count of b[]
        for (int num : b) {
            freq[num]++;
        }

        // Step 2: Prefix sum array
        for (int i = 1; i <= MAX; i++) {
            freq[i] += freq[i - 1];
        }

        // Step 3: Build result for a[]
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : a) {
            result.add(freq[num]);
        }

        return result;
    }
}
