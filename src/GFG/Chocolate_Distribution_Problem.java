package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class Chocolate_Distribution_Problem {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // Edge cases
        if (m == 0 || arr.size() == 0) return 0;
        if (m > arr.size()) return -1;

        Collections.sort(arr);           // Sort the packets
        int n = arr.size();
        long minDiff = Long.MAX_VALUE;

        // Sliding window of size m
        for (int i = 0; i <= n - m; i++) {
            long diff = (long) arr.get(i + m - 1) - arr.get(i);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return (int) minDiff;
    }
}
