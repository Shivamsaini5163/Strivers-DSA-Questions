package GFG;

import java.util.Arrays;

public class Aggressive_Cows {
    //Brute Force  O(n*(max - min))  O(1)
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int ans=-1;
        int max=stalls[0],min=stalls[stalls.length-1];
        for(int stall:stalls){
            min=Math.min(min,stall);
            max=Math.max(max,stall);
        }
        for(int i=1;i<=max-min;i++){
            if(canWePlace(i,stalls,k)) ans=i;
        }
        return ans;
    }
    static boolean canWePlace(int dist,int[] stalls,int k){
        //dist is the minimum distance allowed b/w cows
        int count=1;    // one cow has placed to first position
        int pos=0;      //to have trace that which position is last time used
        for(int j=1;j<stalls.length;j++){
            if(stalls[j]-stalls[pos]>=dist){
                count++;
                pos=j;  //update the position of last cow inserted
            }
        }
        return count>=k;// if counting of cows is greater than or equal to required cows
    }
    //Optimized Approach    O(n*log(max - min))  O(1)
    public static int aggressiveCows2(int[] stalls, int k) {
        Arrays.sort(stalls);
        int ans=-1;
        int max=stalls[0],min=stalls[stalls.length-1];;
        int l=1;
        int h=max-min;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(canWePlace(mid,stalls,k)) l=mid+1;
            else h=mid-1;
        }
        return h;
    }
}
