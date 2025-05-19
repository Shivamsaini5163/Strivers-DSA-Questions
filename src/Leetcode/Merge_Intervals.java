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
    public static int[][] merge2(int[][] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        for (int i = 0; i < n; i++) {
            // if the current interval does not
            // lie in the last interval:
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }
            // if the current interval
            // lies in the last interval:
            else {
                ans.get(ans.size() - 1).set(1,Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }
        //Converting it
        int M=ans.size();
        int N=ans.get(0).size();
        int[][] res=new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                res[i][j]=ans.get(i).get(j);
            }
        }
        return res;
    }
}
