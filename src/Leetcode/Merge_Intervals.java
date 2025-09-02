package Leetcode;

import java.util.*;
//leetcode 56
public class Merge_Intervals {
    public static void main(String[] args) {
        int[][] arr={{1,3},{2,6},{8,10},{15,18}};
        for (int[] ele:merge2(arr)) {
            System.out.println(Arrays.toString(ele));
        }
    }
    //Brute Force   O(N^2)   O(N)
    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        boolean[] visited = new boolean[n];
        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int start = intervals[i][0];
            int end = intervals[i][1];
            visited[i] = true;

            for (int j = 0; j < n; j++) {
                if (visited[j]) continue;

                // Check for overlap
                if (intervals[j][0] <= end && intervals[j][1] >= start) {
                    start = Math.min(start, intervals[j][0]);
                    end = Math.max(end, intervals[j][1]);
                    visited[j] = true;
                    // Restart checking from the beginning
                    j = -1;
                }
            }
            merged.add(new int[]{start, end});
        }

        return merged.toArray(new int[merged.size()][]);
    }
    //Optimized Approach   O(NlogN)   O(N)
    public static int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // Step 1: sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);

        // Step 2: merge overlapping intervals
        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                // overlap → merge
                current[1] = Math.max(current[1], interval[1]);
            } else {
                // no overlap → new interval
                current = interval;
                result.add(current);
            }
        }

        // Step 3: convert List<int[]> → int[][]
        return result.toArray(new int[result.size()][]);
    }
}
