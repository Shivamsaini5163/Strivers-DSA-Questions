package Leetcode;

import java.util.Arrays;

//leetcode 435
//Similar to N meetings in one room (gfg question)
//Complexity =>   O(NlogN)     O(1)
public class Non_overlapping_Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a, b)->a[1]-b[1]);
        int cnt=1;
        int limit = intervals[0][1];
        for(int i = 1;i<n;i++) {
            if(intervals[i][0] >= limit) {
                limit = intervals[i][1];
                cnt++;
            }
        }
        return n-cnt;
    }
}
