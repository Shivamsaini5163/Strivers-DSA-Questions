package Leetcode;

import java.util.ArrayList;

//leetcode 57
//Complexity =>   O(N)    O(N) using Greedy Algorithm
public class Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        int i=0;
        ArrayList<int[]> list=new ArrayList<>();
        //left part
        while(i<n && intervals[i][1]<newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        //overlap part => merge it
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        //remaining part
        while(i<n){
            list.add(intervals[i]);
            i++;
        }
        // Convert list → 2D array
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;
    }
}
