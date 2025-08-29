package GFG;

import java.util.ArrayList;
import java.util.Arrays;

//Complexity => O(NlogN)   O(N) using greedy algo
public class Job_Sequencing_Problem {
    static class Job {
        int deadline, profit;
        Job(int d, int p) {
            deadline = d;
            profit = p;
        }
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n=deadline.length;
        Job[] jobs=new Job[n];
        for(int i=0;i<n;i++){
            jobs[i]=new Job(deadline[i],profit[i]);
        }
        // Sort by profit (descending)
        Arrays.sort(jobs,(a, b)->b.profit-a.profit);
        // Find max deadline to know how many slots we need
        int maxDeadline = 0;
        for(int d:deadline){
            maxDeadline=Math.max(maxDeadline,d);
        }
        int[] slot = new int[maxDeadline + 1]; // 1-indexed slots
        Arrays.fill(slot, -1);
        int countJobs = 0, maxProfit = 0;
        // Greedily assign jobs
        for(Job job:jobs){
            // Find a free slot for this job (from its deadline backwards)
            for(int t=job.deadline;t>0;t--){
                if(slot[t]==-1){    //free
                    slot[t]=1;  // mark slot used
                    countJobs++;
                    maxProfit+=job.profit;
                    break;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(countJobs);
        result.add(maxProfit);
        return result;
    }
}
