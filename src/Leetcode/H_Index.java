package Leetcode;

import java.util.Arrays;

//leetcode 274
public class H_Index {
    //Brute Force   O(N^2)      O(1)
    public int hIndex(int[] citations) {
        int ans=-1;
        int n=citations.length;
        for(int i=0;i<=n;i++){
            //check for each i can be h-index or not
            int cnt=0;
            for(int j=0;j<n;j++){
                if(i<=citations[j]) cnt++;
            }
            if(i<=cnt){
                ans=i;
            }
        }
        return ans;
    }
    //Better Approach(Recommended Solution)       O(N)        O(N) using Count array
    public int hIndex2(int[] citations) {
        int n=citations.length;
        int[] count=new int[n+1];
        for(int c:citations){
            if(c>n){
                count[n]++;
            }else{
                count[c]++;
            }
        }
        int cnt=0;
        for(int i=n;i>=0;i--){
            //maintain at least count
            cnt+=count[i];
            //check for possible ans
            if(cnt>=i) return i;
        }
        return 0;
    }
    //Optimized Approach    O(NlogN)    O(1)
    public int hIndex3(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;
        for(int i=0;i<n;i++){
            int h=n-i;  //possible ans if condition satisfies
            //first check for 5 then 4...3...2...1
            if(h<=citations[i]){
                return h;
            }
        }
        return 0;
    }
}
