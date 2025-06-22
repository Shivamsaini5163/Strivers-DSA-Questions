package Leetcode;
//leetcode 1482
public class Minimum_Number_of_Days_to_Make_m_Bouquets {
    //Brute Force   O((max−min+1)*n)   O(1)
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length<m*k){
            return -1;  //we have less no. of flowers make bouquets
        }
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int num:bloomDay){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        for(int i=min;i<=max;i++){
            if(isPossible(i,bloomDay,m,k)) return i;
        }
        return -1;
    }
    private boolean isPossible(int day,int[] bloomDay,int m,int k){
        int bouquets = 0, count = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                count++;
                if (count == k) {
                    bouquets++;
                    count = 0; // reset after making 1 bouquet
                }
            }else {
                count = 0; // reset if flower hasn't bloomed
            }
        }
        return bouquets >= m;
    }
    //Optimized Approach   O(log(max−min+1)*n)   O(1)
    public int minDays2(int[] bloomDay, int m, int k) {
        if(bloomDay.length<(long)m*k){
            return -1;  //we have less no. of flowers make bouquets
        }
        int n=bloomDay.length;
        int l=Integer.MAX_VALUE,h=Integer.MIN_VALUE;
        for(int num:bloomDay){
            l=Math.min(l,num);
            h=Math.max(h,num);
        }
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isPossible(mid,bloomDay,m,k)) h=mid-1;
            else l=mid+1;
        }
        return l;
    }
}
