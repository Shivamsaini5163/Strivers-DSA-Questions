package Leetcode;

import java.util.ArrayList;
import java.util.List;

//leetcode 986
public class Interval_List_Intersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result=new ArrayList<>();
        int i=0, j=0;

        while(i<firstList.length && j<secondList.length){
            int start=Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            // If they intersect, add to result
            if(start<=end){
                result.add(new int[]{start,end});
            }
            // Move the pointer of the interval which ends first
            if (firstList[i][1] <= secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        // Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }
}
