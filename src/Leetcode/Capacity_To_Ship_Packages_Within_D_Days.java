package Leetcode;
//leetcode 1011
//Optimized Approach    O(n*log(W sum))    O(1)
public class Capacity_To_Ship_Packages_Within_D_Days {
    public int shipWithinDays(int[] weights, int days) {
        int l=0;
        int h=0;
        for(int weight:weights){
            l=Math.max(l,weight);
            h+=weight;
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isPossible(mid,weights,days)) h=mid-1;
            else l=mid+1;
        }
        return l;
    }
    private boolean isPossible(int capacity,int[] weights,int days){
        int dayUsed = 1;
        int load = 0;

        for (int w : weights) {
            load += w;
            if (load > capacity) {   // exceed current day's capacity
                dayUsed++;
                load = w;
                if (dayUsed > days) return false;
            }
        }
        return dayUsed <= days;
    }
}
