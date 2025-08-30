package GFG;

import java.util.Arrays;

//Complexity =>   O(NlogN)    O(1)
public class Shortest_Job_first {
    static int solve(int[] bt) {
        Arrays.sort(bt);
        int n=bt.length;
        int t=0,wt=0;
        for(int i=0;i<n;i++){
            wt+=t;
            t+=bt[i];
        }
        return wt/n;
    }
}
